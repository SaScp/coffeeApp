CREATE TABLE IF NOT EXISTS t_coffee (

    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name_type VARCHAR(128) NOT NULL UNIQUE,
    instructions TEXT NOT NULL,
    prep_time time NOT NULL,
    calories INT
);
INSERT INTO t_coffee (name_type, instructions, prep_time, calories) VALUES
                                                                        ('Эспрессо', 'Приготовление: Пропустить горячую воду через мелко молотый кофе под высоким давлением.', '00:00:25', 2),
                                                                        ('Американо', 'Приготовление: Разбавить эспрессо горячей водой.', '00:00:30', 15),
                                                                        ('Капучино', 'Приготовление: Смешать равные части эспрессо, горячего молока и взбитого молока.', '00:01:00', 70);