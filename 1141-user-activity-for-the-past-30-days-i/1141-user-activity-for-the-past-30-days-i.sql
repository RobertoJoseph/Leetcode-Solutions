/* Write your T-SQL query statement below */
select Activity.activity_date as day,  count(distinct user_id) as active_users
from Activity 
group by activity_date
having activity_date between '2019-06-28' and '2019-07-27'