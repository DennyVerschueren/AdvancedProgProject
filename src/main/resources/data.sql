INSERT INTO END_USER
(ID, email_address, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'test@gmail.com', 'admin', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_ADMIN');

INSERT INTO END_USER
(ID, email_address, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'test@gmail.com', 'testuser', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');


INSERT INTO GAME
(ID, name, game_image, GAME_DESCRIPTION)
VALUES
    (nextval('GAME_SEQ'), 'Pokémon', 'https://www.pokemon.com/static-assets/app/static3/img/og-default-image.jpeg', 'The original Pokémon is a role-playing game based around building a small team of monsters to battle other monsters in a quest to become the best. Pokémon are divided into types, such as water and fire, each with different strengths. Battles between them can be likened to the simple hand game rock-paper-scissors.');

INSERT INTO GAME
(ID, name, game_image, GAME_DESCRIPTION)
VALUES
    (nextval('GAME_SEQ'), 'Street Fighter', 'https://www.streetfighter.com/assets/images/title_bnr/title_1_1.jpg', 'Street Fighter, commonly abbreviated as SF, is a Japanese media franchise centered on a series of fighting video and arcade games developed and published by Capcom.');

INSERT INTO GAME
(ID, name, game_image, GAME_DESCRIPTION)
VALUES
    (nextval('GAME_SEQ'), 'Overwatch', 'https://i.ytimg.com/vi/GKXS_YA9s7E/maxresdefault.jpg', 'Overwatch is an online team-based game generally played as a first-person shooter. The game featured several different game modes, principally designed around squad-based combat with two opposing teams of five players each.');

INSERT INTO TOURNAMENT
(ID, name, date, game_id, free, prizepool)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 1', '2024-01-01', 1, FALSE, 10000);

INSERT INTO TOURNAMENT
(ID, name, date, game_id, free, prizepool)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 2', '2024-01-01', 1, FALSE, 10000);

INSERT INTO TOURNAMENT
(ID, name, date, game_id, free, prizepool)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 3', '2024-01-01', 2, FALSE, 10000);

INSERT INTO TOURNAMENT
(ID, name, date, game_id, free, prizepool)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 4', '2024-01-01', 2, FALSE, 10000);

INSERT INTO TOURNAMENT
(ID, name, date, game_id, free, prizepool)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 5', '2024-01-01', 3, FALSE, 10000);

