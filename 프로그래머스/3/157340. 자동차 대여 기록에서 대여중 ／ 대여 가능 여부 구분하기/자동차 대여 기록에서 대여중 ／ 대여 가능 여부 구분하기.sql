-- 
# select CAR_ID,
#     case 
#     when CAR_ID in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where "2022-10-16" between start_date and end_date)
#     then '대여중'
#     else '대여 가능'
#     end AVAILABILITY
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# group by 1
# order by 1 desc

-- 
select car_id,
    case
    when car_id in (select car_id from car_rental_company_rental_history where '2022-10-16' between start_date and end_date)
    then '대여중'
    else '대여 가능'
    end AVAILABILITY
from car_rental_company_rental_history
group by 1
order by 1 desc
