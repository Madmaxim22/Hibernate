SELECT product_name
FROM netology.orders
         JOIN customers ON customers.id = orders.customer_id
WHERE customers.name = :name