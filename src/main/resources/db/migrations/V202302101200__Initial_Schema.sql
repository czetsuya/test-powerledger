create table if not exists battery
(
    id bigint       primary key,
    version         integer,
    battery_name    varchar(50),
    post_code       int,
    watt_capacity   double
);