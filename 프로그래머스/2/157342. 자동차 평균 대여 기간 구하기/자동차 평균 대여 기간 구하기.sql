-- 코드를 입력하세요
SELECT car_id as CAR_ID, round(avg(DATEDIFF(END_DATE,START_DATE))+1,1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY car
group by car_id
having avg(DATEDIFF(END_DATE,START_DATE))+1 >= 7
order by AVERAGE_DURATION desc, 1 desc;