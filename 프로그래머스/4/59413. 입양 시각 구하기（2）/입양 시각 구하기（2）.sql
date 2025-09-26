-- 코드를 입력하세요
WITH RECURSIVE hours AS (
    SELECT 0 AS h            -- 초기값 (시작은 0)
    UNION ALL
    SELECT h + 1 FROM hours  -- 이전 결과에서 h+1
    WHERE h < 23             -- 23까지 반복
)

select h as HOUR, coalesce(count(animal_id),0) as COUNT
from hours 
left join ANIMAL_OUTS a
on HOUR(a.datetime) = hours.h
group by h
order by 1;