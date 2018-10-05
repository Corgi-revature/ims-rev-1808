--DDL
DROP TABLE items CASCADE CONSTRAINTS;
DROP TABLE usertypes CASCADE CONSTRAINTS;
DROP TABLE transactions CASCADE CONSTRAINTS;
DROP TABLE suppliers CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE deliveries CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE inventory CASCADE CONSTRAINTS;


DROP SEQUENCE user_seq;
DROP SEQUENCE delivery_seq;
DROP SEQUENCE supplieritem_seq;
DROP SEQUENCE supplier_seq;
DROP SEQUENCE item_seq;
DROP SEQUENCE order_seq;
DROP SEQUENCE usertype_seq;
DROP SEQUENCE tx_seq;
DROP SEQUENCE invent_seq;

CREATE TABLE items(
	id number(20) PRIMARY KEY,
	itemname varchar2(255),
	price number(10,2)
    );
    
CREATE TABLE inventory(
	id number(20) PRIMARY KEY,
	item number(20),
	packagedate varchar2(255),
	useby varchar2(255),
	stock number(20),
	CONSTRAINT fk_item_inventory FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE
	);

CREATE TABLE usertypes(
	id number(20) PRIMARY KEY,
	typetext varchar2(255)
);

CREATE TABLE transactions(
	id number(20) PRIMARY KEY,
	created varchar2(255),
	token varchar2(255),
	txid varchar2(255),
    status varchar2(255)
);

CREATE TABLE suppliers(
	id number(20) PRIMARY KEY,
	suppliername varchar2(255),
    itemsup number(20),
	email varchar(255),
    CONSTRAINT fk_sup_item FOREIGN KEY (itemsup) REFERENCES items(id) ON DELETE CASCADE
);

CREATE TABLE users(
	id number(20) PRIMARY KEY,
	fname varchar2(255),
	lname varchar2(255),
	phone varchar2(255),
	email varchar2(255),
	password varchar2(255),
	usertype number(20),
	CONSTRAINT fk_usertype FOREIGN KEY (usertype) REFERENCES usertypes(id) ON DELETE CASCADE
);

CREATE TABLE orders(
	id number(20) PRIMARY KEY,
	inventoryitem number(20),
	amount number(20),
	userid number(20),
	transaction number(20),
	address varchar2(255),
	created varchar2(255),
	CONSTRAINT fk_order_item FOREIGN KEY (inventoryitem) REFERENCES items(id) ON DELETE CASCADE,
	CONSTRAINT fk_order_user FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_order_transaction FOREIGN KEY (transaction) REFERENCES transactions(id) ON DELETE CASCADE
);

CREATE TABLE deliveries(
	id number(20) PRIMARY KEY,
	item number(20),
	amount number(20),
	datereceived varchar2(255),
	supplier number(20),
    CONSTRAINT fk_deliver_supplier FOREIGN KEY (supplier) REFERENCES suppliers(id) ON DELETE CASCADE,
	CONSTRAINT fk_deliver_item FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE
);



CREATE SEQUENCE user_seq;
CREATE SEQUENCE delivery_seq;
CREATE SEQUENCE supplieritem_seq;
CREATE SEQUENCE supplier_seq;
CREATE SEQUENCE item_seq;
CREATE SEQUENCE order_seq;
CREATE SEQUENCE usertype_seq;
CREATE SEQUENCE tx_seq;
CREATE SEQUENCE invent_seq;