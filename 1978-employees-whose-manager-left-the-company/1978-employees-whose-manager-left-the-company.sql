# Write your MySQL query statement below
select employee_id from 
    employees as t1 
    where 
    SALARY < 30000 AND 
    manager_id not 
    in (select employee_id from employees) OR NOT NULL
    ORDER BY EMPLOYEE_ID ASC ;