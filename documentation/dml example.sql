-- clean database
SET CONSTRAINTS ALL DEFERRED;
TRUNCATE TABLE public.convocation CASCADE;
TRUNCATE TABLE public.users CASCADE;
TRUNCATE TABLE public.student CASCADE;
TRUNCATE TABLE public.academic_friend CASCADE;
TRUNCATE TABLE public.schedule CASCADE;
TRUNCATE TABLE public.academic_friend_has_schedule CASCADE;
TRUNCATE TABLE public.report CASCADE;
TRUNCATE TABLE public.course CASCADE;
TRUNCATE TABLE public.consultancy CASCADE;
SET CONSTRAINTS ALL IMMEDIATE;
-- convocation
INSERT INTO public.convocation (closing_date,evaluation_date,opening_date,results_release_date) VALUES
	 ('2024-02-25 00:00:00.000','2024-03-10 00:00:00.000','2024-01-05 00:00:00.000','2024-03-20 00:00:00.000');

-- users
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('brayansebastianvega@ufps.edu.co','1151636','Sebastian Vega','director'),
	 ('jorgeomarpp@ufps.edu.co','1151705','Jorge Perez','coordinator'),
	 ('andreafernandez@ufps.edu.co','1151890','Andrea Fernandez Diaz','student'),
	 ('valentinaospina@ufps.edu.co','1151543','Valentina Ospina Lopez','student'),
	 ('camilovalencia@ufps.edu.co','1151678','Camilo Valencia Ramirez','student'),
	 ('laurahernandez@ufps.edu.co','1151321','Laura Hernandez Castro','student'),
	 ('juancardenas@ufps.edu.co','1151012','Juan Cardenas Herrera','student'),
	 ('danielavargas@ufps.edu.co','1151987','Daniela Vargas Montoya','student'),
	 ('nataliajimenez@ufps.edu.co','1151109','Natalia Jimenez Ortiz','student'),
	 ('eduardopulido@ufps.edu.co','1151210','Eduardo Pulido Vega','student');
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('isabelgonzalez@ufps.edu.co','1151543','Isabel Gonzalez Garcia','student'),
	 ('pedrorodriguez@ufps.edu.co','1151432','Pedro Rodriguez Perez','student'),
	 ('mariacardenas@ufps.edu.co','1151567','Maria Cardenas Herrera','student'),
	 ('lucasgomez@ufps.edu.co','1151654','Lucas Gomez Ramirez','student'),
	 ('cristinaaguilar@ufps.edu.co','1151543','Cristina Aguilar Montoya','student'),
	 ('carolinavelez@ufps.edu.co','1151678','Carolina Velez Diaz','student'),
	 ('lauragonzalez@ufps.edu.co','1151456','Laura Gonzalez','student'),
	 ('carlosramirez@ufps.edu.co','1151678','Carlos Ramirez','student'),
	 ('andreaperez@ufps.edu.co','1151890','Andrea Perez','student'),
	 ('javierrodriguez@ufps.edu.co','1151789','Javier Rodriguez','student');
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('camilogomez@ufps.edu.co','1151908','Camilo Gomez','student'),
	 ('nataliacastro@ufps.edu.co','1151374','Natalia Castro','student'),
	 ('sebastiancruz@ufps.edu.co','1151283','Sebastian Cruz','student'),
	 ('valeriavargas@ufps.edu.co','1151746','Valeria Vargas','student'),
	 ('juanlopez@ufps.edu.co','1151839','Juan Lopez','student'),
	 ('paolamendoza@ufps.edu.co','1151981','Paola Mendoza','student'),
	 ('andresrojas@ufps.edu.co','1151789','Andres Rojas','student'),
	 ('maria@ufps.edu.co','1151345','Maria','coordinator'),
	 ('marcelaherrera@ufps.edu.co','1151890','Marcela Herrera','student'),
	 ('davidortega@ufps.edu.co','1151901','David Ortega','student');
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('sergiovelez@ufps.edu.co','1151123','Sergio Velez','student'),
	 ('anacastillo@ufps.edu.co','1151837','Ana Castillo','student'),
	 ('julianariveros@ufps.edu.co','1151561','Juliana Riveros Gutierrez','academicFriend'),
	 ('santiagoperez@ufps.edu.co','1151654','Santiago Perez Rodriguez','academicFriend'),
	 ('felipegomez@ufps.edu.co','1151789','Felipe Gomez Martinez','academicFriend'),
	 ('mauricioflores@ufps.edu.co','1151876','Mauricio Flores Silva','academicFriend'),
	 ('arianapa@ufps.edu.co','1151905','Ariana Mayerli Peña Ardila','academicFriend'),
	 ('juliannavarro@ufps.edu.co','1151639','Julian Navarro','student'),
	 ('karenbeltran@ufps.edu.co','1151642','Karen Beltran','student'),
	 ('juanperez@ufps.edu.co','1151709','Juan Perez','coordinator');

