select id, 
    (case 
        when rank_num = 1 then 'CRITICAL'
        when rank_num = 2 then 'HIGH'
        when rank_num = 3 then 'MEDIUM'
        else 'LOW'
    end) as COLONY_NAME
from (
    select 
        id,
        NTILE(4) over (order by SIZE_OF_COLONY desc) as rank_num
    from ecoli_data
) as ranked
order by 1