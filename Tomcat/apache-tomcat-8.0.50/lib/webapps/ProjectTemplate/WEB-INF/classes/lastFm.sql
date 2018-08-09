CREATE TABLE EVENTS(
   EVENT_ID		BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 221, INCREMENT BY 1) PRIMARY KEY,
   DATE_TIME 	TIMESTAMP NOT NULL,
   EVENT_TYPE 	VARCHAR(50) NOT NULL,
   SMS_SENT 	BOOLEAN NOT NULL
);

CREATE TABLE EVENT_PROPERTIES(
   PROPERTY_ID		BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 256, INCREMENT BY 1) PRIMARY KEY,
   EVENT_ID			BIGINT NOT NULL,
   EVENT_KEY		VARCHAR(50) NOT NULL,
   EVENT_VALUE		VARCHAR(164) NOT NULL,
   CONSTRAINT fk_EVENT_ID FOREIGN KEY (EVENT_ID) REFERENCES EVENTS(EVENT_ID) 
);