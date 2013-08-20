# --- First database schema

# --- !Ups

set ignorecase true;

create table computer (
  id                        bigint not null,
  tytul                      varchar(255) not null,
  autor                      varchar(255) not null,
  data                		timestamp,
  opinia                      varchar(255) not null,
  ocena				Integer,
  stron				Integer)
;

create sequence computer_seq start with 1000;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists computer_seq;

