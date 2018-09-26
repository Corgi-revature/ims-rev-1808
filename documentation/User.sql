-- DCL
drop user imsapp cascade;

/* Drop can remove the "user" object from the system.
    We are currently connected to the "admin" user.
    We don't want to build our database on our admin user.
    We're going to make a user that only has the priveleges
    that are necessary for development */

--- create a user in the database
create user imsapp
-- with a password
identified by p4ssw0rd
-- on a tablespace
default tablespace users
-- add a temporary space
temporary tablespace temp
-- with this size
quota 10m on users;

-- WE need to be able to connect to another user
grant connect to imsapp;
-- The ability to create types
grant resource to imsapp;
-- the ability to alter and destroy types
-- grant dba to imsapp;
-- the ability to create a session for transactions
grant create session to imsapp;
--self explanatory
grant create table to imsapp;
grant create view to imsapp;

-- older versions of Oracle SQL required you to explicity grant the following
-- grant select, insert, update, delete, to imsapp;

commit;