CREATE TABLE IF NOT EXISTS todos (
    todoid      INTEGER  PRIMARY KEY AUTOINCREMENT
                         NOT NULL,
    description STRING   NOT NULL,
    userid      INTEGER  REFERENCES users (userid)
                         NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    userid   INTEGER PRIMARY KEY AUTOINCREMENT
                     NOT NULL,
    username STRING  NOT NULL
);