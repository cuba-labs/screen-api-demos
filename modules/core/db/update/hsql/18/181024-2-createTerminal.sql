alter table SAD_TERMINAL add constraint FK_SAD_TERMINAL_ON_AIRPORT foreign key (AIRPORT_ID) references SAD_AIRPORT(ID);
create index IDX_SAD_TERMINAL_ON_AIRPORT on SAD_TERMINAL (AIRPORT_ID);