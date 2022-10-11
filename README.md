# stylebanana_repository
Text_repository
select sum(orders.num) as sum_num
from orders  
left outer 
join trade on orders.t_id = trade.t_id group by trade.t_id;
