create table customers
(
    id              int generated by default as identity (start with 1) primary key,
    code            varchar(25)  not null,
    names           varchar(25)  not null,
    last_names      varchar(100) not null,
    document_type   varchar(50)  not null,
    document_number varchar(50)  not null
);
