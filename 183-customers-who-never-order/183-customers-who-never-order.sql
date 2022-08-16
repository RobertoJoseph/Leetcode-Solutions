/* Write your T-SQL query statement below */
Select c.name as 'Customers' from Customers c 
left outer  join orders on c.id = orders.customerId
Where orders.id is NULL