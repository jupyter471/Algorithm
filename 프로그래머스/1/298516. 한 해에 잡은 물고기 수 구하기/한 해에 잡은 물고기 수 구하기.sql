-- 코드를 작성해주세요

# selct count(*) as FISH_COUNT
# from FISHINFO
# where TIME LIKE '2021%';
select count(case when year(time) = 2021 then id end) as FISH_COUNT from fish_info



# SELECT COUNT(*) as FISHCOUNT
# FROM FISHINFO
# WHERE TIME LIKE '2021%';