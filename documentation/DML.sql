INSERT INTO usertypes (id, typetext) VALUES (usertype_seq.nextval,'Admin');
INSERT INTO usertypes (id, typetext) VALUES (usertype_seq.nextval,'Customer');
INSERT INTO usertypes (id, typetext) VALUES (usertype_seq.nextval,'Employee');

INSERT INTO items (id,itemname,price) VALUES (item_seq.nextval,'Iodized Salt',1.00);
INSERT INTO items (id,itemname,price) VALUES (item_seq.nextval,'Meat',4.50);
INSERT INTO items (id,itemname,price) VALUES (item_seq.nextval,'Coffee',20.12);

INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(user_seq.nextval,'Chen','Sia','+1(222)-981-7654','Chen.Sia@mail.com','Chen123',1);
INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(user_seq.nextval,'William','Shook','+1(555)-456-1234','William.Shook@mail.com','William123',2);
INSERT INTO users (id,fname,lname,phone,email,password,usertype) VALUES(user_seq.nextval,'David','Velez','+1(999)-145-7602','David.Velez@mail.com','David123',3);

INSERT INTO suppliers (id,suppliername,email) VALUES (supplier_seq.nextval,'Steven''s Coffee in a Dirty Van','Steven.Hang@mail.com');
INSERT INTO suppliers (id,suppliername,email) VALUES (supplier_seq.nextval,'John''s Meat Wagon','John.Meat@mail.com');

INSERT INTO inventory (id,item,packagedate,useby,stock) VALUES (invent_seq.nextval,3,TO_DATE('09/10/2018','MM/DD/YYYY'),TO_DATE('10/30/2018','MM/DD/YYYY'),200);
INSERT INTO inventory (id,item,packagedate,useby,stock) VALUES (invent_seq.nextval,2,TO_DATE('09/13/2018','MM/DD/YYYY'),TO_DATE('10/30/2018','MM/DD/YYYY'),14);

INSERT INTO supplieritems (id, supplier, item) VALUES (supplieritem_seq.nextval,1,3);
INSERT INTO supplieritems (id, supplier, item) VALUES (supplieritem_seq.nextval,2,2);

commit;