import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    class User {
        String username;
        String password;
        String email;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username){
            this.username=username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }
    }

    public static boolean function(User user, List<User> allUsers) {
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //2
            throw new RuntimeException("Mandatory information missing!"); //3
        }

        if (user.getUsername() == null){ //4
            user.setUsername(user.getEmail()); //5
        }

        int same = 1; //6
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //7
            same = 0; //8
            for (int i=0; i<allUsers.size(); i++) { //8.1, 8.2, 8.3
                User existingUser = allUsers.get(i); //9
                if (existingUser.getEmail() == user.getEmail()) { //10
                    same += 1; //11
                }
                if (existingUser.getUsername() == user.getUsername()) { //12
                    same += 1; //13
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //14
        String password = user.getPassword(); //15
        String passwordLower = password.toLowerCase(); //16

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //17
            return false; //18
        }
        else { //19
            if (!passwordLower.contains(" ")) { //20
                for (int i = 0; i < specialCharacters.length(); i++) { //21.1, 21.2, 21.3
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //22
                        return same == 0; //23
                    }
                }
            }
        }
        return false; //24
    }

    @Test
    public void everyBranchTest() {

        //Test case 1: user is null
        try {
            function(null, null);
            fail("Expected RuntimeException was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

        //Test case 2: user's password is null
        try {
            function(new User("Sara", null, "carovskasara@gmail.com"), null);
            fail("Expected RuntimeException was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

        //Test case 3: user's email is null
        try {
            function(new User("Sara", "password123", null), null);
            fail("Expected RuntimeException was not thrown.");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

        // Test case 4: user's username is null
        User user = new User(null, "password123", "carovskasara@gmail.com");
        function(user, null);
        assertEquals("carovskasara@gmail.com", user.getUsername());

        // Test case 5: all mandatory information is provided
        user = new User("Sara", "password123", "carovskasara@gmail.com");
        boolean result = function(user, null);
        assertFalse(result);
    }

    @Test
    public void multipleConditionTest() {

        // Test case 1: password contains username and length is less than 8
        User user = new User("sara", "passsara", "carovskasara@gmail.com");
        boolean result = function(user, null);
        assertFalse(result);

        // Test case 2: password does not contain username and length is less than 8
        user = new User("sara", "pass", "carovskasara@gmail.com");
        result = function(user, null);
        assertFalse(result);

        // Test case 3: password contains username and length is 8 or greater
        user = new User("sara", "passSara123", "carovskasara@gmail.com");
        result = function(user, null);
        assertFalse(result);

        // Test case 4: password does not contain username and length is 8 or greater
        user = new User("sara", "password123", "carovskasara@gmail.com");
        result = function(user, null);
        assertTrue(result);
    }
}
