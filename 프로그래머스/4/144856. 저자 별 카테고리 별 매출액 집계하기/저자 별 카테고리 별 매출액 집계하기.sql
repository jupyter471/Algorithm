-- 2022 1월 기준
-- 저자별, 카테고리별 매출액
-- 

select a.author_id, a.author_name, b.category, sum(b.price * total) as total_sales
from book b
join (select book_id, sum(sales) as total from BOOK_SALES where year(sales_date) = 2022 and month(sales_date) = 1 group by book_id) bs
on b.book_id = bs.book_id
join author a on a.author_id = b.author_id
group by author_id, category
order by 1, 3 desc