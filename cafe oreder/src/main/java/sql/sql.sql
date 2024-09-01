use cafeorder;
desc user;
SELECT * FROM user;
desc product;
SELECT * FROM product;
desc orderlist;
SELECT * from orderlist;
desc order_product;
SELECT * FROM order_product;

DELETE FROM order_product;
DELETE FROM orderlist WHERE totalprice=20000;
INSERT INTO user(id,pass,name,mobile) VALUES("id1","pass1","name","010-1234-5678");




