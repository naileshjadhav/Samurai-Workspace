create or replace trigger trg_prd_ins_only 
before insert on products 
for each row 
enable
begin 
    if inserting then 
		insert into products_audit (DDL_DATE,DDL_USER,OBJ_CREATED,OBJ_NAME,DDL_OPERATION) 
		values(:new.DDL_DATE,:new.DDL_USER,:new.OBJ_CREATED,:new.OBJ_NAME,:new.DDL_OPERATION); 
	end if;    
exception
    when others then
    insert into products_audit values(sysdate,'default','default','default','default'); 
end;
/