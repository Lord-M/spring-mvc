**Тестовое задание Укрпочта**

Задание на позицию Java-программиста.

*Использовать при решении : Java 8, Hibernate, H2, JPA, Maven.*

---

## Задача

Сделать небольшой REST-сервис с использованием Spring.

Суть сервиса: покупка товаров с помощью API данного сервиса. 

У нас есть три главные сущности: клиент(аккаунт), товар и скидки. Для этих сущностей, создать таблицы и использовать in-memory базу данных, например,H2.

Конкретное количество полей в каждой таблице, связи между таблицами, и вообще, их количество - на Ваше усмотрение. Я описываю сам базис, который должен быть реализован. Полная свобода действий в реализации и добавление новых деталей. Например, список всех товаров разделить на категории.

**Должны быть реализованы как минимум такие энд-поинты:**

Передача и ответы запросов : формат Json. Можете реализовывать другой                       

1. **/create_user** 
2. **/add_money** – добавить денег на аккаунт, в запросе должен быть указан id, name пользователя, которому они зачислятся .
3. **/list** – список товаров, добавления параметра Категория
4. **/pay** – купить товары ( должен быть параметр указания id товаров который хотим купить, id того кто покупает, что бы проверить хватает ли у него средств и снять для успешного завершения операции покупки).

| Овощи Vegetables(6) | Мясные продукты  Meat(5)  | Фрукты Fruits(6) | Крупы Cereals(4)    |
|---------------------|:-------------------:|:------------------------:| -----------------:|
| Potato — картошка   | Bacon — бекон       | Apple — яблоко           | Buckwheat — гречка |
| Tomato — помидоры   | Beef  — говядина    | Apricot — абрикос        | Grain — зерно |
| Beans  — бобы       | Chicken — курица    | Banana — банан           | Pearl barley — перловая крупа |
| Broccoli — брокколи | Duck — утка         | Blackberry — ежевика     | Rice — рис |
| Cabbage — капуста   | Turkey — индейка    | Blueberry — черника      |            | 
| Carrot — морковь    |                     | Cherry — вишня           |            | 

В таблице скидок - скидки на отдельные товары.                                                                                          
В запросе /pay рассчитать сумму всех товаров с учетом скидок на них.

|  Vegetables(6)  |  Meat(5)        | Fruits(6)            |  Cereals(4) |
|-----------------|:---------------:|:--------------------:| ----------------:|
| 16. Potato — 7% | 5. Bacon — 10%  | 10. Apple — 7%       | 1. Buckwheat — 10% |
| 17. Tomato — 0% | 6. Beef  — 9%   | 11. Apricot — 0%     | 2. Grain — 15% |
| 18. Beans — 10% | 7. Chicken — 7% | 12. Banana — 10%     | 3. Pearl barley — 5% |
| 19. Broccoli — 30% | 8. Duck — 0% | 13. Blackberry — 10% | 4. Rice — 7% |
| 20. Cabbage — 0% | 9. Turkey — 5% | 14. Blueberry — 15%  |            | 
| 21. Carrot — 0%  |                | 15. Cherry — 0%      |            | 

Если есть опыт FRONT-END, сделать минимальный интерфейс, инструмент на ваш выбор. Это как доп.задание, запрос-ответ в виде Json устроит.

*Дополнительно сделайте такой механизм – при покупке товаров, если товаров со скидками больше чем  3, то использовать в расчете суммы тольке те 3 скидки которые наиболее выгодны покупателю. Больше 3 товаров со скидками имееться в виду 3 разных товара, а не 3 экземпляра одного.

В расчете самых выгодных, учитывать количество одинаковых товаров.

Если есть понимание, что такое JPA реализуйте с ним. Для сборки - Maven.

---

## SQL

**2.** Существует таблица с данными, в которой существуют повторяющиеся строки, по значениям некоторых столбцов. 
Необходимо получить список повторяющихся строк. 
Потом удалить повторяющиеся строки, оставив только по одной уникальной строке (оставить только самые поздние строки). 
По возможности, **привести несколько вариантов решений.**

| OrderDetails |    
| --------- |
| OrderDetailId(PK)|     
| OrderId (FK)  |  

Ответ :
- Список повторяющихся строк :
~~~~sql
SELECT * FROM OrderDetails WHERE OrderId IN (
    SELECT OrderId FROM OrderDetails GROUP BY OrderId HAVING COUNT(*) > 1 
)
~~~~
- Удалить повторяющиеся строки, оставив только по одной уникальной строке (оставить только самые поздние строки) :
~~~~sql
DELETE FROM OrderDetails WHERE OrderDetailId IN (
    SELECT u1.OrderDetailId FROM OrderDetails as u1
    JOIN OrderDetails as u2
    ON u1.OrderDetailId < u2.OrderDetailId AND u1.OrderId = u2.OrderId
)
~~~~

**3.** 
* Получить всех сотрудников, независимо от того, имеют ли они соответствия отдела в департаменте.
* Вывести среднюю зарплату по отделам.

**Таблица EMPLOYEES**
| LAST_NAME | DEPARTMENT   | SALARY |
| --------- |:------------:| -----:|
| Getz      | 10           | 3000  |
| Davis     | 20           | 1500  |
| King      | 20           | 2200  |
| Davis     | 30           | 5000  |
| Kochhar   |              | 5000  |

