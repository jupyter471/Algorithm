-- 코드를 작성해주세요
select count(*) as FISH_COUNT, MONTH(f.time) as MONTH
from fish_info f
group by MONTH
order by MONTH;