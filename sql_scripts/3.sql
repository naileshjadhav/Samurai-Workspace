--set serveroutput on;
create or replace trigger trg_prd_ins_only
before insert on products
for each row
enable
declare
v_ddl_user varchar2(15);
begin
    select DDL_USER into v_ddl_user from products;
    if inserting then
		insert into products_audit values(sysdate,v_ddl_user,:new.OBJ_CREATED,:new.OBJ_NAME,:new.DDL_OPERATION);
		--dbms_output.putline('you inserted:'||v_ddl_date);
	end if;   
end;
/