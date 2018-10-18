alter table SAD_ORDER add constraint FK_SAD_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references SAD_CUSTOMER(ID);
create index IDX_SAD_ORDER_ON_CUSTOMER on SAD_ORDER (CUSTOMER_ID);
