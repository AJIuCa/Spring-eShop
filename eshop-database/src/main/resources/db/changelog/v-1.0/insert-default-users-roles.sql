
INSERT INTO `users` (`login`, `password`)
    VALUE   ('admin', '$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq'),
    ('guest', '$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq');
GO

INSERT INTO `roles` (`title`)
    VALUE ('ROLE_ADMIN'), ('ROLE_GUEST');
GO

INSERT INTO `users_roles`(`user_id`, `role_id`)
SELECT (SELECT id FROM `users` WHERE `login` = 'admin'), (SELECT id FROM `roles` WHERE `title` = 'ROLE_ADMIN')
UNION ALL
SELECT (SELECT id FROM `users` WHERE `login` = 'guest'), (SELECT id FROM `roles` WHERE `title` = 'ROLE_GUEST');
GO
