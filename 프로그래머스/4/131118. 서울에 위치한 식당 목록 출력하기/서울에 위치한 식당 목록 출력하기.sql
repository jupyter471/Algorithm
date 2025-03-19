select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, round(avg(rv.review_score),2) as SCORE
from rest_info ri join rest_review rv using(rest_id)
where ri.address like '서울%'
group by rv.rest_id 
order by 6 desc, 4 desc;