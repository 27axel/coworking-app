CREATE TABLE coworking
(
    id      BIGINT PRIMARY KEY,
    name    TEXT,
    address TEXT
);

CREATE TABLE reservation
(
    id BIGINT PRIMARY KEY,
    room_id BIGINT,
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE room
(
    id BIGINT PRIMARY KEY,
    count_of_places INTEGER,
    coworking_id BIGINT,
    FOREIGN KEY (coworking_id) REFERENCES coworking(id)
);

INSERT INTO coworking (id, name, address)
VALUES (1, 'Коворкинг 1', 'Улица Коворкинга д.4'), (2, 'Коворкинг 2', 'Улица Коворкинга д.12'), (1, 'Коворкинг 3', 'Коворкинга переулок д.1');


INSERT INTO room (id, count_of_places, coworking_id)
VALUES (1, 14, 1), (2, 4, 1), (3, 18, 2), (4, 15, 1), (5, 12, 3), (6, 16, 3), (7, 20, 2), (8, 16, 1), (9, 2, 3), (10, 11, 2);


INSERT INTO reservation (id, start_date_time, end_date_time, room_id)
VALUES (1, '2023-09-10 12:00', '2023-09-10 13:30'), (2, '2023-09-12 15:30', '2023-09-12 19:00'), (3, '2023-09-12 16:00', '2023-09-10 16:30')



