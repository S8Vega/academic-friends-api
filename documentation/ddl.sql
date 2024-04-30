-- public.convocation definition

-- Drop table

-- DROP TABLE convocation;

CREATE TABLE convocation (
	id bigserial NOT NULL,
	closing_date timestamp(6) NULL,
	evaluation_date timestamp(6) NULL,
	opening_date timestamp(6) NULL,
	results_release_date timestamp(6) NULL,
	CONSTRAINT convocation_pkey PRIMARY KEY (id)
);


-- public.course definition

-- Drop table

-- DROP TABLE course;

CREATE TABLE course (
	code varchar(255) NOT NULL,
	credits int4 NOT NULL,
	"name" varchar(255) NULL,
	semester int4 NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (code)
);


-- public.file definition

-- Drop table

-- DROP TABLE file;

CREATE TABLE file (
	"name" varchar(255) NOT NULL,
	"base64" varchar(1000000) NULL,
	CONSTRAINT file_pkey PRIMARY KEY (name)
);


-- public.schedule definition

-- Drop table

-- DROP TABLE schedule;

CREATE TABLE schedule (
	id bigserial NOT NULL,
	classroom varchar(255) NULL,
	"day" int2 NULL,
	"hour" time(6) NULL,
	CONSTRAINT schedule_day_check CHECK (((day >= 0) AND (day <= 6))),
	CONSTRAINT schedule_pkey PRIMARY KEY (id)
);


-- public."security" definition

-- Drop table

-- DROP TABLE "security";

CREATE TABLE "security" (
	email varchar(255) NOT NULL,
	"password" varchar(255) NULL,
	"role" varchar(255) NULL,
	CONSTRAINT security_pkey PRIMARY KEY (email)
);


-- public.users definition

-- Drop table

-- DROP TABLE users;

CREATE TABLE users (
	email varchar(255) NOT NULL,
	code varchar(255) NULL,
	"name" varchar(255) NULL,
	"type" varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (email)
);


-- public.student definition

-- Drop table

-- DROP TABLE student;

CREATE TABLE student (
	semester int4 NOT NULL,
	email varchar(255) NOT NULL,
	CONSTRAINT student_pkey PRIMARY KEY (email),
	CONSTRAINT fk2ffnvcn72q5e4hgyvwchaqt39 FOREIGN KEY (email) REFERENCES users(email)
);


-- public.academic_friend definition

-- Drop table

-- DROP TABLE academic_friend;

CREATE TABLE academic_friend (
	average float8 NULL,
	contract varchar(255) NULL,
	observations varchar(255) NULL,
	resume varchar(255) NULL,
	score int4 NOT NULL,
	status varchar(255) NULL,
	email varchar(255) NOT NULL,
	convocation int8 NULL,
	CONSTRAINT academic_friend_pkey PRIMARY KEY (email),
	CONSTRAINT fkcciorfli85nfy36xjflmtpwxb FOREIGN KEY (email) REFERENCES student(email),
	CONSTRAINT fkiadlkcjqqlsd7fm2u9j0xqt0q FOREIGN KEY (convocation) REFERENCES convocation(id)
);


-- public.academic_friend_has_schedule definition

-- Drop table

-- DROP TABLE academic_friend_has_schedule;

CREATE TABLE academic_friend_has_schedule (
	schedule_id int8 NOT NULL,
	academic_friend_email varchar(255) NOT NULL,
	CONSTRAINT fk5xbmdubpkn6dqx69byxmab6mc FOREIGN KEY (schedule_id) REFERENCES schedule(id),
	CONSTRAINT fklk4t8b82c8p5d7yjiypjxpw66 FOREIGN KEY (academic_friend_email) REFERENCES academic_friend(email)
);


-- public.consultancy definition

-- Drop table

-- DROP TABLE consultancy;

CREATE TABLE consultancy (
	id bigserial NOT NULL,
	aspects_to_improve varchar(255) NULL,
	creation_date timestamp(6) NULL,
	difficulties_encountered varchar(255) NULL,
	end_date timestamp(6) NULL,
	start_date timestamp(6) NULL,
	academic_friend varchar(255) NULL,
	course varchar(255) NULL,
	student varchar(255) NULL,
	CONSTRAINT consultancy_pkey PRIMARY KEY (id),
	CONSTRAINT fkcm4bsp350bqj4iuh57934sj9m FOREIGN KEY (academic_friend) REFERENCES academic_friend(email),
	CONSTRAINT fke3843igf76ytohbk1vedwd54 FOREIGN KEY (course) REFERENCES course(code),
	CONSTRAINT fkm2v37rh0tmm34a6fe84rqp0gj FOREIGN KEY (student) REFERENCES student(email)
);


-- public.report definition

-- Drop table

-- DROP TABLE report;

CREATE TABLE report (
	id bigserial NOT NULL,
	"date" timestamp(6) NULL,
	file varchar(255) NULL,
	observations varchar(255) NULL,
	state varchar(255) NULL,
	"type" varchar(255) NULL,
	upload_date timestamp(6) NULL,
	academic_friend varchar(255) NULL,
	CONSTRAINT report_pkey PRIMARY KEY (id),
	CONSTRAINT fk2ug9b9l9q5aq4p9erawdniow0 FOREIGN KEY (academic_friend) REFERENCES academic_friend(email)
);