**Таблица DEPARTMENT**
| DEPARTMENT_ID | DEPARTMENT_NAME    |
| ------------- |:------------------:|
| 10            | Sales              |
| 20            | Marketing          |
| 30            | Accounts           |
| 40            | Administration     |




**4.** Описание таблицы EMPLOYEES
~~~~sql
EMP_ID NUMBER(4) NOT NULL
LAST_NAME VARCHAR2(30) NOT NULL
FIRST_NAME VARCHAR2(30)
DEPT_ID NUMBER(2)
JOB_CAT VARCHAR2(30)
SALARY NUMBER
~~~~
Надо выбрать идентификатор отдела, минимальный размер заработной платы, а также максимальную зарплату, выплаченную в этом отделе, **с учетом, что минимальная заработная плата составляет менее 5000, и максимальная зарплата больше, чем 15000?**
Ответ :
~~~~sql
SELECT DEPT_ID, MIN(SALARY) as "MIN_SALARY", MAX(SALARY) as "MAX_SALARY" FROM EMPLOYEES GROUP BY DEPT_ID
~~~~
выведет информацию по мин. и макс. заработным платам по всем отделам

~~~~sql
SELECT DEPT_ID, MIN(SALARY) as "MIN_SALARY", MAX(SALARY) as "MAX_SALARY" FROM EMPLOYEES GROUP BY DEPT_ID HAVING MIN(SALARY) < 5000 AND MAX(SALARY) > 15000
~~~~ 
не выведет информацию по отделам, где заработные платы в диапазонах:
1) 5000-*, потому что минимальная з.п. должна быть меньше 5000 (по условию), и
2) *-15000, потому что максимальная з.п. должна быть больше 15000 (по условию)


**5.** 

**Таблица EMPLOYEES**
| EMPLOYEE_ID | EMP_NAME | DEPT_ID | MGR_ID | JOB_ID   | SALARY |
|-------------|:--------:|:-------:|:------:|:--------:|-------:|
| 101         | Smith    | 20      | 120    | SA_REP   | 4000   |
| 102         | Martin   | 10      | 105    | CLERK    | 2500   |
| 103         | Chris    | 20      | 120    | IT_ADMIN | 4200   |
| 104         | John     | 30      | 108    | HR_CLERK | 2500   |
| 105         | Diana    | 30      | 108    | IT_ADMIN | 5000   |
| 106         | Smith    | 40      | 110    | AD_ASST  | 3000   |
| 108         | Jennifer | 30      | 110    | HR_DIR   | 6500   |
| 110         | Bob      | 40      |        | EX_DIR   | 8000   |
| 120         | Ravi     | 20      | 110    | SA`*`DIR | 6500   | 

* В таблице EMPLOYEES, EMPLOYEE_ID является первичным ключом.
MGR_ID это идентификатор менеджеров и относится к EMPLOYEE_ID.
 DEPT_ID является внешним ключом к DEPARTMENT_ID колонке таблицы DEPARTMENTS.

**Таблица DEPARTMENTS**
| DEPARTMENTS_ID| DEPARTMENTS_NAME   |
| ------------- |:------------------:|
| 10            | Admin              |
| 20            | Education          |
| 30            | IT                 |
| 40            | Human Resources    |

* В таблице DEPARTMENTS, DEPARTMENTS_ID является первичным ключом. 
Что произойдет, если выполнить команды и почему?
~~~~sql  
  DELETE
  FROM departments
  WHERE department id = 40;
~~~~

Ответ : это будет зависеть от того, с каким значением ON DELETE <...> был создан FOREIGN KEY DEPT_ID в таблице EMPLOYEES

1) если ON DELETE CASCADE - тогда все записи из табл. EMPLOYEES, у которых было DEPT_ID = 40, также удалятся (вместе с удалением записи из departments, где department id = 40)

2) если ON DELETE SET NULL / ON DELETE SET DEFAULT - тогда для всех записей из табл. EMPLOYEES, у которых было DEPT_ID = 40, DEPT_ID будет присвоено значение NULL (если столбец DEPT_ID - NULLABLE, иначе должна быть ошибка) / DEFAULT (если было явно указано значение по умолчанию DEFAULT ... при определении столбца), вместе с удалением записи с department id = 40 из таблицы departments

3) если NO ACTION - тогда если не будет записей в табл. EMPLOYEES, у которых DEPT_ID = 40 - удалится лишь запись из табл. departments, где department id = 40. Если будет - тогда в результате будет ошибка, и никакие записи удалены не будут

* В таблице EMPLOYEES, EMPLOYEE_ID является первичным ключом.
MGR_ID это идентификатор менеджеров и относится к EMPLOYEE_ID. 
Колонка JOB_ID - NOT NULL.
Что произойдет, если выполнить и почему?
~~~~sql
  DELETE employee_id, salary, job_id
  FROM employees
  WHERE dept_id = 90;
~~~~
Ответ : Неправильное использование Delete! будет ошибка потому что синтаксис команды не предполагает, что мы можем удалять из ячеек. 
