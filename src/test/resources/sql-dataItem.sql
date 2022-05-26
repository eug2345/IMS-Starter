insert into 'item'('item_name', 'item_price') values('cocacola', 1.9);
use ims;
describe customers;
describe item;

create table if not exists orders(
order_id int not null auto_increment,
customer_id int,
total_price double,
primary key(order_id),
foreign key(customer_id) references customers(id) on update cascade on delete cascade);
describe orders;