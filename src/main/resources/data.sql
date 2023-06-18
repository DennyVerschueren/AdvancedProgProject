INSERT INTO GAME
(ID, name, game_image)
VALUES
    (nextval('GAME_SEQ'), 'Pokémon', 'https://www.pokemon.com/static-assets/app/static3/img/og-default-image.jpeg');

INSERT INTO GAME
(ID, name, game_image)
VALUES
    (nextval('GAME_SEQ'), 'Street Fighter', 'https://www.streetfighter.com/assets/images/title_bnr/title_1_1.jpg');

INSERT INTO GAME
(ID, name, game_image)
VALUES
    (nextval('GAME_SEQ'), 'Overwatch', 'https://i.ytimg.com/vi/GKXS_YA9s7E/maxresdefault.jpg');

INSERT INTO TOURNAMENT
(ID, name, date, game_id)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 1', '2024-01-01', 1);

INSERT INTO TOURNAMENT
(ID, name, date, game_id)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 2', '2024-01-01', 1);

INSERT INTO TOURNAMENT
(ID, name, date, game_id)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 3', '2024-01-01', 2);

INSERT INTO TOURNAMENT
(ID, name, date, game_id)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 4', '2024-01-01', 2);

INSERT INTO TOURNAMENT
(ID, name, date, game_id)
VALUES
    (nextval('TOURNAMENT_SEQ'), 'Tournament 5', '2024-01-01', 3);

