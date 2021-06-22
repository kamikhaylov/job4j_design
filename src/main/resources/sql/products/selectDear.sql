select name as Самый_дорогой_продукт from product
where price = (select max(price) from product);