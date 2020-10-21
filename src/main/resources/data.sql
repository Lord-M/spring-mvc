INSERT INTO accounts (user_name, balance) VALUES ('John_Doe', 50.00);

INSERT INTO product_categories (id, name) VALUES (1, 'Cereals');
INSERT INTO product_categories (id, name) VALUES (2, 'Meat');
INSERT INTO product_categories (id, name) VALUES (3, 'Fruits');
INSERT INTO product_categories (id, name) VALUES (4, 'Vegetables');

-- products

INSERT INTO products (id, product_name, category_id, price) VALUES (1, 'Buckwheat', 1, 20.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (2, 'Grain', 1, 20.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (3, 'Pearl barley', 1, 30.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (4, 'Rice', 1, 25.00);

INSERT INTO products (id, product_name, category_id, price) VALUES (5, 'Bacon', 2, 50.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (6, 'Beef', 2, 55.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (7, 'Chicken', 2, 50.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (8, 'Duck', 2, 55.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (9, 'Turkey', 2, 65.00);

INSERT INTO products (id, product_name, category_id, price) VALUES (10, 'Apple', 3, 20.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (11, 'Apricot', 3, 40.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (12, 'Banana', 3, 22.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (13, 'Blackberry', 3, 18.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (14, 'Blueberry', 3, 20.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (15, 'Cherry', 3, 32.00);

INSERT INTO products (id, product_name, category_id, price) VALUES (16, 'Potato', 4, 9.50);
INSERT INTO products (id, product_name, category_id, price) VALUES (17, 'Tomato', 4, 14.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (18, 'Beans', 4, 12.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (19, 'Broccoli', 4, 18.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (20, 'Cabbage', 4, 16.00);
INSERT INTO products (id, product_name, category_id, price) VALUES (21, 'Carrot', 4, 12.00);

-- discounts

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (1, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (2, 0.15, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (2, 0.35, DATEADD(DAY, 1, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (2, 0.25, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (3, 0.05, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (4, 0.07, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (5, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (6, 0.09, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (7, 0.07, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (8, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (9, 0.05, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (10, 0.07, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (11, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (12, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (13, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (14, 0.15, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (15, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (16, 0.07, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (17, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (18, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
    VALUES (19, 0.30, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (20, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));
--INSERT INTO discounts (product_id, value_decimal, start_from, due_to)
--    VALUES (21, 0.10, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, 10, CURRENT_TIMESTAMP));

