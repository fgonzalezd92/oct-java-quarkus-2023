* In this lab you’ll practice working with **ORM relationships, Exception Handling, ActiveRecord or Repository** pattern with Quarkus

* Create a table __accounts__ with 3 columns

```
account_number varchar(40) primary key
owner varchar(100)
balance int
```

* insert two accounts directly into the database

```
INSERT INTO accountsdb.accounts VALUES('acc101', 'John', 20000);
INSERT INTO accountsdb.accounts VALUES('acc102', 'Ram', 10000);
```

* Create a table __account-transactions__ with 4 columns

```
id number primary key auto_increment
account_number varchar(40)
amount int
transaction_type varchar(100)
```


* Define the Entity classes. Capture the relationship between accounts and account-transactions
* Implement the following in a **BankService** and **BankResource** classes with appropriate mappings

```
deposit  (pass the account number, amount and type(Salary, Dividend, etc.,) 
withdraw (pass the account number, amount and type(Interest, Card charges etc.,)); check for available balance
printStatement for an account number (return a list of transactions)
```

* The **deposit** and **withdraw** methods *update the balance* in accounts table and *insert a record* in the account_transactions table
* Throw exceptions if the account number does not exist or balance is inadequate
* Use ActiveRecord or Repository pattern





















