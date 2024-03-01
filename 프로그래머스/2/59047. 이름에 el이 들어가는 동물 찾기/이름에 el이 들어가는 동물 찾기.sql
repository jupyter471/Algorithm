-- 이름순으로
SELECT ANIMAL_ID,NAME from animal_ins where name like '%el%' AND ANIMAL_TYPE = 'Dog'
order by 2