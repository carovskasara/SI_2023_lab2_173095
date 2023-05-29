**Втора лабораториска вежба по Софтверско инженерство**

**Сара Царовска, бр. на индекс 173095**

**Група на код:**

Лабораториска вежба 2

**Control Flow Graph**

2. Фотографија од control flow graph-ot

**Цикломатска комплексност**

3. Цикломатската комплексност на овој код е 9, истата ја добив преку
   бројот на региони. Бројот на региони е 9 значи толку е компелксноста
   и има толку неазвисни патеки во графот. 
   - Може и преку бројот на јазли и ребра. 
     Број на ребра - број на јазли + 2.
     36 - 29 + 2 = 9. 
   - Друг начин е и преку предикатните јазли Р + 1.
     Број на предикатни јазли Р = 8 (јазелот 1,2, потоа 4, 7, 10, 12, 17, 19 и 20) па
     оддтука следува 8 + 1 = 9.

**Тест случаи според критериумот Every branch**

4. Тест случаи за првиот if услов (branch 2-3):
    Test case 1: user е null.
    Test case 2: user.getPassword() е null.
    Test case 3: user.getEmail() е null.
    Test case 4: Сите задолжителни информации се пополнети.
   
    Тест случаи за вториот if услов (branch 4-5):
    Test case 5: user.getUsername() е null.
    Test case 6: user.getUsername() не е null.

    Тест случаи за for циклусот и условите во циклусот (branch 8-13):
    Test case 7: user.getEmail() не содржи "@" или ".".
    Test case 8: user.getEmail() содржи "@" и "." но нема мејлови или кориснички имиња кои се совпаѓаат во allUsers.
    Test case 9: user.getEmail() содржи "@" и ".", и има мејл кој се совпаѓа во allUsers.
    Test case 10: user.getEmail() содржи "@" и ".", и има корисничко име кое се совпаѓа во allUsers.
    Test case 11: user.getEmail() содржи "@" и ".", и има мејл и корисничко име кои се совпаѓаат во allUsers.

    Тест случаи за условите и циклусите после првиот for циклус (branch 17-24):
    Test case 12: passwordLower содржи user.getUsername().toLowerCase() и password.length() е помал 8.
    Test case 13: passwordLower не содржи user.getUsername().toLowerCase() и password.length() е помал 8.
    Test case 14: passwordLower содржи user.getUsername().toLowerCase() и password.length() е 8 или поголем.
    Test case 15: passwordLower не содржи user.getUsername().toLowerCase() и password.length() е 8 или поголем.
   
    Тест случаи кои го покриваат for циклусот за специјални карактери (branch 21-23):
    Test case 16: passwordLower не содржи празни места и содржи барем еден карактер од specialCharacters.


**Тест случаи според критериумот Multiple condition за условот
  if (user == null || user.getPassword() == null || user.getEmail() == null)**

5. Test case 1: Сите услови да се точни (user е null, password е null, email е null).
   Влез: user = null, allUsers = [user1, user2, user3].
   Очекуван излез: RuntimeException со порака "Mandatory information missing!".
   
   Test case 2: User е null.
   Влез: user = null, allUsers = [user1, user2, user3].
   Очекуван излез: RuntimeException со порака "Mandatory information missing!".

   Test case 3: Password e null.
   Влез: user = new User("John", null, "carovskasara@gmail.com"), allUsers = [user1, user2, user3].
   Очекуван излез: RuntimeException со порака "Mandatory information missing!".

   Test case 4: Email e null.
   Влез: user = new User("John", "password123", null), allUsers = [user1, user2, user3].
   Очекуван излез: RuntimeException со порака "Mandatory information missing!".
   
   Test case 5: Ниеден услов не е точен.
   Влез: user = new User("Sara", "password123", "carovskasara@gmail.com"), allUsers = [user1, user2, user3].
   Очекуван излез: Не фрла исклучок.


**Објаснување на напишаните unit tests**

6. Напишаниот тест јунит се однесува на исклучоците кои ги фрла
   функцијата при зададени вредности при извршувањето
