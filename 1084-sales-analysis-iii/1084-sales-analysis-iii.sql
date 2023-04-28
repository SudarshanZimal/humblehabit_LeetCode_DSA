# Write your MySQL query statement below
/*select product_id , product_name from Product (select sale_date from Sales where sale_date between 2019-01-01 and 2019-04-1); */

select product_id,product_name
from product natural join sales
group by product_id
having min(sale_date)>='2019-01-01' and max(sale_date)<='2019-03-31'