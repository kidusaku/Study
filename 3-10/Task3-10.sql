/* ■ [回答]と記載のある箇所へ、1〜8の各課題内容に沿ったSQL文を記述しなさい。 */

-- 1. Staffテーブルから「経理部」に所属する社員の情報をすべて抽出してください。
SELECT * FROM staff Where section = '経理部'


-- 2. 在庫(Stocksテーブル)の在庫数(Quantity)が10以上25未満のものを抽出して下さい。
SELECT * FROM Stocks WHERE Quantity >=10
INTERSECT
SELECT * FROM Stocks WHERE Quantity <25
--未満だから＝はいらないはず


-- 3. INTERSECT演算子を使用して、Order_Headerテーブルで合計値(Total)が5000以上10000未満のものを抽出して下さい。
SELECT * FROM Order_Header WHERE Total >=5000
INTERSECT
SELECT * FROM Order_Header WHERE Total <10000
--未満だから＝はいらないはず


-- 4. 「関東」エリアの全店舗情報（店舗所在地と店舗情報）を抽出して下さい。※テーブル結合すること
SELECT * FROM area A join shop B on A.areacode=B.areacode where A.areaname = '関東'


-- 5. 在庫(Stocksテーブル)内の各商品の合計数量を抽出して下さい。
SELECT A.*,B.Total_quantity FROM Goods A join 
(select goodscode,sum(quantity) as Total_quantity from stocks GROUP BY goodscode) B ON 
A.goodscode = B.goodscode
/*苦労した点（メモ）
絞り込みをしたうえで、どうやってJOINするか。
絞り込みするテーブルをメインではなく、goodsのほうをメインとしておく。
そのうえでサブクエリで仮想テーブル（絞ったやつを作る）←ここは調べないと無理だった
*/



-- 6. 商品（Gods）テーブルから単価（UnitPrice)が5000円より高い商品の情報を全て抽出して下さい。
select * from goods where UnitPrice>5000


-- 7. Shopテーブルの全ての店舗コード（Shopcode）、店舗名（Shopname）を、所在地（areaname）とあわせて抽出してください。
SELECT A.Shopcode,A.Shopname,B.areaname FROM Shop A Join area B on A.areacode = B.areacode

-- 8. 「新宿」店の在庫数が10以上の商品の商品コード（GoodsCode）、商品名（GoodsName）、在庫数（quantity）を抽出して下さい。
SELECT A.GoodsCode,B.goodsname_B,A.quantity FROM 
(select * from stocks where quantity > 10 and shopcode = '001' ) A 
join (select goodscode , goodsname as goodsname_B from goods) B
ON A.goodscode = B.goodscode

/*メモ
SELECT A.GoodsCode,B.goodsname_B,A.quantity FROM 
(select * from stocks where quantity > 10 ) A 
join (select goodscode , goodsname as goodsname_B from goods) B
ON A.goodscode = B.goodscode

ここまでスムーズに行けたがand shopcode = '001'ここで躓いた。
シングルクォートがなくてエラー吐いた。型が違ってることに気づくのに数分かかってしまった
*/
