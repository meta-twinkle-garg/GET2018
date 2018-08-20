use storefront;
DELIMITER $$
create function calculate_orders(month INT,year INT) RETURNS INT DETERMINISTIC
BEGIN
 DECLARE result INT;
 
 SET result=0;
 SELECT COUNT(id) INTO result from orders 
 where EXTRACT(Month from date_of_order_placed)=month AND
 EXTRACT(YEAR from date_of_order_placed)=year;
 
 return result;
END $$


DELIMITER $
create function get_month_of_maximum_orders(year INT) RETURNS INT DETERMINISTIC
BEGIN
 DECLARE maximum, count, month INT;
 SET maximum=0;
 SET month=0;
 while(count<=12) DO
  IF caculate_orders(count,year)>maximum then
  SET maximum=calculate_orders(count,year);
  SET month=count;
  END IF;
  SET count=count+1;
 END WHILE;

return month;
END$


SELECT get_month_of_maximum_orders(2018);











