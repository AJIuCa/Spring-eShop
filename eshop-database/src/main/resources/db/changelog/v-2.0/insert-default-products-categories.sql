
INSERT INTO `products` (`title`, `manufacturer`)
    VALUE ('Bloody_red', 'Citadel'), ('Hexed_Lichen', 'Vallejo'), ('HP-C_plus', 'Iwata');
GO

INSERT INTO `categories` (`title`)
    VALUE ('Paint'), ('Air_brush');
GO

INSERT INTO `products_categories`(`product_id`, `category_id`)
SELECT (SELECT id FROM `products` WHERE `title` = 'Bloody_red'), (SELECT id FROM `categories` WHERE `title` = 'Paint')
GO

INSERT INTO `products_categories`(`product_id`, `category_id`)
SELECT (SELECT id FROM `products` WHERE `title` = 'Hexed_Lichen'), (SELECT id FROM `categories` WHERE `title` = 'Paint');
GO

INSERT INTO `products_categories`(`product_id`, `category_id`)
SELECT (SELECT id FROM `products` WHERE `title` = 'HP-C_plus'), (SELECT id FROM `categories` WHERE `title` = 'Air_brush');
GO
