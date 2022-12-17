drop table PRODUCTS if exists;
create table IF NOT EXISTS PRODUCTS (id bigserial, name varchar(255), cost double, quantity int);
insert INTO PRODUCTS (name, cost, quantity) values ('product1', 100.1, 1), ('product2', 200.1, 2),('product3', 300.1, 3);
