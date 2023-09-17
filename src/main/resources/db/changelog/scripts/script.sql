CREATE TABLE coworking
(
    id      SERIAL PRIMARY KEY,
    name    TEXT,
    address TEXT
);

INSERT INTO coworking ( name, address)
VALUES ( 'Коворкинг 1', 'Улица Коворкинга д.4'), ('Коворкинг 2', 'Улица Коворкинга д.12'), ('Коворкинг 3', 'Коворкинга переулок д.1');

CREATE TABLE room
(
    id SERIAL PRIMARY KEY,
    count_of_places INTEGER,
    coworking_id BIGINT,
    FOREIGN KEY (coworking_id) REFERENCES coworking(id)
);

INSERT INTO room (count_of_places, coworking_id)
VALUES (14, 1), (4, 1), (18, 2), (15, 1), (12, 3), ( 16, 3), (20, 2), ( 16, 1), (2, 3), (11, 2);


CREATE TABLE reservation
(
    id SERIAL PRIMARY KEY,
    room_id BIGINT,
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    FOREIGN KEY (room_id) REFERENCES room(id)
);

INSERT INTO reservation (start_date_time, end_date_time, room_id)
VALUES ('2023-09-10 12:00', '2023-09-10 13:30', 4), ('2023-09-12 15:30', '2023-09-12 19:00', 6), ('2023-09-12 16:00', '2023-09-10 16:30', 9);



