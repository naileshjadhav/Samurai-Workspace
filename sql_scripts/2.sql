set serveroutput on;
create or replace trigger trg_prd_ins_only
before insert on products
for each row
enable
declare
--v_ddl_date date;
v_obj_created varchar2(15);
v_obj_name varchar2(15);
v_ddl_operation varchar2(15);
begin
    select DDL_USER,OBJ_CREATED,OBJ_NAME,DDL_OPERATION 
    into v_ddl_user,v_obj_created,v_obj_name,v_ ddl_operation
    from products;
        if inserting then
            insert into product_audit values(sysdate,v_ddl_user,v_obj_created,v_obj_name,v_ ddl_operation);
            dbms_output.putline('you inserted:'||v_ddl_date);
        --elsif updating then
            --update product_audit set DDL_DATE=v_ddl_date, DDL_USER=v_ddl_user, OBJ_CREATED='4',OBJ_NAME='5','update'; 
            --dbms_output.putline('you updated:'||v_ddl_date);
        end if;   
end;
/