-- create a database
CREATE DATABASE healthcare;
SHOW DATABASES;

-- create a user with password
CREATE USER 'hospital'@'localhost' identified BY 'hospital@pass';

-- grant all  prviledges 
GRANT ALL privileges on healthcare.* to 'hospital'@'localhost';
FLUSH privileges;