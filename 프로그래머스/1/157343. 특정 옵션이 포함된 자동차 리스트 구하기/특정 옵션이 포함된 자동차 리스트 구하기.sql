-- 코드를 입력하세요
SELECT car.car_id, car.car_type, car.daily_fee, car.options
from CAR_RENTAL_COMPANY_CAR as car
where options like "%네비게이션%"
order by 1 desc;