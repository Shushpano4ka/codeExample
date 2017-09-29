--liquibase formatted sql

--changeset vadym.usyk@gmail.com:0

CREATE TABLE "user" (
  id              BIGINT PRIMARY KEY,
  role            VARCHAR(25)         NOT NULL,
  name            VARCHAR(100),
  login           VARCHAR(100) UNIQUE NOT NULL,
  password        VARCHAR(50)         NOT NULL,
  phone_number    VARCHAR(11),
  active          BOOLEAN,
  avatar_url      VARCHAR(150),
  activation_code VARCHAR(8)
);

CREATE TABLE token (
  id      BIGINT PRIMARY KEY,
  user_id BIGINT REFERENCES "user" ON DELETE CASCADE,
  token   TEXT UNIQUE
);

CREATE TABLE company (
  id               BIGINT PRIMARY KEY,
  name             VARCHAR(50) UNIQUE NOT NULL,
  phone_number     VARCHAR(11),
  site_url         VARCHAR(300),
  owner_id         BIGINT REFERENCES "user" ON DELETE CASCADE,
  company_birthday TIMESTAMP DEFAULT now()
);

CREATE TABLE category (
  id   BIGINT PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE brand (
  id   BIGINT PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE department_type (
  id   BIGINT PRIMARY KEY,
  type VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE department (
  id                 BIGINT PRIMARY KEY,
  company_id         BIGINT REFERENCES company ON DELETE CASCADE,
  department_type_id BIGINT REFERENCES department_type ON DELETE CASCADE,
  name               VARCHAR(100) NOT NULL,
  status             VARCHAR(30)  NOT NULL,
  status_description TEXT,
  site_url           VARCHAR(300),
  address            TEXT,
  rating             DECIMAL   DEFAULT NULL,
  image_url          VARCHAR(150),
  create_date        TIMESTAMP DEFAULT now(),
  update_date        TIMESTAMP DEFAULT now(),
  rating             DECIMAL
);

CREATE TABLE department_categories (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  category_id   BIGINT REFERENCES category ON DELETE CASCADE
);

CREATE TABLE comment (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  creator_id    BIGINT REFERENCES "user" ON DELETE CASCADE,
  parent_id     BIGINT               DEFAULT NULL,
  create_date   TIMESTAMP            DEFAULT now(),
  status        VARCHAR(15) NOT NULL DEFAULT 'MODERATED',
  image_url     TEXT
);

CREATE TABLE department_brands (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  brand_id      BIGINT REFERENCES brand ON DELETE CASCADE
);

CREATE TABLE department_moderators (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  moderator_id  BIGINT UNIQUE REFERENCES "user" ON DELETE CASCADE
);


CREATE TABLE user_favorite_departments (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  user_id       BIGINT REFERENCES "user" ON DELETE CASCADE
);

CREATE TABLE daily_chart (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  day           VARCHAR(15) NOT NULL,
  is_open       BOOLEAN DEFAULT FALSE,
  has_break     BOOLEAN DEFAULT FALSE,
  opening_hour  INT,
  closing_hour  INT,
  break_start   INT,
  break_stop    INT
);

CREATE TABLE phone_numbers (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  priopity      VARCHAR(15),
  number        VARCHAR(11)
);

CREATE TABLE password_recoveries (
  id           BIGINT PRIMARY KEY,
  user_id      BIGINT REFERENCES "user" ON DELETE CASCADE,
  new_password VARCHAR(30)  NOT NULL,
  token        VARCHAR(100) NOT NULL,
  update_time  TIMESTAMP DEFAULT now()
);

CREATE TABLE tag (
  id  BIGINT PRIMARY KEY,
  tag VARCHAR(30) UNIQUE
);

CREATE TABLE category_tags (
  id          BIGINT PRIMARY KEY,
  tag_id      BIGINT REFERENCES tag ON DELETE CASCADE,
  category_id BIGINT REFERENCES category ON DELETE CASCADE
);

CREATE TABLE similar_departments (
  id              BIGINT PRIMARY KEY,
  department_id   BIGINT REFERENCES department ON DELETE CASCADE,
  category_tag_id BIGINT REFERENCES category_tags ON DELETE CASCADE
);

CREATE TABLE users_avatar (
  id          BIGINT PRIMARY KEY,
  user_id     BIGINT REFERENCES "user" ON DELETE CASCADE,
  url         VARCHAR(150) NOT NULL,
  upload_date TIMESTAMP DEFAULT now()
);

CREATE TABLE department_rating (
  id            BIGINT PRIMARY KEY,
  department_id BIGINT REFERENCES department ON DELETE CASCADE,
  user_id       BIGINT REFERENCES "user" ON DELETE CASCADE,
  rating        INT NOT NULL
)

