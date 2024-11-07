-- Adminer 4.8.1 PostgreSQL 15.1 (Debian 15.1-1.pgdg110+1) dump

\connect "ekivoki";

DROP TABLE IF EXISTS "card";
CREATE TABLE "public"."card"
(
    "id"            uuid      NOT NULL,
    "topic_id"      uuid      NOT NULL,
    "type_id"       uuid      NOT NULL,
    "task"          character varying(255),
    "description"   character varying(255),
    "question"      character varying(255),
    "lead_time"     integer   NOT NULL,
    "date_creation" timestamp NOT NULL,
    "last_modified" timestamp NOT NULL,
    "version"       bigint    NOT NULL,
    CONSTRAINT "card__id" PRIMARY KEY ("id")
) WITH (oids = false);

CREATE INDEX "card__topic_id" ON "public"."card" USING btree ("topic_id");
CREATE INDEX "card__type_id" ON "public"."card" USING btree ("type_id");

INSERT INTO "card" ("id", "topic_id", "type_id", "task", "description", "question", "lead_time", "date_creation","last_modified", "version")
VALUES ('2d1af223-6895-407f-b7ec-f94c8b3ced01', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'q', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced02', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'w', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced03', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'e', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced04', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'r', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced05', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 't', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced06', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'y', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced07', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'u', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced08', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'I', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced09', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'o', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced10', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'p', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced11', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'a', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced12', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 's', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced13', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'd', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced14', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'f', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced15', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'g', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced16', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'h', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced17', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'j', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced18', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'k', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced19', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'l', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced20', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'z', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced21', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'x', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced22', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'c', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced23', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'v', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced24', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'b', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced25', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'n', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0),
       ('2d1af223-6895-407f-b7ec-f94c8b3ced26', '02c8ff4c-ccfb-4a25-b52a-4f322c5204a4','272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 'm', '', '', 1, '2024-10-13 15:36:05.411758','2024-10-13 15:36:05.411758', 0);

DROP TABLE IF EXISTS "card_topic";
CREATE TABLE "public"."card_topic"
(
    "id"   uuid                   NOT NULL,
    "name" character varying(255) NOT NULL,
    CONSTRAINT "card_topic__id" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "card_topic" ("id", "name")
VALUES ('02c8ff4c-ccfb-4a25-b52a-4f322c5204a4', 'Школа'),
       ('31340ef6-8ba5-44f7-9c4b-6f109a94bfa5', 'Животный мир'),
       ('51a07874-baea-4cf8-86d9-21cdb94b639e', 'Океан'),
       ('908ac494-6f33-4f1b-bf65-4592e80ab8cd', 'Растения'),
       ('99cd99f8-9a6b-4070-bdc1-4c4be705de97', 'Изобретения'),
       ('af3cf0b4-3e5c-47fb-9ce9-4b69bd36553a', 'Человек'),
       ('bd726693-2c4c-412e-bf84-cb52b80b860b', 'Космос'),
       ('c7a5fec1-08a5-4acd-98a5-b8a1a455a7f7', 'Земля'),
       ('d0b03686-f1b5-4c24-b240-eb5a80f8a8b0', 'Искусство');

DROP TABLE IF EXISTS "card_type";
CREATE TABLE "public"."card_type"
(
    "id"          uuid                   NOT NULL,
    "dice"        integer                NOT NULL,
    "name"        character varying(255) NOT NULL,
    "description" character varying(255) NOT NULL,
    CONSTRAINT "card_type__id" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "card_type" ("id", "dice", "name", "description")
VALUES ('272b4e6e-a0fb-461d-90e9-dc9ab1f1602f', 1, 'Наоборот', 'Произнесите слово или фразу задом наперед'),
       ('4331dcc9-02e4-4796-a288-81483422bbd3', 2, 'Своми словами', 'Объясните не используя синонимы и однокоренные слова'),
       ('f4ab9c93-da3c-47d3-8290-61980ae85a05', 3, 'Рисунок', 'Нарисуйте задание, не озвучивая и не жестикулируя'),
       ('663067b8-a4bd-4cf1-b382-8e68fa068da2', 4, 'Пластилин', 'Вылепите задание, не озвучивая и не жестикулируя'),
       ('1e9d0ab3-8775-4a18-bc95-29ef4195c8b1', 5, 'Жесты', 'Нельзя говорить и использовать подручные средства'),
       ('53014627-9760-4aaf-a370-fc17c7f6c689', 6, '6', '6');

DROP TABLE IF EXISTS "game_history";
CREATE TABLE "public"."game_history"
(
    "id"         uuid NOT NULL,
    "session_id" uuid NOT NULL,
    "card_id"    uuid NOT NULL,
    CONSTRAINT "game_history__id" PRIMARY KEY ("id")
) WITH (oids = false);

DROP TABLE IF EXISTS "game_session";
CREATE TABLE "public"."game_session"
(
    "id"            uuid      NOT NULL,
    "date_creation" timestamp NOT NULL,
    CONSTRAINT "game_session__id" PRIMARY KEY ("id")
) WITH (oids = false);

DROP TABLE IF EXISTS "user_card";
CREATE TABLE "public"."user_card"
(
    "id"            uuid      NOT NULL,
    "topic_id"      uuid      NOT NULL,
    "type_id"       uuid      NOT NULL,
    "task"          character varying(255),
    "description"   character varying(255),
    "question"      character varying(255),
    "lead_time"     integer   NOT NULL,
    "date_creation" timestamp NOT NULL,
    "last_modified" timestamp NOT NULL,
    "version"       bigint    NOT NULL
) WITH (oids = false);

DROP TABLE IF EXISTS "user_card_topic";
CREATE TABLE "public"."user_card_topic"
(
    "id"   uuid                   NOT NULL,
    "name" character varying(255) NOT NULL
) WITH (oids = false);

-- 2024-10-13 20:52:53.37297+00