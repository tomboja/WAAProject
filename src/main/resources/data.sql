
INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (100, 'Dean', 'Jabo', 'dean@email.com', false);
INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (101, 'Jane', 'Togo', 'jane@email.com', false);
INSERT into SELLER (id, firstname, lastname, email, approved)  VALUES (102, 'Jason', 'Bourne', 'jason@email.com', false);

INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1000, 'Banana','The best banana ever',4.80, 'dean@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1001, 'React 101 Book','React is a good SPA library', 40.50, 'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1002, 'Spring Fundamentals','Spring is awesome', 30, 'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available)  VALUES (1003, 'SpringBoot For beginners','This is a module that works over spring modules', 20 ,'jane@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1004, 'MacBook Pro','The best computer ever',1000, 'dean@email.com', true);
INSERT into PRODUCT (id, name, description, price, seller_id, is_Available) VALUES (1005, 'Pro Angular 8','Angular framework book', 40.50, 'jane@email.com', true);
