-- update SAD_NOTE set MEETING_POINT_ID = <default_value> where MEETING_POINT_ID is null ;
alter table SAD_NOTE alter column MEETING_POINT_ID set not null ;
