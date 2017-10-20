USE adlister_db;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ads;

CREATE TABLE users (
  id int unsigned NOT NULL AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE ads (
  id int unsigned NOT NULL AUTO_INCREMENT,
  user_id int UNSIGNED NOT NULL,
  title VARCHAR(50) NOT NULL,
  description VARCHAR(500) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);
