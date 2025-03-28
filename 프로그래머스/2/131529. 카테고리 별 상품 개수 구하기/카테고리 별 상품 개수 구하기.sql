-- 코드를 입력하세요
SELECT left(product_code,2) as CATEGORY, count(product_id) as products
from product
group by left(product_code,2)
order by 1;