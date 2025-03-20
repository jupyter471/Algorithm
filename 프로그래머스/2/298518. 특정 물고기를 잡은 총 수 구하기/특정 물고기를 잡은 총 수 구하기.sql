-- 코드를 작성해주세요
select count(*) AS FISH_COUNT
from FISH_INFO i inner join FISH_NAME_INFO n on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME = "BASS" OR n.FISH_NAME = "SNAPPER";