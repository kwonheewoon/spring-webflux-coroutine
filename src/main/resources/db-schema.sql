DROP SEQUENCE IF EXISTS test.messages_id_seq;

CREATE SEQUENCE IF NOT EXISTS test.messages_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY messages.id;

ALTER SEQUENCE test.messages_id_seq
    OWNER TO postgres;


DROP TABLE IF EXISTS test.messages;

CREATE TABLE IF NOT EXISTS test.messages
(
    id bigint NOT NULL DEFAULT nextval('test.messages_id_seq'::regclass),
    text text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT messages_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS test.messages
    OWNER to postgres;