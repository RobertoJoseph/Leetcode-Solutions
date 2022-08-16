SELECT employee_id,
CASE
    WHEN employee_id%2 != 0 AND name NOT LIKE 'M%' THEN salary else 0
END AS bonus
FROM Employees ORDER BY employee_id;