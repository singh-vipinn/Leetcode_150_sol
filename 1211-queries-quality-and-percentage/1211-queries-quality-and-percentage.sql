

SELECT query_name,
round(avg(rating*1.0 / position), 2) as
quality,
ROUND(SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100.0/ COUNT(*), 2) AS
poor_query_percentage
FROM Queries
group by query_name;