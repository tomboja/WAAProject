# INSERT into USER (email, password, role, id)  VALUES (  'dean@email.com', 'Password1','SELLER', 4001);
# INSERT into USER (email, password, role, id)  VALUES ( 'jane@email.com','Password1', 'SELLER', 4002 );
# INSERT into USER (email, password, role, id)  VALUES (  'jason@email.com','Password1', 'SELLER', 4003);

INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (100, 'Dean', 'Jabo', 'dean@email.com', false);
INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (101, 'Jane', 'Togo', 'jane@email.com', false);
INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (102, 'Jason', 'Bourne', 'jason@email.com', false);

INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1000, 'Banana','The best banana ever',4.80, 'dean@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1001, 'React 101 Book','React is a good SPA library', 40.50, 'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1002, 'Spring Fundamentals','Spring is awesome', 30, 'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available)  VALUES (1003, 'SpringBoot For beginners','This is a module that works over spring modules', 20 ,'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1004, 'MacBook Pro','The best computer ever',1000, 'dean@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1005, 'Pro Angular 8','Angular framework book', 40.50, 'jane@email.com', true);



--
-- INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (1, 'USER');
-- INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (2, 'ADMIN');
--
-- insert into USER_ROLES(USER_ID, ROLE_ID) values (111, 2);
-- insert into USER_ROLES(USER_ID, ROLE_ID) values (112, 1);