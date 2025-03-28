select ANIMAL_ID,NAME, IF(SEX_UPON_INTAKE LIKE "%Neutered%" || SEX_UPON_INTAKE LIKE "%Spayed%","O","X")
as "중성화"
from animal_ins
order by 1;
