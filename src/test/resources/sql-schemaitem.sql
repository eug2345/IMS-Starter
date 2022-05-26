DROP TABLE IF EXISTS `item`;

CREATE TABLE IF NOT EXISTS `item` (
   item_id int not null auto_increment,
item_name Varchar(30) not null,
item_price decimal(5.2) not null,
primary key(item_id) 
);