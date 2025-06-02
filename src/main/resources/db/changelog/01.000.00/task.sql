--liquibase formatted sql
--changeset Yauheni Haikou:create_task_table localFilePath:01.000.00/address.sql

CREATE TABLE tasks
(
    id              UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    user_id         UUID         NOT NULL,
    title           VARCHAR(255) NOT NULL,
    description     TEXT,
    due_date        TIMESTAMPTZ,
    status          VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
    priority        VARCHAR(10)           DEFAULT 'MEDIUM',
    google_event_id VARCHAR(256),
    created_at      TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ  NOT NULL DEFAULT now()
);