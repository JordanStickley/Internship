CREATE TABLE YAHOO(
   ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
   FIRST_NAME varchar(64),
   LAST_NAME varchar(64),
   AGE INTEGER,
   START_DATE DATE,
   ACTIVE boolean
);

INSERT INTO YAHOO (FIRST_NAME, LAST_NAME, AGE, START_DATE, ACTIVE)
VALUES 
 ('Bob', 'Smith', 30, '2018-01-01', true)
,('Sue', 'Smith', 45, '2018-01-20', true)
,('Tim', 'Johnson', 28, '2018-02-15', true)
,('Alison', 'Johnson', 22, '2018-02-15', true)
,('Gabe', 'Rickman', 28, '2017-01-01', false)
,('Jennette', 'Sabine', 37, '2017-01-01', false)
;
