SELECT id
FROM Weather w
WHERE temperature > (
    SELECT temperature
    FROM Weather
    WHERE recordDate = DATE_SUB(w.recordDate, INTERVAL 1 DAY)
);