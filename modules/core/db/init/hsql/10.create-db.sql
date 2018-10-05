-- begin SAD_CONTRACT
create table SAD_CONTRACT (
    ID varchar(36) not null,
    VERSION integer,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255),
    --
    primary key (ID)
)^
-- end SAD_CONTRACT
