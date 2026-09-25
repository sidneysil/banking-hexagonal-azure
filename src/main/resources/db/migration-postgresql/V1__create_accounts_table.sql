CREATE TABLE accounts (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    balance NUMERIC(19,2) NOT NULL DEFAULT 0.00
);