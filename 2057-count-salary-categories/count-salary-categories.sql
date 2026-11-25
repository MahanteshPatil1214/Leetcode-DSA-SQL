WITH CategoryCounts AS (
    SELECT 
        SUM(CASE WHEN income < 20000 THEN 1 ELSE 0 END) AS low_cnt,
        SUM(CASE WHEN income BETWEEN 20000 AND 50000 THEN 1 ELSE 0 END) AS avg_cnt,
        SUM(CASE WHEN income > 50000 THEN 1 ELSE 0 END) AS high_cnt
    FROM Accounts
)
SELECT 'Low Salary' AS category, low_cnt AS accounts_count FROM CategoryCounts
UNION ALL
SELECT 'Average Salary' AS category, avg_cnt AS accounts_count FROM CategoryCounts
UNION ALL
SELECT 'High Salary' AS category, high_cnt AS accounts_count FROM CategoryCounts;
