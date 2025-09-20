-- 사원별 성과금
-- 사번(오름), 성명, 평가 등급(GRADE) -> GRADE , 성과금(BONUS)
-- 두 반기 평균 점수 구해야됨


SELECT E.EMP_NO, E.EMP_NAME,
        CASE 
            WHEN H.SCORE >= 96
            THEN 'S'
            WHEN H.SCORE >= 90
            THEN 'A'
            WHEN H.SCORE >= 80
            THEN 'B'
            ELSE 'C'
        END GRADE,
        CASE 
            WHEN H.SCORE >= 96
            THEN E.SAL * 0.2
            WHEN H.SCORE >= 90 AND H.SCORE < 96
            THEN E.SAL * 0.15
            WHEN H.SCORE >= 80 AND H.SCORE < 90
            THEN E.SAL * 0.1
            ELSE 0
        END BONUS
FROM HR_EMPLOYEES E
JOIN (
    SELECT EMP_NO, AVG(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
) H
ON E.EMP_NO = H.EMP_NO
