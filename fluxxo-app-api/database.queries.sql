-- ===========================================
-- SCHEMA: Criação de tabelas
-- ===========================================

create table users
(
    id               uuid primary key,
    name             varchar(255) not null,
    username         varchar(50) unique,
    email            varchar(100) not null unique,
    password         VARCHAR(120) not nulL,
    is_active        boolean,
    activation_token varchar(10),
    login_token      varchar(10),
    created_at       timestamp,
    updated_at       timestamp
);

create table categories
(
    id          uuid         not null primary key,
    color       varchar(7),
    created_at  timestamp(6),
    description varchar(255),
    is_default  boolean,
    name        varchar(255) not null,
    type        varchar(255) not null check (type in ('INCOME', 'EXPENSE')),
    updated_at  timestamp(6),
    user_id     uuid,
    primary key (id)
);

create table transactions
(
    id             uuid           not null primary key,
    amount         numeric(38, 2) not null,
    created_at     timestamp(6),
    description    varchar(255),
    notes          varchar(255)   not null,
    payment_method smallint       not null check (payment_method between 0 and 6),
    status         smallint       not null check (status between 0 and 3),
    updated_at     timestamp(6),
    category_id    uuid,
    user_id        uuid
);