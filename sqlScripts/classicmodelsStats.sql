DROP VIEW IF EXISTS basic_stats_view;
CREATE SQL SECURITY INVOKER VIEW basic_stats_view AS
  SELECT VAR_POP(p.amount) as variance
  , STDDEV_POP(p.amount) as stdDeviation
  , MAX(p.amount) as maxAmount
  , MIN(p.amount) as minAmount
  , AVG(p.amount) as avgAmount
  , MAX(p.amount) - MIN(p.amount) as rangeAmount
  #,
  FROM payments p;

SELECT minAmount FROM basic_stats_view;

DROP VIEW IF EXISTS one_stddev_view;
CREATE SQL SECURITY INVOKER VIEW one_stddev_view AS
  SELECT STDDEV_POP(p.amount) as stdDeviation
    , AVG(p.amount) as avgAmount
    , AVG(p.amount) + STDDEV_POP(p.amount)  as oneDevPlus
    , AVG(p.amount) - STDDEV_POP(p.amount) as oneDevMinus
  FROM payments p;

SELECT * FROM one_stddev_view;

DROP VIEW IF EXISTS payments_one_stddev_view;

SELECT customerNumber as CNum
FROM payments p
WHERE p.amount > one_stddev_view.oneDevMinus;

SELECT *
FROM payments p
WHERE amount > (SELECT AVG(amount) FROM payments);

SELECT *
FROM payments p
WHERE amount > (SELECT STDDEV_POP(amount) + AVG(amount) FROM payments);

SELECT *
FROM payments p
WHERE amount > (SELECT (2 *STDDEV_POP(amount)) + AVG(amount) FROM payments);

SELECT *
FROM payments p
WHERE amount < (SELECT (AVG(amount)-STDDEV_POP(amount)) FROM payments);

SELECT AVG(amount)-STDDEV_POP(amount) FROM payments;

# Customer info for the top .1% of payments made and the payment amount
# as a percentage of that customer's credit limit.
# I am unable to find payment terms in any table so I assume it is all credit
# with a net30, net90, etc type of schedule.
SELECT p.customerNumber AS CNum
  , c.customerName CName
  , p.amount AS OrderAmt
  , c.creditLimit CreditLimit
  , (p.amount / c.creditLimit) * 100 AS PctCreditLimitUsed
FROM payments p
JOIN customers c
  ON p.customerNumber = c.customerNumber
WHERE p.amount > (SELECT (3 *STDDEV_POP(amount)) + AVG(amount) FROM payments)
ORDER BY OrderAmt DESC ;

SELECT * FROM payments;

#the bottom 12.5% of payments and who made them
SELECT p.customerNumber AS CNum
  , c.customerName CName
  , p.amount AS OrderAmt
  , c.creditLimit CreditLimit
  , (p.amount / c.creditLimit) * 100 AS PctCreditLimitUsed
FROM payments p
  JOIN customers c
    ON p.customerNumber = c.customerNumber
WHERE p.amount <= (SELECT AVG(amount) - (1.25 *STDDEV_POP(amount)) FROM payments)
ORDER BY OrderAmt ASC ;

# customer info for customers who made the bottom 12.5% of payment amounts
# and those payments were over 1/4 of their credit limit
SELECT p.customerNumber AS CNum
  , c.customerName CName
  , p.amount AS OrderAmt
  , c.creditLimit CreditLimit
  , (p.amount / c.creditLimit) * 100 AS PctCreditLimitUsed
FROM payments p
  JOIN customers c
    ON p.customerNumber = c.customerNumber
WHERE p.amount <= (SELECT AVG(amount) - (1.25 *STDDEV_POP(amount)) FROM payments)
  AND (p.amount / c.creditLimit) > 0.25
ORDER BY OrderAmt ASC ;

# One possible risk indicator with customers:
# whose payment amounts are nearest to their credit limit?
SELECT c.customerName CName
  , p.amount AS OrderAmt
  , c.creditLimit CreditLimit
  , (p.amount / c.creditLimit) * 100 AS PctCreditLimitUsed
FROM payments p
  JOIN customers c
    ON p.customerNumber = c.customerNumber
WHERE (p.amount / c.creditLimit) > 0.75
ORDER BY PctCreditLimitUsed DESC ;

SELECT AVG(p.amount) as popAvg
  FROM payments p
  ;

SELECT AVG(p.amount) as popAvg
  , 0.5 * (AVG(p.amount)) as lowHalfAvg
  , 1.5 * (AVG(p.amount)) as higHalfAvg
FROM payments p
;

#top mean-quartile of payment amounts
SELECT customerNumber as custNum
  , amount as amtUpperHalf
  FROM payments pay
  HAVING amtUpperHalf > (SELECT AVG(amount) FROM payments);



SELECT * FROM payments;
# total amount of all payments for each customer in the top half of payment amounts, grouped by customer
# and a count of the number of payments that went into each
#with an average payment amount for these customers

SELECT SUM(amt) as sumAmt
  , custNum
  , COUNT(*) as rowCnt
  , (SUM(amt) / COUNT(*)) as custAvg
FROM (SELECT customerNumber as custNum
    , amount as amt
  FROM payments pay
  HAVING amt > (SELECT AVG(amount) FROM payments)
) as upHalf
GROUP BY custNum
ORDER BY sumAmt DESC
;

#same as above but goes ?
SELECT SUM(amt) as sumAmt
  , custNum
  , COUNT(*) as rowCnt
  , (SUM(amt) / COUNT(*)) as custAvg
FROM (SELECT customerNumber as custNum
        , amount as amt
      FROM payments pay
      HAVING amt > (SELECT AVG(amount) FROM payments)
     ) as upHalf
GROUP BY custNum
ORDER BY rowCnt DESC
LIMIT 5
;

#same as above but goes ?
SELECT SUM(amount) as sumAmt
  , customerNumber as custNum
  , COUNT(*) as rowCnt
  , (SUM(amount) / COUNT(*)) as custAvg
FROM payments p
GROUP BY custNum
ORDER BY rowCnt DESC
LIMIT 5

