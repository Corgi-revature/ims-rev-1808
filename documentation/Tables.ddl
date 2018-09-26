--DDL
DROP TABLE inventoryitems CASCADE CONSTRAINTS;
DROP TABLE usertypes CASCADE CONSTRAINTS;
DROP TABLE transactions CASCADE CONSTRAINTS;
DROP TABLE suppliers CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE supplieritems CASCADE CONSTRAINTS;
DROP TABLE deliveries CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;


DROP SEQUENCE user_seq;
DROP SEQUENCE delivery_seq;
DROP SEQUENCE supplieritem_seq;
DROP SEQUENCE supplier_seq;
DROP SEQUENCE item_seq;
DROP SEQUENCE order_seq;
DROP SEQUENCE usertype_seq;
DROP SEQUENCE tx_seq;

CREATE TABLE inventoryitems(
	id number(20) PRIMARY KEY,
	itemname varchar2(255),
	price number(10,2),
	stock number(20),
	packagedate date,
	useby date
);

CREATE TABLE usertypes(
	id number(20) PRIMARY KEY,
	typetext varchar2(255)
);

CREATE TABLE transactions(
	id number(20) PRIMARY KEY,
	created date,
	token varchar2(255),
	txid varchar2(255)
);

CREATE TABLE suppliers(
	id number(20) PRIMARY KEY,
	suppliername varchar2(255),
	email varchar(255)
);

CREATE TABLE users(
	id number(20) PRIMARY KEY,
	fname varchar2(255),
	lname varchar2(255),
	phone varchar2(255),
	email varchar2(255),
	password varchar2(255),
	usertype number(20),
	CONSTRAINT fk_usertype FOREIGN KEY (usertype) REFERENCES usertypes(id)
);

CREATE TABLE orders(
	id number(20) PRIMARY KEY,
	item number(20),
	amount number(20),
	userid number(20),
	transaction number(20),
	address varchar2(255),
	created date,
	CONSTRAINT fk_order_item FOREIGN KEY (item) REFERENCES inventoryitems(id),
	CONSTRAINT fk_order_user FOREIGN KEY (userid) REFERENCES users(id),
	CONSTRAINT fk_order_transaction FOREIGN KEY (transaction) REFERENCES transactions(id)
);

CREATE TABLE supplieritems(
	id number(20) PRIMARY KEY,
	supplier number(20),
	item number(20),
	CONSTRAINT fk_supplier_item FOREIGN KEY (item) REFERENCES inventoryitems(id),
	CONSTRAINT fk_suppliers FOREIGN KEY (supplier) REFERENCES suppliers(id)
);

CREATE TABLE deliveries(
	id number(20) PRIMARY KEY,
	item number(20),
	amount number(20),
	datereceived date,
	CONSTRAINT fk_deliver_item FOREIGN KEY (item) REFERENCES inventoryitems(id)
);



CREATE SEQUENCE user_seq;
CREATE SEQUENCE delivery_seq;
CREATE SEQUENCE supplieritem_seq;
CREATE SEQUENCE supplier_seq;
CREATE SEQUENCE item_seq;
CREATE SEQUENCE order_seq;
CREATE SEQUENCE usertype_seq;
CREATE SEQUENCE tx_seq;