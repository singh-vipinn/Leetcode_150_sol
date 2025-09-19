# Write your MySQL query statement below
-- select name from Employee
-- WHERE ID IN(SELECT managerId FROM Employee GROUP BY managerId HAVING COUNT(*)>4)

SELECT m.name
FROM Employee e
JOIN Employee m
ON e.managerId = m.id
GROUP BY m.id, m.name
HAVING COUNT(e.id) >=5