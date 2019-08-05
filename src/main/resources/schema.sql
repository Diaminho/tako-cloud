CREATE TABLE Types (
    id          INTEGER PRIMARY KEY auto_increment,
    name        VARCHAR(64) NOT NULL,
);

CREATE TABLE Ingredients (
  id          VARCHAR(16) PRIMARY KEY,
  name        VARCHAR(128) NOT NULL,
  type_id     INTEGER REFERENCES Types(id)
  );

CREATE TABLE Orders_Table (
    id          INTEGER PRIMARY KEY auto_increment,
    name         VARCHAR(128) NOT NULL,
    street         VARCHAR(128) NOT NULL,
    city         VARCHAR(128) NOT NULL,
    state         VARCHAR(128) NOT NULL,
    zip         VARCHAR(128) NOT NULL,
    cc_number         VARCHAR(128) NOT NULL,
    cc_expiration         VARCHAR(128) NOT NULL,
    cc_CVV       INTEGER NOT NULL,
    placed_at DATETIME NOT NULL

);


CREATE TABLE Tacos (
  id          INTEGER PRIMARY KEY auto_increment,
  name        VARCHAR(128) NOT NULL,
  created_at  DATETIME NOT NULL
);

CREATE TABLE Tacos_Ingredients (
  tacos_id     INTEGER REFERENCES Tacos(id),
  ingredients_id VARCHAR(16) REFERENCES Ingredients(id)
);