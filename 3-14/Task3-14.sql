問一
SELECT goods_code,goods_name,price FROM Goods_table WHERE price >= 20000

問二
SELECT store_name FROM store_table ORDER BY store_nameabc ASC

問三
SELECT B.store_name , C.goods_name , A.quantity FROM stock_table A join store_table B on
A.store_code = B.store_code
join goods_table C on
A.goods_code = C.goods_code

問四ノ一 
SELECT goods_name , AVG(price) AS AVG_price FROM goods_table group BY goods_name

問四ノ二
SELECT AVG(price) AS AVG_price FROM goods_table

問五
SELECT A.goods_code , C.goods_name , A.quantity FROM stock_table A join goods_table C on
A.goods_code = C.goods_code
WHERE A.store_code = 'EA03'

問六ノ一
INSERT INTO goods_table
(goods_code , goods_name , price , update_day)
VALUES
('M001','マフラー','4500','2026-01-15')

問六ノ二
SELECT * from goods_table

問七
INSERT INTO store_table
(store_code,store_name,store_nameabc,update_day)
VALUES
('EA09', '新宿店', 'SHINJUKUTEN', '2012-08-01'),
('WE03', '梅田店', 'UMEDETEN', '2013-02-01'),
('WE04', '福岡店', 'FUKUOKATEN', '2014-05-01');

問八
update stock_table
set quantity = 50
WHERE quantity >= 20

問九
UPDATE stock_table
set quantity = quantity + 10
where goods_code = 'S987'
AND store_code = 'EA01'

問十
DELETE FROM stock_table
WHERE goods_code = 'Z939'
AND store_code = 'EA04'
