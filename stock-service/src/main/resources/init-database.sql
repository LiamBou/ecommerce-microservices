-- Create schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS inventory;

-- Use the schema
SET search_path TO inventory;

-- Create the 'stock' table
CREATE TABLE IF NOT EXISTS stock (
                                     id SERIAL PRIMARY KEY,               -- Unique ID for each stock entry (auto-incrementing)
                                     article_id INT NOT NULL,             -- Product ID to identify the product (foreign key in a real system)
                                     quantity INT NOT NULL,               -- Quantity of the product in stock
                                     created_at TIMESTAMP DEFAULT NOW(),  -- Timestamp for when the entry was created
    updated_at TIMESTAMP DEFAULT NOW()   -- Timestamp for when the entry was last updated
    );

-- Create an index on product_id for faster lookups
CREATE INDEX idx_article_id ON stock (article_id);
