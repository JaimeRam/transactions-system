DROP
  TABLE IF EXISTS accounts;

DROP
  TABLE IF EXISTS transactions;

CREATE TABLE accounts (
  id int auto_increment primary key,
  iban varchar(24) unique not null,
  balance double DEFAULT 0,
  CHECK (balance >= 0)
);

CREATE TABLE transactions (
  id int auto_increment primary key,
  reference varchar(128) unique not null,
  account_iban varchar(24) not null,
  date timestamp,
  amount double,
  fee double,
  description varchar(128),
  foreign key (account_iban) references accounts(iban)
);