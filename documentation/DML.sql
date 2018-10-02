INSERT INTO usertypes (id, typetext) VALUES (1,'Admin');
INSERT INTO usertypes (id, typetext) VALUES (2,'Customer');
INSERT INTO usertypes (id, typetext) VALUES (3,'Employee');

INSERT INTO items (id,itemname,price) VALUES (1,'Iodized Salt',1.00);
INSERT INTO items (id,itemname,price) VALUES (2,'Meat',4.50);
INSERT INTO items (id,itemname,price) VALUES (3,'Coffee',20.12);

INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(1,'Chen','Sia','+1(222)-981-7654','Chen.Sia@mail.com','Chen123',1);
INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(2,'William','Shook','+1(555)-456-1234','William.Shook@mail.com','William123',2);
INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(3,'David','Velez','+1(999)-145-7602','David.Velez@mail.com','David123',3);

INSERT INTO suppliers (id,suppliername,email) VALUES (1,'Steven''s Coffee in a Dirty Van','Steven.Hang@mail.com');
INSERT INTO suppliers (id,suppliername,email) VALUES (2,'John''s Meat Wagon','John.Meat@mail.com');

INSERT INTO inventory (id,item,packagedate,useby,stock) VALUES (1,3,TO_DATE('09/10/2018','MM/DD/YYYY'),TO_DATE('10/30/2018','MM/DD/YYYY'),200);
INSERT INTO inventory (id,item,packagedate,useby,stock) VALUES (2,2,TO_DATE('09/13/2018','MM/DD/YYYY'),TO_DATE('10/30/2018','MM/DD/YYYY'),14);

INSERT INTO supplieritems (id, supplier, item) VALUES (1,1,3);
INSERT INTO supplieritems (id, supplier, item) VALUES (2,2,2);

commit;