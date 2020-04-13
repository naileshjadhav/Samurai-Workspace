CREATE OR REPLACE PROCEDURE insertEmployee
(in_id IN EMPLOYEE.EMPID%TYPE,
 in_name IN EMPLOYEE.NAME%TYPE,
 in_role IN EMPLOYEE.ROLE%TYPE,
 in_city IN EMPLOYEE.CITY%TYPE,
 in_country IN EMPLOYEE.COUNTRY%TYPE,
 out_result OUT VARCHAR2)
AS
BEGIN
  INSERT INTO EMPLOYEE (EMPID, NAME, ROLE, CITY, COUNTRY) 
  values (in_id,in_name,in_role,in_city,in_country);
  commit;
  
  out_result := 'TRUE';
  
EXCEPTION
  WHEN OTHERS THEN 
  out_result := 'FALSE';
  ROLLBACK;
END;
---------
create or replace PROCEDURE getEmployee
(in_id IN EMPLOYEE.EMPID%TYPE,
 out_name OUT EMPLOYEE.NAME%TYPE,
 out_role OUT EMPLOYEE.ROLE%TYPE,
 out_city OUT EMPLOYEE.CITY%TYPE,
 out_country OUT EMPLOYEE.COUNTRY%TYPE
 )
AS
BEGIN
  SELECT NAME, ROLE, CITY, COUNTRY 
  INTO out_name, out_role, out_city, out_country
  FROM EMPLOYEE
  WHERE EMPID = in_id;
  
END;
---------
create or replace PROCEDURE getEmployeesByRole
(in_role IN EMPLOYEE.ROLE%TYPE,
 out_cursor_emps OUT SYS_REFCURSOR
 )
AS
BEGIN
  OPEN out_cursor_emps FOR
  SELECT EMPID, NAME, CITY, COUNTRY 
  FROM EMPLOYEE
  WHERE ROLE = in_role;
  
END;
----------
create or replace TYPE EMPLOYEE_OBJ AS OBJECT
(
  EMPID NUMBER,
  NAME VARCHAR2(10),
  ROLE VARCHAR2(10),
  CITY  VARCHAR2(10),
  COUNTRY  VARCHAR2(10)
  
  );
----------------
CREATE OR REPLACE PROCEDURE insEmployeeObjStruct
(IN_EMPLOYEE_OBJ IN EMPLOYEE_OBJ,
 out_result OUT VARCHAR2)
AS
BEGIN
  INSERT INTO EMPLOYEE (EMPID, NAME, ROLE, CITY, COUNTRY) values 
  (IN_EMPLOYEE_OBJ.EMPID, IN_EMPLOYEE_OBJ.NAME, IN_EMPLOYEE_OBJ.ROLE, IN_EMPLOYEE_OBJ.CITY, IN_EMPLOYEE_OBJ.COUNTRY);
  commit;
  
  out_result := 'TRUE';
  
EXCEPTION
  WHEN OTHERS THEN 
  out_result := 'FALSE';
  ROLLBACK;
END;