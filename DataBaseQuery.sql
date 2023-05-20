SELECT U.user_id, U.username, T.training_id, T.training_date, Count(T.training_id) AS count from User U 
JOIN Training_details T ON  U.user_id = T.user_id
GROUP BY u.user_id, T.training_id
HAVING COUNT(*) > 1
ORDER BY T.training_date DESC;