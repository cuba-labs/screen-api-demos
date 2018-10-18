-- begin SAD_ORDER
alter table SAD_ORDER add constraint FK_SAD_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references SAD_CUSTOMER(ID)^
create index IDX_SAD_ORDER_ON_CUSTOMER on SAD_ORDER (CUSTOMER_ID)^
-- end SAD_ORDER
-- begin SAD_ORDER_LINE
alter table SAD_ORDER_LINE add constraint FK_SAD_ORDER_LINE_ON_ORDER foreign key (ORDER_ID) references SAD_ORDER(ID)^
create index IDX_SAD_ORDER_LINE_ON_ORDER on SAD_ORDER_LINE (ORDER_ID)^
-- end SAD_ORDER_LINE
