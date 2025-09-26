-- 2022년 8월부터 2022년 10월까지 대여 횟수 5회
-- 월별 자동차 id별 총 대여횟수 records
-- 월 기준 오름, 자동차 id 내림
-- 0이면 제회

with history as (
    select car_id, count(*) as cnt, start_date
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where DATE_FORMAT(start_date, '%Y-%m') >= '2022-08'
    group by car_id
    having cnt >= 5
)

select month(start_date) as MONTH, car_id, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where car_id in (select car_id from history)
group by car_id, MONTH
having RECORDS > 0 and month between 8 and 10
order by 1 asc, 2 desc;