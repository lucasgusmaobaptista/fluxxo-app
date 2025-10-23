-- ===========================================
-- SCHEMA: Criação de tabelas
-- ===========================================

create table users(
    id uuid primary key,
    name varchar(255) not null,
    username  varchar(50) unique,
    email varchar(100) not null unique,
    password VARCHAR(120) not nulL,
    is_active boolean,
    activation_token varchar(10),
    login_token varchar(10),
    created_at timestamp,
    updated_at timestamp
)