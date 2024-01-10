-- public.convocation definition

-- Drop table

-- DROP TABLE public.convocation;

CREATE TABLE public.convocation (
	id bigserial NOT NULL,
	closing_date timestamp(6) NULL,
	evaluation_date timestamp(6) NULL,
	opening_date timestamp(6) NULL,
	results_release_date timestamp(6) NULL,
	CONSTRAINT convocation_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.convocation OWNER TO postgres;
GRANT ALL ON TABLE public.convocation TO postgres;


-- public.course definition

-- Drop table

-- DROP TABLE public.course;

CREATE TABLE public.course (
	code varchar(255) NOT NULL,
	credits int4 NOT NULL,
	"name" varchar(255) NULL,
	semester int4 NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (code)
);

-- Permissions

ALTER TABLE public.course OWNER TO postgres;
GRANT ALL ON TABLE public.course TO postgres;


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	email varchar(255) NOT NULL,
	code varchar(255) NULL,
	"name" varchar(255) NULL,
	"type" varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (email)
);

-- Permissions

ALTER TABLE public.users OWNER TO postgres;
GRANT ALL ON TABLE public.users TO postgres;


-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	semester int4 NOT NULL,
	email varchar(255) NOT NULL,
	CONSTRAINT student_pkey PRIMARY KEY (email),
	CONSTRAINT fk2ffnvcn72q5e4hgyvwchaqt39 FOREIGN KEY (email) REFERENCES public.users(email)
);

-- Permissions

ALTER TABLE public.student OWNER TO postgres;
GRANT ALL ON TABLE public.student TO postgres;


-- public.academic_friend definition

-- Drop table

-- DROP TABLE public.academic_friend;

CREATE TABLE public.academic_friend (
	average float8 NULL,
	contract varchar(255) NULL,
	observations varchar(255) NULL,
	resume varchar(255) NULL,
	score int4 NOT NULL,
	status varchar(255) NULL,
	email varchar(255) NOT NULL,
	convocation int8 NULL,
	CONSTRAINT academic_friend_pkey PRIMARY KEY (email),
	CONSTRAINT fkcciorfli85nfy36xjflmtpwxb FOREIGN KEY (email) REFERENCES public.student(email),
	CONSTRAINT fkiadlkcjqqlsd7fm2u9j0xqt0q FOREIGN KEY (convocation) REFERENCES public.convocation(id)
);

-- Permissions

ALTER TABLE public.academic_friend OWNER TO postgres;
GRANT ALL ON TABLE public.academic_friend TO postgres;


-- public.consultancy definition

-- Drop table

-- DROP TABLE public.consultancy;

CREATE TABLE public.consultancy (
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
	CONSTRAINT fkcm4bsp350bqj4iuh57934sj9m FOREIGN KEY (academic_friend) REFERENCES public.academic_friend(email),
	CONSTRAINT fke3843igf76ytohbk1vedwd54 FOREIGN KEY (course) REFERENCES public.course(code),
	CONSTRAINT fkm2v37rh0tmm34a6fe84rqp0gj FOREIGN KEY (student) REFERENCES public.student(email)
);

-- Permissions

ALTER TABLE public.consultancy OWNER TO postgres;
GRANT ALL ON TABLE public.consultancy TO postgres;


-- public.report definition

-- Drop table

-- DROP TABLE public.report;

CREATE TABLE public.report (
	id bigserial NOT NULL,
	"date" timestamp(6) NULL,
	file varchar(255) NULL,
	observations varchar(255) NULL,
	state varchar(255) NULL,
	"type" varchar(255) NULL,
	upload_date timestamp(6) NULL,
	academic_friend varchar(255) NULL,
	CONSTRAINT report_pkey PRIMARY KEY (id),
	CONSTRAINT fk2ug9b9l9q5aq4p9erawdniow0 FOREIGN KEY (academic_friend) REFERENCES public.academic_friend(email)
);

-- Permissions

ALTER TABLE public.report OWNER TO postgres;
GRANT ALL ON TABLE public.report TO postgres;


-- public.schedule definition

-- Drop table

-- DROP TABLE public.schedule;

CREATE TABLE public.schedule (
	id bigserial NOT NULL,
	"day" int2 NULL,
	end_time time(6) NULL,
	start_time time(6) NULL,
	status varchar(255) NULL,
	academic_friend varchar(255) NULL,
	CONSTRAINT schedule_day_check CHECK (((day >= 0) AND (day <= 6))),
	CONSTRAINT schedule_pkey PRIMARY KEY (id),
	CONSTRAINT fk3jfvsi7ofp2pj8v1ib629oytn FOREIGN KEY (academic_friend) REFERENCES public.academic_friend(email)
);

-- Permissions

ALTER TABLE public.schedule OWNER TO postgres;
GRANT ALL ON TABLE public.schedule TO postgres;