-- student
INSERT INTO public.student (semester,email) VALUES
	 (9,'andreafernandez@ufps.edu.co'),
	 (2,'valentinaospina@ufps.edu.co'),
	 (7,'camilovalencia@ufps.edu.co'),
	 (1,'laurahernandez@ufps.edu.co'),
	 (4,'juancardenas@ufps.edu.co'),
	 (10,'danielavargas@ufps.edu.co'),
	 (8,'nataliajimenez@ufps.edu.co'),
	 (3,'eduardopulido@ufps.edu.co'),
	 (9,'isabelgonzalez@ufps.edu.co'),
	 (6,'pedrorodriguez@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (2,'mariacardenas@ufps.edu.co'),
	 (7,'lucasgomez@ufps.edu.co'),
	 (1,'cristinaaguilar@ufps.edu.co'),
	 (10,'carolinavelez@ufps.edu.co'),
	 (3,'lauragonzalez@ufps.edu.co'),
	 (8,'carlosramirez@ufps.edu.co'),
	 (5,'andreaperez@ufps.edu.co'),
	 (2,'javierrodriguez@ufps.edu.co'),
	 (4,'camilogomez@ufps.edu.co'),
	 (10,'nataliacastro@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (6,'sebastiancruz@ufps.edu.co'),
	 (3,'valeriavargas@ufps.edu.co'),
	 (8,'juanlopez@ufps.edu.co'),
	 (5,'paolamendoza@ufps.edu.co'),
	 (2,'andresrojas@ufps.edu.co'),
	 (9,'marcelaherrera@ufps.edu.co'),
	 (4,'davidortega@ufps.edu.co'),
	 (1,'sergiovelez@ufps.edu.co'),
	 (10,'anacastillo@ufps.edu.co'),
	 (8,'julianariveros@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (3,'santiagoperez@ufps.edu.co'),
	 (6,'felipegomez@ufps.edu.co'),
	 (5,'mauricioflores@ufps.edu.co'),
	 (8,'arianapa@ufps.edu.co'),
	 (10,'juliannavarro@ufps.edu.co'),
	 (9,'karenbeltran@ufps.edu.co');

-- academic_friend
INSERT INTO public.academic_friend (average,contract,observations,resume,score,status,email,convocation) VALUES
	 (4.8,NULL,'es muy crack','resume/mauricioflores@ufps.edu.co.pdf',85,'pending','mauricioflores@ufps.edu.co',1),
	 (4.01,'contract/santiagoperez@ufps.edu.co.pdf','muy buen promedio','resume/santiagoperez@ufps.edu.co.pdf',65,'pass','santiagoperez@ufps.edu.co',1),
	 (3.5,NULL,'Tiene buenos conocimientos','resume/felipegomez@ufps.edu.co.pdf',98,'pending','felipegomez@ufps.edu.co',1),
	 (4.5,NULL,'muy bien','resume/arianapa@ufps.edu.co.pdf',88,'pass','arianapa@ufps.edu.co',1),
	 (4.32,'contract/julianariveros@ufps.edu.co.pdf','ninguna observacion','resume/julianariveros@ufps.edu.co.pdf',90,'pass','julianariveros@ufps.edu.co',NULL);

-- schedule
INSERT INTO public.schedule (classroom,"day","hour") VALUES
	 ('SA-404',0,'08:00:00'),
	 ('SA-404',0,'09:00:00'),
	 ('SA-404',0,'10:00:00'),
	 ('SA-404',0,'11:00:00'),
	 ('SA-404',4,'14:00:00'),
	 ('SA-404',4,'15:00:00'),
	 ('SA-404',4,'16:00:00'),
	 ('SA-404',4,'17:00:00'),
	 ('SA-404',1,'14:00:00'),
	 ('SA-404',1,'15:00:00');
INSERT INTO public.schedule (classroom,"day","hour") VALUES
	 ('SB-401',1,'16:00:00'),
	 ('SB-401',1,'17:00:00'),
	 ('SB-401',2,'12:00:00'),
	 ('SB-401',2,'13:00:00'),
	 ('SB-401',2,'14:00:00'),
	 ('SB-401',2,'15:00:00'),
	 ('SB-401',2,'16:00:00'),
	 ('SB-401',2,'17:00:00'),
	 ('SA-401',3,'12:00:00'),
	 ('SA-401',3,'13:00:00');
INSERT INTO public.schedule (classroom,"day","hour") VALUES
	 ('SA-401',3,'14:00:00'),
	 ('SA-401',3,'15:00:00'),
	 ('SA-401',3,'16:00:00'),
	 ('SA-401',3,'17:00:00'),
	 ('sb-404',1,'08:00:00'),
	 ('sb-404',1,'09:00:00'),
	 ('SB-404',0,'14:00:00'),
	 ('SA-404',0,'15:00:00'),
	 ('SB-404',2,'06:00:00'),
	 ('SB-404',2,'07:00:00');
INSERT INTO public.schedule (classroom,"day","hour") VALUES
	 ('SB-404',2,'10:00:00'),
	 ('SB-404',2,'11:00:00'),
	 ('SB-401',4,'06:00:00'),
	 ('SB-401',4,'07:00:00'),
	 ('SB-401',4,'08:00:00'),
	 ('SB-401',4,'09:00:00'),
	 ('SB-401',4,'10:00:00'),
	 ('SB-401',4,'11:00:00');

-- academic_friend_has_schedule
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (11,'julianariveros@ufps.edu.co'),
	 (12,'julianariveros@ufps.edu.co'),
	 (9,'julianariveros@ufps.edu.co'),
	 (9,'santiagoperez@ufps.edu.co'),
	 (10,'julianariveros@ufps.edu.co'),
	 (10,'santiagoperez@ufps.edu.co'),
	 (14,'julianariveros@ufps.edu.co'),
	 (15,'julianariveros@ufps.edu.co'),
	 (6,'julianariveros@ufps.edu.co'),
	 (21,'julianariveros@ufps.edu.co');
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (22,'julianariveros@ufps.edu.co'),
	 (23,'julianariveros@ufps.edu.co'),
	 (24,'julianariveros@ufps.edu.co'),
	 (1,'santiagoperez@ufps.edu.co'),
	 (3,'santiagoperez@ufps.edu.co'),
	 (4,'julianariveros@ufps.edu.co'),
	 (4,'santiagoperez@ufps.edu.co'),
	 (29,'julianariveros@ufps.edu.co'),
	 (30,'julianariveros@ufps.edu.co'),
	 (2,'santiagoperez@ufps.edu.co');
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (7,'julianariveros@ufps.edu.co'),
	 (8,'julianariveros@ufps.edu.co');

-- report
INSERT INTO public.report ("date",file,observations,state,"type",upload_date,academic_friend) VALUES
	 ('2024-02-01 00:00:00.000','report/f6d13438-38a6-437f-8431-b83d78e2150f.pdf','muy bien','pass','monthly','2024-03-09 17:27:44.733','julianariveros@ufps.edu.co'),
	 ('2024-04-18 00:00:00.000','report/5e543f61-e6a3-4643-98d2-79b728a26b5b.pdf',NULL,'pending','final','2024-03-09 17:28:41.769','julianariveros@ufps.edu.co'),
	 ('2024-03-01 00:00:00.000','report/656fbad2-6164-49b6-87d6-d56cd1519baf.pdf','falta corregir','rejected','monthly','2024-03-09 17:28:52.340','julianariveros@ufps.edu.co'),
	 ('2024-03-19 00:00:00.000','report/d9aeca12-9953-44c3-97af-6a6879ca864a.pdf','cualquier texto','pending','monthly','2024-03-11 03:23:52.383','julianariveros@ufps.edu.co'),
	 ('2024-03-01 00:00:00.000','report/85793243-160c-450d-8f15-e018ab6db388.pdf',NULL,'pending','final','2024-03-11 21:10:08.252','julianariveros@ufps.edu.co'),
	 ('2024-03-01 00:00:00.000','report/76990525-e0ff-4608-bccf-80e426ddb126.pdf','falta colocar evidencia','withCorrections','monthly','2024-03-11 21:10:49.433','julianariveros@ufps.edu.co');

-- course
INSERT INTO public.course (code,credits,name,semester) VALUES
	 ('83254234',3,'Análisis de Algoritmos',4),
	 ('2131232',3,'Estructuras de Datos',3),
	 ('1234532',4,'Cálculo II',2),
	 ('2354534',8,'Arquitectura de Software',3),
	 ('3421567',5,'Programación Orientada a Objetos',4),
	 ('9876123',7,'Sistemas Operativos',4),
	 ('2345678',4,'Redes de Computadoras',3),
	 ('1098765',8,'Ingeniería de Software',5),
	 ('3210987',6,'Ciberseguridad',5),
	 ('9876543',4,'Teoría de la Computación',4);
INSERT INTO public.course (code,credits,name,semester) VALUES
	 ('4321098',4,'Cálculo Numérico',4),
	 ('83254236',3,'API',4),
	 ('2131231',3,'POO',3),
	 ('12345367',4,'Calculo III',2),
	 ('2147483647',8,'Arquitectura de pc',3),
	 ('8765432',7,'Diseño de Compiladores',5),
	 ('7654321',6,'Ingeniería del Software Empresarial',4),
	 ('6543210',8,'Sistemas Distribuidos',5),
	 ('5432109',3,'Interacción Humano-Computadora',3);

-- consultancy
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('debe aprender conceptos basicos','2024-01-10 01:32:31.562','no sabe que es un algoritmo','2024-03-01 11:30:00.000','2024-03-01 10:00:00.000','julianariveros@ufps.edu.co','83254234','andreafernandez@ufps.edu.co'),
	 ('debe estudiar','2024-03-09 17:52:12.931','no sabe complejidad','2024-03-08 16:00:00.000','2024-03-08 14:00:00.000','julianariveros@ufps.edu.co','83254234','lauragonzalez@ufps.edu.co'),
	 ('mejorar complejidad','2024-03-11 03:28:04.430','ninguna','2024-03-11 14:00:00.000','2024-03-11 12:00:00.000','julianariveros@ufps.edu.co','83254234','lauragonzalez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-03 03:00:44.000','Dificultades para la gestión del tiempo','2024-08-25 19:35:43.000','2023-12-29 19:18:06.000','felipegomez@ufps.edu.co','1234532','eduardopulido@ufps.edu.co'),
	 ('Comprensión Teórica','2023-07-19 08:36:54.000','Problemas de presentación y comunicación','2024-05-12 13:25:35.000','2023-09-17 11:12:03.000','felipegomez@ufps.edu.co','3210987','mariacardenas@ufps.edu.co'),
	 ('Resolución de Problemas','2024-02-14 02:51:50.000','Problemas de presentación y comunicación','2024-01-30 12:50:05.000','2023-08-26 05:05:54.000','mauricioflores@ufps.edu.co','2354534','camilogomez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-02-20 22:11:16.000','Falta de actualización tecnológica','2024-01-05 21:40:43.000','2023-07-26 00:37:15.000','julianariveros@ufps.edu.co','2354534','nataliajimenez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-04-15 21:38:19.000','Dificultades para la gestión del tiempo','2024-02-26 07:03:44.000','2023-07-22 04:26:14.000','mauricioflores@ufps.edu.co','83254234','pedrorodriguez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-05-20 10:51:23.000','Problemas de presentación y comunicación','2024-06-11 14:59:53.000','2023-07-18 16:36:09.000','santiagoperez@ufps.edu.co','9876123','cristinaaguilar@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-07 17:08:45.000','Problemas en la resolución de problemas','2024-10-28 09:53:41.000','2023-06-29 23:25:57.000','santiagoperez@ufps.edu.co','1234532','camilogomez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Presentación y Comunicación','2024-01-04 16:42:09.000','Habilidades de programación deficientes','2024-05-16 16:01:24.000','2023-06-28 21:52:58.000','julianariveros@ufps.edu.co','3210987','santiagoperez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-13 04:22:45.000','Habilidades de programación deficientes','2024-05-18 02:34:51.000','2024-01-23 07:28:05.000','mauricioflores@ufps.edu.co','2131232','valentinaospina@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-03-27 19:04:15.000','Falta de actualización tecnológica','2024-09-14 18:06:35.000','2024-02-02 15:42:25.000','santiagoperez@ufps.edu.co','3421567','santiagoperez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-20 12:54:38.000','Dificultades para la gestión del tiempo','2024-07-08 05:04:56.000','2023-06-22 12:20:57.000','felipegomez@ufps.edu.co','1098765','carlosramirez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-15 01:58:00.000','Falta de colaboración y trabajo en equipo','2024-06-23 04:09:15.000','2023-05-25 08:28:35.000','julianariveros@ufps.edu.co','3210987','eduardopulido@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-01-15 20:08:13.000','Problemas de comprensión teórica','2024-11-18 05:55:35.000','2024-05-10 06:19:59.000','felipegomez@ufps.edu.co','6543210','julianariveros@ufps.edu.co'),
	 ('ninguna','2024-03-11 21:11:38.595','ninguna','2024-03-11 16:00:00.000','2024-03-11 14:00:00.000','julianariveros@ufps.edu.co','83254234','juliannavarro@ufps.edu.co'),
	 ('Habilidades de Programación','2024-03-24 22:39:15.000','Dificultades para la gestión del tiempo','2024-11-05 11:29:52.000','2024-02-06 03:20:45.000','julianariveros@ufps.edu.co','9876543','lucasgomez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-05-25 13:40:32.000','Falta de colaboración y trabajo en equipo','2024-10-22 14:50:06.000','2024-05-07 14:20:50.000','santiagoperez@ufps.edu.co','83254234','julianariveros@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-24 12:18:55.000','Problemas de comprensión teórica','2024-08-04 15:15:21.000','2024-03-12 13:36:08.000','santiagoperez@ufps.edu.co','2131232','juanlopez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-03-06 02:54:46.000','Problemas de comprensión teórica','2024-11-18 05:55:35.000','2024-05-10 07:58:04.000','mauricioflores@ufps.edu.co','1098765','andreaperez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-04-25 21:49:33.000','Problemas en la resolución de problemas','2024-07-15 21:39:26.000','2024-05-06 15:59:38.000','mauricioflores@ufps.edu.co','83254234','sebastiancruz@ufps.edu.co'),
	 ('Habilidades de Investigación','2023-07-14 18:23:06.000','Habilidades de programación deficientes','2024-10-27 22:22:45.000','2024-04-22 07:20:42.000','felipegomez@ufps.edu.co','83254234','santiagoperez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-27 21:33:40.000','Escasez de habilidades de investigación','2024-02-05 20:28:28.000','2023-05-29 02:16:52.000','felipegomez@ufps.edu.co','4321098','paolamendoza@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-18 14:22:19.000','Escasez de habilidades de investigación','2024-10-26 17:15:37.000','2024-03-13 08:07:00.000','mauricioflores@ufps.edu.co','3210987','cristinaaguilar@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-27 04:10:01.000','Problemas de presentación y comunicación','2024-05-29 20:17:26.000','2024-04-01 03:34:20.000','santiagoperez@ufps.edu.co','4321098','valentinaospina@ufps.edu.co'),
	 ('Habilidades de Programación','2024-02-02 07:11:25.000','Problemas de presentación y comunicación','2024-07-03 12:28:06.000','2024-01-07 18:28:30.000','mauricioflores@ufps.edu.co','3421567','andreaperez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-18 01:36:34.000','Dificultades para la gestión del tiempo','2024-07-28 16:55:56.000','2023-12-20 01:18:14.000','mauricioflores@ufps.edu.co','6543210','javierrodriguez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-01-12 15:20:47.000','Problemas de presentación y comunicación','2024-04-18 22:12:50.000','2024-01-07 22:58:19.000','felipegomez@ufps.edu.co','1234532','danielavargas@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-26 22:04:00.000','Problemas de presentación y comunicación','2024-02-27 16:49:40.000','2024-01-31 14:48:41.000','julianariveros@ufps.edu.co','8765432','lauragonzalez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Gestión del Tiempo','2024-03-25 19:52:48.000','Problemas de comprensión teórica','2024-04-09 05:22:08.000','2024-04-27 09:08:21.000','santiagoperez@ufps.edu.co','3210987','eduardopulido@ufps.edu.co'),
	 ('Resolución de Problemas','2024-02-08 09:41:34.000','Falta de actualización tecnológica','2024-05-21 23:18:50.000','2024-05-21 08:17:07.000','julianariveros@ufps.edu.co','9876543','juancardenas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-10 02:23:40.000','Problemas de comprensión teórica','2024-01-09 08:01:51.000','2023-11-24 13:52:49.000','mauricioflores@ufps.edu.co','1098765','nataliacastro@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-01-28 13:01:10.000','Falta de actualización tecnológica','2024-04-08 02:25:07.000','2023-11-24 08:45:09.000','julianariveros@ufps.edu.co','3210987','andreaperez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-03-18 04:30:37.000','Problemas en la resolución de problemas','2024-11-01 07:52:17.000','2024-03-31 23:12:56.000','mauricioflores@ufps.edu.co','1234532','mariacardenas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-30 22:09:17.000','Falta de actualización tecnológica','2024-01-23 23:31:53.000','2024-04-05 02:51:54.000','julianariveros@ufps.edu.co','4321098','isabelgonzalez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-16 15:08:44.000','Escasez de habilidades de investigación','2024-11-18 03:14:57.000','2023-10-15 06:56:46.000','santiagoperez@ufps.edu.co','1098765','nataliajimenez@ufps.edu.co'),
	 ('Actualización Tecnológica','2023-06-12 07:30:19.000','Problemas de comprensión teórica','2024-03-10 16:45:21.000','2023-10-03 11:11:31.000','felipegomez@ufps.edu.co','2345678','julianariveros@ufps.edu.co'),
	 ('Habilidades de Programación','2024-05-30 09:29:45.000','Problemas de presentación y comunicación','2024-01-31 22:42:41.000','2024-01-05 05:51:25.000','santiagoperez@ufps.edu.co','3210987','camilovalencia@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-10 22:32:49.000','Escasez de habilidades de investigación','2024-11-15 01:58:00.000','2023-09-23 08:45:28.000','felipegomez@ufps.edu.co','2131232','paolamendoza@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Actualización Tecnológica','2024-04-01 20:10:16.000','Problemas en la resolución de problemas','2024-05-20 10:17:29.000','2023-08-21 08:57:55.000','julianariveros@ufps.edu.co','3210987','sebastiancruz@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-04-11 01:37:26.000','Problemas en la resolución de problemas','2024-04-10 03:36:51.000','2023-08-15 02:13:26.000','julianariveros@ufps.edu.co','5432109','paolamendoza@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-21 14:23:50.000','Problemas de comprensión teórica','2024-04-20 17:06:22.000','2023-08-07 08:22:20.000','julianariveros@ufps.edu.co','6543210','nataliacastro@ufps.edu.co'),
	 ('Gestión del Tiempo','2023-06-03 16:31:10.000','Problemas de presentación y comunicación','2024-05-27 12:15:56.000','2023-06-13 09:28:08.000','mauricioflores@ufps.edu.co','8765432','javierrodriguez@ufps.edu.co'),
	 ('Resolución de Problemas','2023-07-06 17:10:11.000','Escasez de habilidades de investigación','2024-07-18 04:09:06.000','2024-02-23 09:13:13.000','julianariveros@ufps.edu.co','9876123','juancardenas@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-03 08:24:47.000','Problemas en la resolución de problemas','2024-01-19 11:21:36.000','2023-08-03 21:12:46.000','mauricioflores@ufps.edu.co','7654321','camilogomez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-05-24 14:34:28.000','Problemas en la resolución de problemas','2024-08-24 04:58:10.000','2024-04-25 13:43:44.000','mauricioflores@ufps.edu.co','9876123','andresrojas@ufps.edu.co'),
	 ('Presentación y Comunicación','2023-06-22 09:44:22.000','Habilidades de programación deficientes','2024-06-08 11:05:42.000','2024-05-24 12:24:43.000','felipegomez@ufps.edu.co','3210987','lauragonzalez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-03-12 13:07:49.000','Problemas de presentación y comunicación','2024-01-12 01:58:40.000','2024-04-12 17:41:02.000','felipegomez@ufps.edu.co','1234532','valeriavargas@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-31 23:28:58.000','Habilidades de programación deficientes','2024-10-01 11:30:06.000','2023-06-25 19:09:59.000','mauricioflores@ufps.edu.co','3210987','valeriavargas@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Presentación y Comunicación','2023-06-13 20:25:22.000','Problemas de presentación y comunicación','2024-04-21 07:15:54.000','2023-06-21 01:31:35.000','felipegomez@ufps.edu.co','2354534','camilovalencia@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-05-31 18:27:21.000','Falta de actualización tecnológica','2024-09-11 00:21:30.000','2024-05-18 03:29:06.000','felipegomez@ufps.edu.co','6543210','carolinavelez@ufps.edu.co'),
	 ('Presentación y Comunicación','2023-06-07 18:28:39.000','Habilidades de programación deficientes','2024-07-22 23:43:42.000','2024-02-08 07:54:17.000','santiagoperez@ufps.edu.co','1234532','felipegomez@ufps.edu.co'),
	 ('Habilidades de Investigación','2023-06-04 16:54:39.000','Escasez de habilidades de investigación','2024-03-31 02:26:35.000','2024-05-01 23:19:30.000','felipegomez@ufps.edu.co','1098765','javierrodriguez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-09 19:35:45.000','Falta de actualización tecnológica','2024-03-05 07:02:49.000','2023-12-24 02:31:22.000','felipegomez@ufps.edu.co','3210987','lauragonzalez@ufps.edu.co'),
	 ('Habilidades de Programación','2023-06-27 06:36:35.000','Dificultades para la gestión del tiempo','2024-09-05 23:47:23.000','2023-12-10 16:43:42.000','felipegomez@ufps.edu.co','9876543','lauragonzalez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-03-04 09:01:35.000','Problemas de comprensión teórica','2024-04-18 15:00:26.000','2023-11-12 18:05:44.000','felipegomez@ufps.edu.co','83254234','camilovalencia@ufps.edu.co'),
	 ('Actualización Tecnológica','2023-06-15 12:36:21.000','Habilidades de programación deficientes','2024-11-15 00:32:48.000','2023-09-29 10:27:04.000','mauricioflores@ufps.edu.co','7654321','andreafernandez@ufps.edu.co'),
	 ('Gestión del Tiempo','2023-06-16 21:18:14.000','Problemas en la resolución de problemas','2024-12-02 20:01:10.000','2023-08-31 00:18:33.000','julianariveros@ufps.edu.co','1098765','mariacardenas@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-02-08 09:27:03.000','Problemas de comprensión teórica','2024-02-29 05:27:04.000','2024-04-30 04:13:03.000','felipegomez@ufps.edu.co','3421567','camilogomez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Colaboración y Trabajo en Equipo','2023-06-05 15:25:30.000','Problemas de comprensión teórica','2024-02-13 09:39:16.000','2023-08-10 10:36:37.000','mauricioflores@ufps.edu.co','2354534','andreafernandez@ufps.edu.co');
