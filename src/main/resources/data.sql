insert into accounts (iban, balance)
values
  (
    'ES9820385778983000760236', 3245.54
  );
insert into accounts (iban, balance)
values
  (
    'ES6604879643251647165385', 2347.38
  );
insert into transactions (
  reference, account_iban, date, amount,
  fee, description
)
values
  (
    '12345A', 'ES9820385778983000760236',
    '2019-07-16T16:55:42.000Z', 193.38,
    3.18, 'Restaurant payment'
  );
insert into transactions (
  reference, account_iban, date, amount,
  fee, description
)
values
  (
    '1545F', 'ES9820385778983000760236',
    '2021-07-16T16:55:42.000Z', 214.54,
    2.41, 'Fuel'
  );
insert into transactions (
  reference, account_iban, date, amount,
  fee, description
)
values
  (
    'DF554F', 'ES9820385778983000760236',
    '2021-07-16T16:55:42.000Z', 43.84,
    1.21, 'PayPal'
  );
insert into transactions (
  reference, account_iban, date, amount,
  fee, description
)
values
  (
    'LG545F', 'ES9820385778983000760236',
    '2023-07-16T16:55:42.000Z', 48.12,
    4.32, 'Netflix'
  );
insert into transactions (
  reference, account_iban, date, amount,
  fee, description
)
values
  (
    '67890B', 'ES6604879643251647165385',
    '2019-07-16T16:55:42.000Z', 45.25,
    4.24, 'Amazon'
  );
