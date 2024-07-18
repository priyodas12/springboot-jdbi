DO $$
BEGIN
    RAISE NOTICE 'Executing schema.sql';
END $$;

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE product_origin (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    country VARCHAR(100) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product_price (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);