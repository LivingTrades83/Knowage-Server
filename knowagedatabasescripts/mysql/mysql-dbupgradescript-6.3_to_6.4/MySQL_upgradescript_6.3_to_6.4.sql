ALTER TABLE SBI_CROSS_NAVIGATION ADD COLUMN DESCRIPTION VARCHAR(200) NULL DEFAULT NULL,
								 ADD COLUMN BREADCRUMB VARCHAR(200) NULL DEFAULT NULL;
								 
CREATE TABLE SBI_NEWS (
  ID int(11) NOT NULL,
  NAME varchar(200) DEFAULT NULL,
  DESCRIPTION varchar(400) DEFAULT NULL,
  ACTIVE tinyint(4) DEFAULT 1,
  NEWS varchar(4000) DEFAULT NULL,
  MANUAL tinyint(4) DEFAULT 1,
  EXPIRATION_DATE timestamp NULL DEFAULT NULL,
  USER_IN varchar(100) NOT NULL,
  USER_UP varchar(100) DEFAULT NULL,
  USER_DE varchar(100) DEFAULT NULL,
  TIME_IN timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  TIME_UP timestamp NULL DEFAULT NULL,
  TIME_DE timestamp NULL DEFAULT NULL,
  SBI_VERSION_IN varchar(10) DEFAULT NULL,
  SBI_VERSION_UP varchar(10) DEFAULT NULL,
  SBI_VERSION_DE varchar(10) DEFAULT NULL,
  META_VERSION varchar(100) DEFAULT NULL,
  ORGANIZATION varchar(20) DEFAULT NULL,
  CATEGORY_ID int(11) DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_SBI_DOMAINS_VALUE_ID FOREIGN KEY (CATEGORY_ID) REFERENCES SBI_DOMAINS (VALUE_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE SBI_NEWS_READ (
  ID int(11) NOT NULL,
  USER_ID varchar(100) NOT NULL,
  NEWS_ID int(11) NOT NULL,
  USER_IN varchar(100) NOT NULL,
  USER_UP varchar(100) DEFAULT NULL,
  USER_DE varchar(100) DEFAULT NULL,
  TIME_IN timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  TIME_UP timestamp NULL DEFAULT NULL,
  TIME_DE timestamp NULL DEFAULT NULL,
  SBI_VERSION_IN varchar(10) DEFAULT NULL,
  SBI_VERSION_UP varchar(10) DEFAULT NULL,
  SBI_VERSION_DE varchar(10) DEFAULT NULL,
  META_VERSION varchar(100) DEFAULT NULL,
  ORGANIZATION varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_SBI_NEWS_NEWS_ID FOREIGN KEY (NEWS_ID) REFERENCES SBI_NEWS (ID) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB;


CREATE TABLE SBI_NEWS_ROLES (
  NEWS_ID int(11) NOT NULL,
  EXT_ROLE_ID int(11) NOT NULL,
  PRIMARY KEY (NEWS_ID,EXT_ROLE_ID),
  CONSTRAINT FK_SBI_EXT_ROLES_EXT_ROLE_ID FOREIGN KEY (EXT_ROLE_ID) REFERENCES SBI_EXT_ROLES (EXT_ROLE_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT FK_SBI_NEWS_ID FOREIGN KEY (NEWS_ID) REFERENCES SBI_NEWS (ID) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB;