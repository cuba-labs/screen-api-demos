alter table SAD_ORDER_LINE add column NUM integer ^
update SAD_ORDER_LINE set NUM = 0 where NUM is null ;
alter table SAD_ORDER_LINE alter column NUM set not null ;
