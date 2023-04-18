# Write your MySQL query statement below
/*select name from Employee JOIN  select bonus from Bonus where bonus < 1000 AND NOT IN --(select name from Employee to Bonus;*/
select Employee.name , Bonus.bonus from employee left outer join Bonus ON Employee.empid = Bonus.empid where bonus < 1000 or bonus IS NULL;