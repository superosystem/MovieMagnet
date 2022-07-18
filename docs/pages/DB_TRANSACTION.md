# Database transaction in Go Language
A clean way to implement database transaction in Golang.
In Case we need some operation :
1. We create a transfer record with amount equals to 10.
2. We create an entry record for account 1 with amount equals to -10, since money is moving out of this account.
3. We create another entry record for account 2, but with amount equals to 10, because money is moving in to this account.
4. Then we update the balance of account 1 by subtracting 10 from it.
5. And finally we update the balance of account 2 by adding 10 to it.

Why do we need database transaction ?
* We want our unit of work to be reliable and consistent, even in case of system failure.
* We want to provide isolation between programs that access the database concurrently.
* ACID (Atomicity, Consistency, Isolation, Durability)
    * A is Atomicity, which means either all operations of the transaction complete successfully, or the whole transaction fails, and everything is rolled back, the database is unchanged.
    * C is Consistency, which means the database state should remains valid after the transaction is executed. More precisely, all data written to the database must be valid according to predefined rules, including constraints, cascades, and triggers.
    * I is Isolation, meaning all transactions that run concurrently should not affect each other. There are several levels of isolation that defines when the changes made by 1 transaction can be visible to others. We will learn more about it in another lecture.
    * D, which stands for Durability. It basically means that all data written by a successful transaction must stay in a persistent storage and cannot be lost, even in case of system failure.
