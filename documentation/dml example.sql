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
	 ('mariapineda@ufps.edu.co','1151210','Maria Pineda','student'),
	 ('camilogomez@ufps.edu.co','1151908','Camilo Gomez','student'),
	 ('sofiatoro@ufps.edu.co','1151432','Sofia Toro','student'),
	 ('danielmartinez@ufps.edu.co','1151321','Daniel Martinez','student'),
	 ('nataliacastro@ufps.edu.co','1151374','Natalia Castro','student'),
	 ('sebastiancruz@ufps.edu.co','1151283','Sebastian Cruz','student'),
	 ('valeriavargas@ufps.edu.co','1151746','Valeria Vargas','student'),
	 ('juanlopez@ufps.edu.co','1151839','Juan Lopez','student'),
	 ('paolamendoza@ufps.edu.co','1151981','Paola Mendoza','student'),
	 ('andresrojas@ufps.edu.co','1151789','Andres Rojas','student');
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('maria@ufps.edu.co','1151345','Maria','coordinator'),
	 ('marcelaherrera@ufps.edu.co','1151890','Marcela Herrera','student'),
	 ('davidortega@ufps.edu.co','1151901','David Ortega','student'),
	 ('luisapalacio@ufps.edu.co','1151012','Luisa Palacio','student'),
	 ('sergiovelez@ufps.edu.co','1151123','Sergio Velez','student'),
	 ('anacastillo@ufps.edu.co','1151837','Ana Castillo','student'),
	 ('julianariveros@ufps.edu.co','1151561','Juliana Riveros Gutierrez','academicFriend'),
	 ('santiagoperez@ufps.edu.co','1151654','Santiago Perez Rodriguez','academicFriend'),
	 ('felipegomez@ufps.edu.co','1151789','Felipe Gomez Martinez','academicFriend'),
	 ('mauricioflores@ufps.edu.co','1151876','Mauricio Flores Silva','academicFriend');
INSERT INTO public.users (email,code,name,"type") VALUES
	 ('kevin@ufps.edu.co','1151702','kevin sanchezz','student'),
	 ('example1@ufps.edu.co','1151089','jorge perez example','student'),
	 ('pruebanoche@ufps.edu.co','1151123','pruebaNoche','coordinator'),
	 ('jorge@ufps.edu.co','1151701','jorge perez','academicFriend'),
	 ('example2@ufps.edu.co','1151291','kevin sanchezz example','academicFriend'),
	 ('arianapa@ufps.edu.co','1151905','Ariana Mayerli Peña Ardila','student');

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
	 (9,'mariapineda@ufps.edu.co'),
	 (4,'camilogomez@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (7,'sofiatoro@ufps.edu.co'),
	 (1,'danielmartinez@ufps.edu.co'),
	 (10,'nataliacastro@ufps.edu.co'),
	 (6,'sebastiancruz@ufps.edu.co'),
	 (3,'valeriavargas@ufps.edu.co'),
	 (8,'juanlopez@ufps.edu.co'),
	 (5,'paolamendoza@ufps.edu.co'),
	 (2,'andresrojas@ufps.edu.co'),
	 (9,'marcelaherrera@ufps.edu.co'),
	 (4,'davidortega@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (7,'luisapalacio@ufps.edu.co'),
	 (1,'sergiovelez@ufps.edu.co'),
	 (10,'anacastillo@ufps.edu.co'),
	 (8,'julianariveros@ufps.edu.co'),
	 (3,'santiagoperez@ufps.edu.co'),
	 (6,'felipegomez@ufps.edu.co'),
	 (5,'mauricioflores@ufps.edu.co'),
	 (11,'kevin@ufps.edu.co'),
	 (2,'jorge@ufps.edu.co'),
	 (2,'example1@ufps.edu.co');
INSERT INTO public.student (semester,email) VALUES
	 (11,'example2@ufps.edu.co'),
	 (8,'arianapa@ufps.edu.co');

-- academic_friend
INSERT INTO public.academic_friend (average,contract,observations,resume,score,status,email,convocation) VALUES
	 (3.5,NULL,'es muy crack','resume/felipegomez@ufps.edu.co.pdf',79,'pass','felipegomez@ufps.edu.co',1),
	 (4.8,NULL,'es muy crack','resume/mauricioflores@ufps.edu.co.pdf',85,'pass','mauricioflores@ufps.edu.co',1),
	 (4.0,NULL,'No encaja con el perfil','resume/jorge@ufps.edu.co.pdf',60,'pass','jorge@ufps.edu.co',1),
	 (4.01,'contract/santiagoperez@ufps.edu.co.pdf','es muy crack','resume/santiagoperez@ufps.edu.co.pdf',99,'pass','santiagoperez@ufps.edu.co',NULL),
	 (4.5,'contract/example2@ufps.edu.co.pdf','Sabe mucha teoria','resume/example2@ufps.edu.co.pdf',89,'pass','example2@ufps.edu.co',NULL),
	 (4.5,NULL,'Mejorar los tiempos de entrega','resume/arianapa@ufps.edu.co.pdf',4,'pending','arianapa@ufps.edu.co',1),
	 (4.32,'contract/julianariveros@ufps.edu.co.pdf','','resume/julianariveros@ufps.edu.co.pdf',0,'pending','julianariveros@ufps.edu.co',1);

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
	 ('awdaw',0,'06:00:00'),
	 ('awdaw',0,'07:00:00'),
	 ('sb-404',1,'08:00:00'),
	 ('sb-404',1,'09:00:00'),
	 ('SB-404',0,'14:00:00'),
	 ('SA-404',0,'15:00:00');
INSERT INTO public.schedule (classroom,"day","hour") VALUES
	 ('SB-404',2,'06:00:00'),
	 ('SB-404',2,'07:00:00'),
	 ('SB-404',2,'10:00:00'),
	 ('SB-404',2,'11:00:00');

-- academic_friend_has_schedule
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (11,'julianariveros@ufps.edu.co'),
	 (12,'julianariveros@ufps.edu.co'),
	 (9,'julianariveros@ufps.edu.co'),
	 (9,'santiagoperez@ufps.edu.co'),
	 (10,'julianariveros@ufps.edu.co'),
	 (10,'santiagoperez@ufps.edu.co'),
	 (13,'julianariveros@ufps.edu.co'),
	 (14,'julianariveros@ufps.edu.co'),
	 (15,'julianariveros@ufps.edu.co'),
	 (5,'julianariveros@ufps.edu.co');
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (6,'julianariveros@ufps.edu.co'),
	 (7,'julianariveros@ufps.edu.co'),
	 (8,'julianariveros@ufps.edu.co'),
	 (27,'example2@ufps.edu.co'),
	 (28,'example2@ufps.edu.co'),
	 (4,'julianariveros@ufps.edu.co'),
	 (4,'example2@ufps.edu.co'),
	 (34,'julianariveros@ufps.edu.co'),
	 (26,'example2@ufps.edu.co'),
	 (1,'example2@ufps.edu.co');
INSERT INTO public.academic_friend_has_schedule (schedule_id,academic_friend_email) VALUES
	 (3,'example2@ufps.edu.co'),
	 (21,'julianariveros@ufps.edu.co'),
	 (22,'julianariveros@ufps.edu.co'),
	 (23,'julianariveros@ufps.edu.co'),
	 (24,'julianariveros@ufps.edu.co');

-- report
INSERT INTO public.report ("date",file,observations,state,"type",upload_date,academic_friend) VALUES
	 ('2024-03-10 00:00:00.000','report/c8760c0a-3990-460b-8895-e309d69688a5.pdf',NULL,'pending','monthly','2024-01-10 02:07:26.673','julianariveros@ufps.edu.co'),
	 ('2024-03-15 00:00:00.000','report/014feb42-e5cc-4aa0-be9d-7ee350faaa87.pdf',NULL,'pending','monthly','2024-01-10 02:08:06.895','santiagoperez@ufps.edu.co'),
	 ('2024-04-15 00:00:00.000','report/df9e0c61-e016-4ba1-943d-648c90ba8a69.pdf',NULL,'pending','monthly','2024-01-10 02:08:09.940','santiagoperez@ufps.edu.co'),
	 ('2024-02-15 00:00:00.000','report/da781d22-d4f3-433d-bda2-eef21e376797.pdf',NULL,'pending','monthly','2024-01-10 02:08:19.160','felipegomez@ufps.edu.co'),
	 ('2024-03-20 00:00:00.000','report/5a221410-5f83-4bae-b413-4782f9f6f896.pdf',NULL,'pending','monthly','2024-01-10 02:08:22.980','felipegomez@ufps.edu.co'),
	 ('2024-04-20 00:00:00.000','report/be883c14-5ed6-41c5-adb3-facf5164454c.pdf',NULL,'pending','monthly','2024-01-10 02:08:24.793','felipegomez@ufps.edu.co'),
	 ('2024-04-10 00:00:00.000','report/e0a55887-440e-4483-89d8-324e617f4f39.pdf','buen trabajo','pass','monthly','2024-01-10 02:07:39.667','julianariveros@ufps.edu.co'),
	 ('2024-01-08 00:00:00.000','report/e167559c-defc-49bf-afed-95258d37f852.pdf','buen trabajo','pass','monthly','2024-01-10 01:13:20.549','julianariveros@ufps.edu.co'),
	 ('2024-01-09 00:00:00.000','report/b0c1f56b-f0d9-4bbe-b383-f6fc532ff9c1.pdf',NULL,'pending','monthly','2024-01-10 16:25:38.908','julianariveros@ufps.edu.co'),
	 ('2024-03-10 00:00:00.000','report/06de3665-7d44-406f-85e1-4c27f5a4da54.pdf','LE FALTA','pending','monthly','2024-01-13 19:21:47.294','julianariveros@ufps.edu.co');
INSERT INTO public.report ("date",file,observations,state,"type",upload_date,academic_friend) VALUES
	 ('2024-05-10 00:00:00.000','report/4ad64465-baf3-4e34-aeb1-2d2cb7ebf8f9.pdf','Falta información','pending','monthly','2024-01-14 00:08:37.357','julianariveros@ufps.edu.co'),
	 ('2024-01-01 00:00:00.000','report/28b89bbf-6f49-4070-96dc-b7d18dc54279.pdf','PRUEBA SIN ARCHIVO','withCorrections','final','2024-01-15 03:42:13.598','julianariveros@ufps.edu.co'),
	 ('2024-01-16 00:00:00.000','report/f59d7697-8a87-472d-9d3e-cfc3751037cb.pdf',NULL,'pending','monthly','2024-01-17 04:36:59.349','julianariveros@ufps.edu.co'),
	 ('2024-01-16 00:00:00.000','report/2d7e09f9-8685-4daf-bf42-6881714dd245.pdf',NULL,'pending','monthly','2024-01-17 04:37:34.451','julianariveros@ufps.edu.co'),
	 ('2024-01-16 00:00:00.000','report/56c8b7ee-9345-4a5b-ba37-bd3a0c6d3495.pdf',NULL,'pending','monthly','2024-01-17 04:38:06.352','julianariveros@ufps.edu.co'),
	 ('2024-01-16 00:00:00.000','report/fa74be2c-d243-4066-b554-261d14044bab.pdf',NULL,'pending','monthly','2024-01-17 04:38:37.692','julianariveros@ufps.edu.co'),
	 ('2024-06-10 00:00:00.000','report/2219deac-6ead-4949-991e-80c3335390f8.pdf','buen trabajo','pass','final','2024-01-14 18:53:18.962','julianariveros@ufps.edu.co'),
	 ('2024-01-16 00:00:00.000','report/1f0a35cb-a02b-4594-b824-1079c5fbc6d3.pdf','prueba sebvas','withCorrections','monthly','2024-01-17 17:05:19.530','julianariveros@ufps.edu.co'),
	 ('2024-03-10 00:00:00.000','report/63178faf-ec05-4739-b276-9df869533e9b.pdf',NULL,'pending','monthly','2024-01-26 03:47:26.192','julianariveros@ufps.edu.co'),
	 ('2024-03-10 00:00:00.000','report/04212225-8763-4255-b107-818f51266d6d.pdf',NULL,'pending','monthly','2024-01-26 19:19:49.736','julianariveros@ufps.edu.co');

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
	 ('8765432',7,'Diseño de Compiladores',5),
	 ('7654321',6,'Ingeniería del Software Empresarial',4),
	 ('6543210',8,'Sistemas Distribuidos',5),
	 ('5432109',3,'Interacción Humano-Computadora',3),
	 ('4321098',4,'Cálculo Numérico',4),
	 ('83254236',3,'API',4),
	 ('2131231',3,'POO',3),
	 ('12345367',4,'Calculo III',2),
	 ('2147483647',8,'Arquitectura de pc',3);


-- consultancy
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('debe aprender conceptos basicos','2024-01-10 01:32:31.562','no sabe que es un algoritmo','2024-03-01 11:30:00.000','2024-03-01 10:00:00.000','julianariveros@ufps.edu.co','83254234','andreafernandez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-11-04 19:18:42.000','Problemas de presentación y comunicación','2024-09-07 04:42:07.000','2024-04-18 17:54:55.000','mauricioflores@ufps.edu.co','2345678','valeriavargas@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-12-06 18:53:14.000','Falta de actualización tecnológica','2024-10-30 02:37:54.000','2024-08-07 06:35:48.000','mauricioflores@ufps.edu.co','3210987','mariapineda@ufps.edu.co'),
	 ('Resolución de Problemas','2024-05-17 00:16:43.000','Dificultades para la gestión del tiempo','2024-06-03 22:14:58.000','2024-11-18 02:24:51.000','felipegomez@ufps.edu.co','6543210','davidortega@ufps.edu.co'),
	 ('Resolución de Problemas','2024-06-14 17:13:22.000','Problemas de presentación y comunicación','2024-07-05 01:19:32.000','2024-05-07 16:54:09.000','felipegomez@ufps.edu.co','2131232','carolinavelez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-12 18:56:46.000','Problemas de comprensión teórica','2024-01-07 12:52:26.000','2024-02-14 00:29:48.000','julianariveros@ufps.edu.co','2345678','juancardenas@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-12-23 02:35:53.000','Escasez de habilidades de investigación','2024-09-17 06:20:34.000','2024-06-09 11:05:55.000','julianariveros@ufps.edu.co','6543210','sofiatoro@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-12-19 06:21:35.000','Habilidades de programación deficientes','2024-10-05 15:33:36.000','2024-03-18 19:32:56.000','julianariveros@ufps.edu.co','2131232','danielavargas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-23 07:32:58.000','Problemas en la resolución de problemas','2024-12-30 13:59:58.000','2024-04-16 23:32:00.000','mauricioflores@ufps.edu.co','8765432','jorge@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-12-27 13:10:44.000','Falta de colaboración y trabajo en equipo','2024-06-20 08:50:08.000','2024-01-16 19:03:50.000','julianariveros@ufps.edu.co','4321098','sebastiancruz@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-05-07 16:31:55.000','Problemas de presentación y comunicación','2024-08-02 15:48:19.000','2024-12-06 07:02:09.000','mauricioflores@ufps.edu.co','3210987','anacastillo@ufps.edu.co'),
	 ('Comprensión Teórica','2024-08-26 05:29:26.000','Problemas en la resolución de problemas','2024-03-22 22:01:18.000','2024-01-08 06:02:48.000','mauricioflores@ufps.edu.co','2131232','andreafernandez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-25 10:26:43.000','Escasez de habilidades de investigación','2024-10-01 06:19:57.000','2024-04-25 17:34:08.000','felipegomez@ufps.edu.co','3210987','danielavargas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-09-24 19:55:01.000','Problemas de comprensión teórica','2024-08-02 07:12:48.000','2024-08-25 16:59:37.000','felipegomez@ufps.edu.co','2354534','pedrorodriguez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-04-24 16:23:12.000','Falta de colaboración y trabajo en equipo','2024-07-13 01:49:25.000','2024-03-19 19:50:51.000','julianariveros@ufps.edu.co','2345678','sergiovelez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-03-22 11:44:02.000','Problemas en la resolución de problemas','2024-03-31 15:22:01.000','2024-08-09 05:14:09.000','santiagoperez@ufps.edu.co','2354534','valentinaospina@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-09-21 00:16:46.000','Falta de colaboración y trabajo en equipo','2024-04-17 04:25:31.000','2024-10-10 13:47:50.000','felipegomez@ufps.edu.co','1098765','valentinaospina@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-03 04:29:00.000','Falta de actualización tecnológica','2024-12-15 23:14:53.000','2024-07-11 12:44:03.000','julianariveros@ufps.edu.co','8765432','carolinavelez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-02-12 16:57:57.000','Problemas de presentación y comunicación','2024-01-14 14:14:46.000','2024-06-06 19:09:09.000','mauricioflores@ufps.edu.co','5432109','laurahernandez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-16 03:34:50.000','Falta de actualización tecnológica','2024-05-22 22:36:40.000','2024-03-14 20:28:44.000','felipegomez@ufps.edu.co','3421567','eduardopulido@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-11-20 13:54:25.000','Falta de actualización tecnológica','2024-03-22 06:41:05.000','2024-03-16 12:20:43.000','julianariveros@ufps.edu.co','3210987','laurahernandez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-04-29 11:10:56.000','Dificultades para la gestión del tiempo','2024-07-07 04:06:19.000','2024-09-05 09:33:14.000','santiagoperez@ufps.edu.co','83254234','carolinavelez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-10-18 17:36:26.000','Falta de colaboración y trabajo en equipo','2024-08-07 22:55:09.000','2024-01-12 11:43:01.000','santiagoperez@ufps.edu.co','83254234','jorge@ufps.edu.co'),
	 ('Resolución de Problemas','2024-07-13 17:56:58.000','Falta de colaboración y trabajo en equipo','2024-07-07 04:04:48.000','2024-09-06 19:37:44.000','julianariveros@ufps.edu.co','2354534','sebastiancruz@ufps.edu.co'),
	 ('Habilidades de Programación','2024-01-28 22:40:51.000','Problemas de comprensión teórica','2024-03-09 19:01:16.000','2024-07-05 01:48:45.000','julianariveros@ufps.edu.co','9876543','kevin@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-11-11 18:46:22.000','Problemas de presentación y comunicación','2024-10-29 10:16:42.000','2024-09-12 22:16:19.000','julianariveros@ufps.edu.co','3421567','julianariveros@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-12 08:29:03.000','Problemas de comprensión teórica','2024-03-10 20:18:58.000','2024-03-26 17:07:08.000','santiagoperez@ufps.edu.co','5432109','luisapalacio@ufps.edu.co'),
	 ('Habilidades de Programación','2024-10-16 07:42:36.000','Dificultades para la gestión del tiempo','2024-05-20 10:37:03.000','2024-08-21 23:46:18.000','mauricioflores@ufps.edu.co','5432109','kevin@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-06-30 10:38:16.000','Problemas de comprensión teórica','2024-09-02 11:29:37.000','2024-08-22 16:27:41.000','santiagoperez@ufps.edu.co','9876543','danielmartinez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-01-08 12:41:59.000','Problemas de comprensión teórica','2024-12-11 18:51:11.000','2024-08-15 20:18:08.000','felipegomez@ufps.edu.co','2345678','davidortega@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Resolución de Problemas','2024-09-15 19:38:34.000','Problemas en la resolución de problemas','2024-03-07 04:08:36.000','2024-05-22 05:44:11.000','mauricioflores@ufps.edu.co','4321098','cristinaaguilar@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-07-30 10:57:30.000','Escasez de habilidades de investigación','2024-08-12 06:22:18.000','2024-01-26 04:00:32.000','julianariveros@ufps.edu.co','1234532','sofiatoro@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-11-14 00:48:53.000','Problemas de comprensión teórica','2024-04-15 15:49:03.000','2024-04-09 18:51:21.000','mauricioflores@ufps.edu.co','9876123','juancardenas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-09-28 00:47:53.000','Falta de colaboración y trabajo en equipo','2024-01-10 04:34:49.000','2024-07-19 07:34:37.000','mauricioflores@ufps.edu.co','3210987','kevin@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-04-27 14:25:13.000','Falta de actualización tecnológica','2024-03-19 08:15:47.000','2024-02-22 01:08:03.000','felipegomez@ufps.edu.co','9876123','felipegomez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-04-25 12:16:07.000','Falta de actualización tecnológica','2024-01-27 13:14:23.000','2024-06-04 20:15:37.000','santiagoperez@ufps.edu.co','1234532','lucasgomez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-11-13 17:38:05.000','Problemas en la resolución de problemas','2024-09-27 16:22:56.000','2024-07-06 05:26:01.000','julianariveros@ufps.edu.co','1234532','nataliacastro@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-11-26 13:57:50.000','Problemas en la resolución de problemas','2024-09-16 21:09:07.000','2024-05-14 10:54:54.000','santiagoperez@ufps.edu.co','2345678','danielavargas@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-27 15:34:00.000','Falta de colaboración y trabajo en equipo','2024-11-20 05:06:54.000','2024-07-02 21:46:04.000','santiagoperez@ufps.edu.co','6543210','felipegomez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-03-19 06:33:39.000','Problemas de comprensión teórica','2024-06-28 22:46:09.000','2024-02-23 15:08:34.000','felipegomez@ufps.edu.co','5432109','kevin@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Comprensión Teórica','2024-03-15 04:53:51.000','Problemas de presentación y comunicación','2024-09-03 11:23:55.000','2024-11-18 12:25:17.000','santiagoperez@ufps.edu.co','3210987','anacastillo@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-02-25 21:39:14.000','Escasez de habilidades de investigación','2024-06-07 19:57:07.000','2024-05-20 20:33:34.000','julianariveros@ufps.edu.co','2354534','andresrojas@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-02 03:59:54.000','Problemas de comprensión teórica','2024-02-06 07:24:21.000','2024-07-16 01:35:38.000','santiagoperez@ufps.edu.co','8765432','lucasgomez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-05-29 22:59:48.000','Problemas en la resolución de problemas','2024-11-09 11:51:52.000','2024-02-21 00:47:26.000','mauricioflores@ufps.edu.co','1098765','sergiovelez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-03-20 12:07:38.000','Problemas de presentación y comunicación','2024-11-29 12:04:40.000','2024-02-13 22:57:34.000','julianariveros@ufps.edu.co','7654321','nataliacastro@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-07-07 07:09:12.000','Falta de actualización tecnológica','2024-10-17 08:10:42.000','2024-02-25 01:37:16.000','mauricioflores@ufps.edu.co','1098765','kevin@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-05-24 13:41:33.000','Problemas de presentación y comunicación','2024-04-19 11:06:48.000','2024-07-27 17:58:32.000','mauricioflores@ufps.edu.co','9876123','andreafernandez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-10-25 19:31:52.000','Falta de actualización tecnológica','2024-01-23 08:43:11.000','2024-04-07 20:58:01.000','felipegomez@ufps.edu.co','6543210','andreafernandez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-10-06 09:03:50.000','Problemas de comprensión teórica','2024-11-24 23:23:46.000','2024-04-09 08:28:11.000','felipegomez@ufps.edu.co','1234532','lucasgomez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-02-29 10:11:04.000','Dificultades para la gestión del tiempo','2024-06-14 00:31:00.000','2024-04-07 19:28:59.000','julianariveros@ufps.edu.co','6543210','felipegomez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Gestión del Tiempo','2024-06-03 08:18:40.000','Dificultades para la gestión del tiempo','2024-12-11 00:08:13.000','2024-11-28 12:19:22.000','santiagoperez@ufps.edu.co','6543210','lucasgomez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-17 14:46:13.000','Falta de actualización tecnológica','2024-03-08 20:05:37.000','2024-10-30 02:44:21.000','mauricioflores@ufps.edu.co','5432109','anacastillo@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-12-06 16:13:04.000','Falta de actualización tecnológica','2024-08-06 10:34:14.000','2024-06-19 02:53:05.000','felipegomez@ufps.edu.co','4321098','andreaperez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-09-22 23:12:53.000','Problemas de presentación y comunicación','2024-01-15 21:17:14.000','2024-11-28 18:31:08.000','julianariveros@ufps.edu.co','4321098','sergiovelez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-07-17 04:32:37.000','Escasez de habilidades de investigación','2024-03-18 07:51:56.000','2024-10-11 20:05:04.000','mauricioflores@ufps.edu.co','1234532','marcelaherrera@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-08-08 02:12:59.000','Problemas en la resolución de problemas','2024-05-19 08:20:56.000','2024-10-26 11:45:18.000','santiagoperez@ufps.edu.co','5432109','carolinavelez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-04-09 17:55:59.000','Problemas de presentación y comunicación','2024-11-14 05:50:11.000','2024-08-03 10:30:29.000','santiagoperez@ufps.edu.co','4321098','sebastiancruz@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-11-22 10:39:51.000','Escasez de habilidades de investigación','2024-07-18 11:16:41.000','2024-12-12 09:23:57.000','santiagoperez@ufps.edu.co','5432109','kevin@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-05-23 11:07:41.000','Problemas de presentación y comunicación','2024-12-21 20:32:47.000','2024-11-20 14:29:25.000','felipegomez@ufps.edu.co','9876543','mauricioflores@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-11 18:17:35.000','Dificultades para la gestión del tiempo','2024-08-30 00:19:45.000','2024-12-29 06:47:33.000','felipegomez@ufps.edu.co','4321098','javierrodriguez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Resolución de Problemas','2024-07-08 16:27:06.000','Habilidades de programación deficientes','2024-01-02 15:08:19.000','2024-11-22 15:22:16.000','felipegomez@ufps.edu.co','1098765','valeriavargas@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-12-20 01:50:04.000','Problemas de presentación y comunicación','2024-06-24 13:28:45.000','2024-03-22 02:30:02.000','santiagoperez@ufps.edu.co','2354534','carolinavelez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-05-20 02:18:59.000','Problemas de presentación y comunicación','2024-12-10 06:45:45.000','2024-01-08 16:04:48.000','felipegomez@ufps.edu.co','2131232','felipegomez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-12-20 23:10:02.000','Falta de colaboración y trabajo en equipo','2024-03-29 19:25:36.000','2024-04-16 11:30:54.000','mauricioflores@ufps.edu.co','7654321','valeriavargas@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-28 15:08:32.000','Falta de actualización tecnológica','2024-10-24 05:22:44.000','2024-03-04 02:09:55.000','julianariveros@ufps.edu.co','7654321','valeriavargas@ufps.edu.co'),
	 ('Habilidades de Programación','2024-07-26 13:17:01.000','Escasez de habilidades de investigación','2024-10-07 23:19:53.000','2024-09-07 15:22:11.000','julianariveros@ufps.edu.co','5432109','sergiovelez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-03-28 04:10:21.000','Falta de actualización tecnológica','2024-09-26 02:49:43.000','2024-10-28 07:43:48.000','santiagoperez@ufps.edu.co','6543210','luisapalacio@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-04-23 12:19:49.000','Problemas en la resolución de problemas','2024-08-06 21:33:23.000','2024-09-08 22:01:16.000','mauricioflores@ufps.edu.co','8765432','eduardopulido@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-03-07 16:03:41.000','Dificultades para la gestión del tiempo','2024-06-23 22:40:26.000','2024-09-10 23:18:21.000','mauricioflores@ufps.edu.co','8765432','davidortega@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-17 19:38:52.000','Habilidades de programación deficientes','2024-11-01 17:25:45.000','2024-11-05 21:42:20.000','mauricioflores@ufps.edu.co','1234532','luisapalacio@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Colaboración y Trabajo en Equipo','2024-05-02 22:16:08.000','Escasez de habilidades de investigación','2024-06-04 04:35:37.000','2024-12-03 04:48:17.000','julianariveros@ufps.edu.co','2345678','pedrorodriguez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-07-18 02:22:40.000','Habilidades de programación deficientes','2024-03-17 23:43:42.000','2024-09-09 00:46:44.000','santiagoperez@ufps.edu.co','8765432','mariacardenas@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-08-13 11:10:15.000','Dificultades para la gestión del tiempo','2024-04-24 07:35:30.000','2024-09-09 04:17:49.000','santiagoperez@ufps.edu.co','7654321','luisapalacio@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-01-21 12:25:53.000','Dificultades para la gestión del tiempo','2024-04-06 21:18:37.000','2024-10-26 01:40:31.000','felipegomez@ufps.edu.co','2345678','javierrodriguez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-08-28 16:23:21.000','Falta de actualización tecnológica','2024-08-16 07:20:04.000','2024-01-15 09:18:21.000','santiagoperez@ufps.edu.co','8765432','mauricioflores@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-12-12 11:46:13.000','Problemas de comprensión teórica','2024-12-03 12:15:27.000','2024-01-02 22:27:23.000','felipegomez@ufps.edu.co','2354534','mariapineda@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-24 22:14:41.000','Problemas de presentación y comunicación','2024-07-29 02:56:23.000','2024-07-25 09:28:14.000','santiagoperez@ufps.edu.co','1098765','sebastiancruz@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-08-13 18:30:34.000','Problemas en la resolución de problemas','2024-01-11 22:38:24.000','2024-11-13 08:26:56.000','felipegomez@ufps.edu.co','3421567','paolamendoza@ufps.edu.co'),
	 ('Habilidades de Programación','2024-07-30 22:11:34.000','Habilidades de programación deficientes','2024-04-11 18:08:42.000','2024-06-19 17:50:21.000','julianariveros@ufps.edu.co','1234532','luisapalacio@ufps.edu.co'),
	 ('Resolución de Problemas','2024-07-15 20:42:33.000','Dificultades para la gestión del tiempo','2024-09-08 20:02:26.000','2024-06-18 05:53:12.000','santiagoperez@ufps.edu.co','4321098','cristinaaguilar@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Investigación','2024-02-15 20:15:09.000','Escasez de habilidades de investigación','2024-09-25 11:13:35.000','2024-11-13 11:22:32.000','mauricioflores@ufps.edu.co','3421567','laurahernandez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-02-29 19:18:50.000','Problemas de comprensión teórica','2024-10-19 17:12:01.000','2024-12-19 12:40:42.000','felipegomez@ufps.edu.co','1234532','eduardopulido@ufps.edu.co'),
	 ('Comprensión Teórica','2024-08-16 05:04:02.000','Falta de colaboración y trabajo en equipo','2024-03-07 00:30:13.000','2024-06-24 06:38:39.000','felipegomez@ufps.edu.co','1098765','mauricioflores@ufps.edu.co'),
	 ('Resolución de Problemas','2024-05-12 10:38:21.000','Habilidades de programación deficientes','2024-11-24 20:30:01.000','2024-10-13 06:37:45.000','julianariveros@ufps.edu.co','4321098','valentinaospina@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-09-07 03:46:27.000','Problemas en la resolución de problemas','2024-08-18 15:43:43.000','2024-02-09 10:03:55.000','felipegomez@ufps.edu.co','4321098','mauricioflores@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-15 01:58:00.000','Falta de colaboración y trabajo en equipo','2024-06-23 04:09:15.000','2024-05-25 08:28:35.000','julianariveros@ufps.edu.co','3210987','eduardopulido@ufps.edu.co'),
	 ('Comprensión Teórica','2024-01-04 03:13:49.000','Dificultades para la gestión del tiempo','2024-04-19 15:25:54.000','2024-05-16 18:54:06.000','felipegomez@ufps.edu.co','4321098','mariapineda@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-03 03:00:44.000','Dificultades para la gestión del tiempo','2024-08-25 19:35:43.000','2024-12-29 19:18:06.000','felipegomez@ufps.edu.co','1234532','eduardopulido@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-09-28 17:53:23.000','Habilidades de programación deficientes','2024-05-20 09:54:03.000','2024-11-25 06:04:21.000','mauricioflores@ufps.edu.co','1234532','juanlopez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-03-22 13:44:48.000','Escasez de habilidades de investigación','2024-09-05 17:40:48.000','2024-03-15 10:22:31.000','julianariveros@ufps.edu.co','1098765','julianariveros@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Comprensión Teórica','2024-11-02 10:35:31.000','Dificultades para la gestión del tiempo','2024-05-12 23:04:38.000','2024-08-17 19:21:57.000','mauricioflores@ufps.edu.co','4321098','carolinavelez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-10-20 18:43:15.000','Falta de actualización tecnológica','2024-12-04 15:51:25.000','2024-08-15 12:08:46.000','felipegomez@ufps.edu.co','83254234','valentinaospina@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-12-10 06:08:05.000','Habilidades de programación deficientes','2024-08-31 17:14:31.000','2024-02-09 19:39:32.000','julianariveros@ufps.edu.co','2131232','anacastillo@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-07 17:08:45.000','Problemas en la resolución de problemas','2024-10-28 09:53:41.000','2024-06-29 23:25:57.000','santiagoperez@ufps.edu.co','1234532','camilogomez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-13 04:22:45.000','Habilidades de programación deficientes','2024-05-18 02:34:51.000','2024-01-23 07:28:05.000','mauricioflores@ufps.edu.co','2131232','valentinaospina@ufps.edu.co'),
	 ('Resolución de Problemas','2024-02-14 02:51:50.000','Problemas de presentación y comunicación','2024-01-30 12:50:05.000','2024-08-26 05:05:54.000','mauricioflores@ufps.edu.co','2354534','camilogomez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-03-27 19:04:15.000','Falta de actualización tecnológica','2024-09-14 18:06:35.000','2024-02-02 15:42:25.000','santiagoperez@ufps.edu.co','3421567','santiagoperez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-10-10 19:20:49.000','Escasez de habilidades de investigación','2024-09-23 10:07:02.000','2024-10-23 15:56:15.000','julianariveros@ufps.edu.co','3210987','juancardenas@ufps.edu.co'),
	 ('Resolución de Problemas','2024-09-19 19:17:12.000','Dificultades para la gestión del tiempo','2024-10-11 09:11:11.000','2024-12-29 03:36:31.000','mauricioflores@ufps.edu.co','3421567','mariacardenas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-09-02 10:35:07.000','Dificultades para la gestión del tiempo','2024-03-17 14:57:32.000','2024-08-03 18:40:49.000','santiagoperez@ufps.edu.co','1234532','eduardopulido@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Comprensión Teórica','2024-07-19 08:36:54.000','Problemas de presentación y comunicación','2024-05-12 13:25:35.000','2024-09-17 11:12:03.000','felipegomez@ufps.edu.co','3210987','mariacardenas@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-11-24 11:35:30.000','Dificultades para la gestión del tiempo','2024-09-17 09:55:11.000','2024-12-29 15:06:03.000','felipegomez@ufps.edu.co','2354534','luisapalacio@ufps.edu.co'),
	 ('Comprensión Teórica','2024-07-25 13:35:22.000','Dificultades para la gestión del tiempo','2024-01-27 02:53:10.000','2024-06-27 15:49:22.000','julianariveros@ufps.edu.co','6543210','sofiatoro@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-01-15 20:08:13.000','Problemas de comprensión teórica','2024-09-02 07:10:35.000','2024-05-10 06:19:59.000','felipegomez@ufps.edu.co','6543210','julianariveros@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-04-15 21:38:19.000','Dificultades para la gestión del tiempo','2024-02-26 07:03:44.000','2024-07-22 04:26:14.000','mauricioflores@ufps.edu.co','83254234','pedrorodriguez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-01-04 18:24:29.000','Problemas de presentación y comunicación','2024-01-23 08:57:09.000','2024-01-10 18:40:14.000','santiagoperez@ufps.edu.co','3210987','danielmartinez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-11-13 20:13:54.000','Habilidades de programación deficientes','2024-05-25 01:30:48.000','2024-04-14 08:40:05.000','mauricioflores@ufps.edu.co','2345678','nataliacastro@ufps.edu.co'),
	 ('Comprensión Teórica','2024-03-13 06:23:31.000','Problemas en la resolución de problemas','2024-04-02 17:37:46.000','2024-01-19 17:05:21.000','santiagoperez@ufps.edu.co','9876123','kevin@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-05-20 10:51:23.000','Problemas de presentación y comunicación','2024-06-11 14:59:53.000','2024-07-18 16:36:09.000','santiagoperez@ufps.edu.co','9876123','cristinaaguilar@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-10-09 06:43:22.000','Problemas de comprensión teórica','2024-10-07 01:37:52.000','2024-12-16 13:27:29.000','felipegomez@ufps.edu.co','5432109','valeriavargas@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Presentación y Comunicación','2024-01-04 16:42:09.000','Habilidades de programación deficientes','2024-05-16 16:01:24.000','2024-06-28 21:52:58.000','julianariveros@ufps.edu.co','3210987','santiagoperez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-06-13 00:41:09.000','Problemas en la resolución de problemas','2024-12-28 10:17:55.000','2024-03-15 05:36:30.000','mauricioflores@ufps.edu.co','1234532','mariapineda@ufps.edu.co'),
	 ('Habilidades de Programación','2024-03-24 22:39:15.000','Dificultades para la gestión del tiempo','2024-11-05 11:29:52.000','2024-02-06 03:20:45.000','julianariveros@ufps.edu.co','9876543','lucasgomez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-02-20 22:11:16.000','Falta de actualización tecnológica','2024-01-05 21:40:43.000','2024-07-26 00:37:15.000','julianariveros@ufps.edu.co','2354534','nataliajimenez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-05-25 13:40:32.000','Falta de colaboración y trabajo en equipo','2024-10-22 14:50:06.000','2024-05-07 14:20:50.000','santiagoperez@ufps.edu.co','83254234','julianariveros@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-08-24 13:10:55.000','Habilidades de programación deficientes','2024-06-22 16:57:26.000','2024-01-20 05:11:11.000','santiagoperez@ufps.edu.co','4321098','andresrojas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-09-02 03:05:53.000','Falta de actualización tecnológica','2024-12-23 06:10:52.000','2024-08-23 02:04:49.000','julianariveros@ufps.edu.co','1234532','nataliajimenez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-20 12:54:38.000','Dificultades para la gestión del tiempo','2024-07-08 05:04:56.000','2024-06-22 12:20:57.000','felipegomez@ufps.edu.co','1098765','carlosramirez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-24 12:18:55.000','Problemas de comprensión teórica','2024-08-04 15:15:21.000','2024-03-12 13:36:08.000','santiagoperez@ufps.edu.co','2131232','juanlopez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-10-09 03:39:38.000','Escasez de habilidades de investigación','2024-05-07 18:56:41.000','2024-05-22 07:47:04.000','julianariveros@ufps.edu.co','9876123','nataliajimenez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-03-06 02:54:46.000','Problemas de comprensión teórica','2024-11-18 05:55:35.000','2024-05-10 07:58:04.000','mauricioflores@ufps.edu.co','1098765','andreaperez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-04-25 21:49:33.000','Problemas en la resolución de problemas','2024-07-15 21:39:26.000','2024-05-06 15:59:38.000','mauricioflores@ufps.edu.co','83254234','sebastiancruz@ufps.edu.co'),
	 ('Resolución de Problemas','2024-03-18 01:36:34.000','Dificultades para la gestión del tiempo','2024-07-28 16:55:56.000','2024-12-20 01:18:14.000','mauricioflores@ufps.edu.co','6543210','javierrodriguez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-10 02:23:40.000','Problemas de comprensión teórica','2024-01-09 08:01:51.000','2024-11-24 13:52:49.000','mauricioflores@ufps.edu.co','1098765','nataliacastro@ufps.edu.co'),
	 ('Resolución de Problemas','2024-08-02 20:39:09.000','Falta de actualización tecnológica','2024-05-15 17:49:57.000','2024-08-20 02:15:20.000','mauricioflores@ufps.edu.co','7654321','sergiovelez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-11-23 20:39:19.000','Falta de colaboración y trabajo en equipo','2024-03-18 06:28:40.000','2024-06-21 09:12:50.000','felipegomez@ufps.edu.co','1234532','mauricioflores@ufps.edu.co'),
	 ('Habilidades de Programación','2024-01-01 22:47:03.000','Falta de colaboración y trabajo en equipo','2024-01-11 11:11:53.000','2024-11-26 22:18:21.000','mauricioflores@ufps.edu.co','7654321','luisapalacio@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-27 21:33:40.000','Escasez de habilidades de investigación','2024-02-05 20:28:28.000','2024-05-29 02:16:52.000','felipegomez@ufps.edu.co','4321098','paolamendoza@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-18 14:22:19.000','Escasez de habilidades de investigación','2024-10-26 17:15:37.000','2024-03-13 08:07:00.000','mauricioflores@ufps.edu.co','3210987','cristinaaguilar@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-21 14:23:50.000','Problemas de comprensión teórica','2024-04-20 17:06:22.000','2024-08-07 08:22:20.000','julianariveros@ufps.edu.co','6543210','nataliacastro@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Gestión del Tiempo','2024-05-16 15:08:44.000','Escasez de habilidades de investigación','2024-11-18 03:14:57.000','2024-10-15 06:56:46.000','santiagoperez@ufps.edu.co','1098765','nataliajimenez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-02-29 00:13:28.000','Problemas en la resolución de problemas','2024-01-13 22:07:48.000','2024-09-18 00:53:21.000','julianariveros@ufps.edu.co','7654321','danielmartinez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-04-27 04:10:01.000','Problemas de presentación y comunicación','2024-05-29 20:17:26.000','2024-04-01 03:34:20.000','santiagoperez@ufps.edu.co','4321098','valentinaospina@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-06-03 16:31:10.000','Problemas de presentación y comunicación','2024-05-27 12:15:56.000','2024-06-13 09:28:08.000','mauricioflores@ufps.edu.co','8765432','javierrodriguez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-04-11 01:37:26.000','Problemas en la resolución de problemas','2024-04-10 03:36:51.000','2024-08-15 02:13:26.000','julianariveros@ufps.edu.co','5432109','paolamendoza@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-01-28 13:01:10.000','Falta de actualización tecnológica','2024-04-08 02:25:07.000','2024-11-24 08:45:09.000','julianariveros@ufps.edu.co','3210987','andreaperez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-02-02 07:11:25.000','Problemas de presentación y comunicación','2024-07-03 12:28:06.000','2024-01-07 18:28:30.000','mauricioflores@ufps.edu.co','3421567','andreaperez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-08-02 09:04:55.000','Falta de colaboración y trabajo en equipo','2024-06-22 20:19:10.000','2024-05-25 15:23:21.000','mauricioflores@ufps.edu.co','2354534','mauricioflores@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-01-12 15:20:47.000','Problemas de presentación y comunicación','2024-04-18 22:12:50.000','2024-01-07 22:58:19.000','felipegomez@ufps.edu.co','1234532','danielavargas@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-07-14 18:23:06.000','Habilidades de programación deficientes','2024-10-27 22:22:45.000','2024-04-22 07:20:42.000','felipegomez@ufps.edu.co','83254234','santiagoperez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Actualización Tecnológica','2024-06-12 07:30:19.000','Problemas de comprensión teórica','2024-03-10 16:45:21.000','2024-10-03 11:11:31.000','felipegomez@ufps.edu.co','2345678','julianariveros@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-05-26 22:04:00.000','Problemas de presentación y comunicación','2024-02-27 16:49:40.000','2024-01-31 14:48:41.000','julianariveros@ufps.edu.co','8765432','lauragonzalez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-03-25 19:52:48.000','Problemas de comprensión teórica','2024-04-09 05:22:08.000','2024-04-27 09:08:21.000','santiagoperez@ufps.edu.co','3210987','eduardopulido@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-04-01 20:10:16.000','Problemas en la resolución de problemas','2024-05-20 10:17:29.000','2024-08-21 08:57:55.000','julianariveros@ufps.edu.co','3210987','sebastiancruz@ufps.edu.co'),
	 ('Resolución de Problemas','2024-02-08 09:41:34.000','Falta de actualización tecnológica','2024-05-21 23:18:50.000','2024-05-21 08:17:07.000','julianariveros@ufps.edu.co','9876543','juancardenas@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-01-29 10:08:41.000','Dificultades para la gestión del tiempo','2024-07-14 16:52:19.000','2024-09-20 17:34:32.000','santiagoperez@ufps.edu.co','1098765','kevin@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-11-15 12:58:22.000','Falta de colaboración y trabajo en equipo','2024-08-09 19:31:44.000','2024-09-08 16:41:25.000','felipegomez@ufps.edu.co','4321098','paolamendoza@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-03-18 04:30:37.000','Problemas en la resolución de problemas','2024-11-01 07:52:17.000','2024-03-31 23:12:56.000','mauricioflores@ufps.edu.co','1234532','mariacardenas@ufps.edu.co'),
	 ('Habilidades de Programación','2024-04-10 22:32:49.000','Escasez de habilidades de investigación','2024-11-15 01:58:00.000','2024-09-23 08:45:28.000','felipegomez@ufps.edu.co','2131232','paolamendoza@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-30 22:09:17.000','Falta de actualización tecnológica','2024-01-23 23:31:53.000','2024-04-05 02:51:54.000','julianariveros@ufps.edu.co','4321098','isabelgonzalez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-09-26 15:24:09.000','Falta de actualización tecnológica','2024-10-23 00:16:53.000','2024-08-16 03:14:57.000','mauricioflores@ufps.edu.co','6543210','paolamendoza@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-10-20 13:50:56.000','Habilidades de programación deficientes','2024-08-23 21:18:04.000','2024-02-16 09:57:11.000','santiagoperez@ufps.edu.co','9876543','camilovalencia@ufps.edu.co'),
	 ('Habilidades de Programación','2024-05-30 09:29:45.000','Problemas de presentación y comunicación','2024-01-31 22:42:41.000','2024-01-05 05:51:25.000','santiagoperez@ufps.edu.co','3210987','camilovalencia@ufps.edu.co'),
	 ('Habilidades de Programación','2024-08-18 21:24:54.000','Problemas de presentación y comunicación','2024-10-17 10:03:33.000','2024-02-10 20:29:44.000','mauricioflores@ufps.edu.co','1098765','isabelgonzalez@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-11-15 00:28:06.000','Dificultades para la gestión del tiempo','2024-04-02 13:08:13.000','2024-08-15 06:44:54.000','felipegomez@ufps.edu.co','2354534','eduardopulido@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-12-23 22:17:57.000','Problemas de presentación y comunicación','2024-08-06 22:09:55.000','2024-10-31 17:48:00.000','julianariveros@ufps.edu.co','83254234','sebastiancruz@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-09-21 23:18:42.000','Problemas de comprensión teórica','2024-02-25 20:38:30.000','2024-10-28 18:30:53.000','mauricioflores@ufps.edu.co','9876543','sofiatoro@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-10-03 23:06:53.000','Problemas de presentación y comunicación','2024-01-20 19:05:14.000','2024-10-13 16:39:22.000','julianariveros@ufps.edu.co','6543210','marcelaherrera@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-11-08 11:57:48.000','Falta de actualización tecnológica','2024-07-31 00:18:27.000','2024-11-07 04:27:04.000','santiagoperez@ufps.edu.co','2354534','davidortega@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-11-21 04:32:45.000','Problemas de comprensión teórica','2024-07-29 23:23:57.000','2024-04-19 21:59:04.000','mauricioflores@ufps.edu.co','2354534','sofiatoro@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Presentación y Comunicación','2024-10-07 18:47:39.000','Habilidades de programación deficientes','2024-07-05 18:10:05.000','2024-04-14 06:29:29.000','santiagoperez@ufps.edu.co','4321098','kevin@ufps.edu.co'),
	 ('Comprensión Teórica','2024-10-30 18:36:57.000','Problemas en la resolución de problemas','2024-05-05 06:42:41.000','2024-05-25 19:51:33.000','felipegomez@ufps.edu.co','3421567','valentinaospina@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-06-22 09:44:22.000','Habilidades de programación deficientes','2024-06-08 11:05:42.000','2024-05-24 12:24:43.000','felipegomez@ufps.edu.co','3210987','lauragonzalez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-06-15 12:36:21.000','Habilidades de programación deficientes','2024-11-15 00:32:48.000','2024-09-29 10:27:04.000','mauricioflores@ufps.edu.co','7654321','andreafernandez@ufps.edu.co'),
	 ('Resolución de Problemas','2024-07-06 17:10:11.000','Escasez de habilidades de investigación','2024-07-18 04:09:06.000','2024-02-23 09:13:13.000','julianariveros@ufps.edu.co','9876123','juancardenas@ufps.edu.co'),
	 ('Habilidades de Programación','2024-12-26 14:29:22.000','Falta de colaboración y trabajo en equipo','2024-01-13 06:30:09.000','2024-07-04 00:42:30.000','santiagoperez@ufps.edu.co','6543210','lauragonzalez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-05-24 14:34:28.000','Problemas en la resolución de problemas','2024-08-24 04:58:10.000','2024-04-25 13:43:44.000','mauricioflores@ufps.edu.co','9876123','andresrojas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-08-17 16:14:04.000','Habilidades de programación deficientes','2024-09-11 23:45:46.000','2024-11-07 01:36:22.000','julianariveros@ufps.edu.co','7654321','andresrojas@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-03-12 13:07:49.000','Problemas de presentación y comunicación','2024-01-12 01:58:40.000','2024-04-12 17:41:02.000','felipegomez@ufps.edu.co','1234532','valeriavargas@ufps.edu.co'),
	 ('Resolución de Problemas','2024-09-16 14:48:27.000','Problemas de presentación y comunicación','2024-11-28 02:51:01.000','2024-01-24 00:18:50.000','mauricioflores@ufps.edu.co','2354534','mariacardenas@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Colaboración y Trabajo en Equipo','2024-06-05 15:25:30.000','Problemas de comprensión teórica','2024-02-13 09:39:16.000','2024-08-10 10:36:37.000','mauricioflores@ufps.edu.co','2354534','andreafernandez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-06-13 20:25:22.000','Problemas de presentación y comunicación','2024-04-21 07:15:54.000','2024-06-21 01:31:35.000','felipegomez@ufps.edu.co','2354534','camilovalencia@ufps.edu.co'),
	 ('Resolución de Problemas','2024-10-15 10:40:02.000','Dificultades para la gestión del tiempo','2024-08-11 22:24:47.000','2024-03-25 19:25:34.000','santiagoperez@ufps.edu.co','9876543','javierrodriguez@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-04 13:48:56.000','Dificultades para la gestión del tiempo','2024-01-14 20:51:04.000','2024-09-27 22:25:22.000','julianariveros@ufps.edu.co','9876123','sofiatoro@ufps.edu.co'),
	 ('Actualización Tecnológica','2024-03-31 23:28:58.000','Habilidades de programación deficientes','2024-10-01 11:30:06.000','2024-06-25 19:09:59.000','mauricioflores@ufps.edu.co','3210987','valeriavargas@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-09-08 15:17:31.000','Escasez de habilidades de investigación','2024-06-13 14:10:13.000','2024-10-14 21:54:15.000','julianariveros@ufps.edu.co','9876123','nataliajimenez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-05-31 18:27:21.000','Falta de actualización tecnológica','2024-09-11 00:21:30.000','2024-05-18 03:29:06.000','felipegomez@ufps.edu.co','6543210','carolinavelez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-12-14 10:09:37.000','Dificultades para la gestión del tiempo','2024-10-28 03:03:47.000','2024-09-15 04:30:06.000','felipegomez@ufps.edu.co','9876123','paolamendoza@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-01-18 18:56:36.000','Falta de colaboración y trabajo en equipo','2024-07-08 11:25:38.000','2024-06-24 18:40:44.000','felipegomez@ufps.edu.co','9876543','sofiatoro@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-11-18 04:29:41.000','Problemas de comprensión teórica','2024-04-24 18:05:26.000','2024-05-04 13:06:08.000','santiagoperez@ufps.edu.co','9876543','danielavargas@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-01-17 12:50:12.000','Problemas de presentación y comunicación','2024-06-03 06:18:58.000','2024-04-22 15:42:18.000','julianariveros@ufps.edu.co','2131232','kevin@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-06-07 18:28:39.000','Habilidades de programación deficientes','2024-07-22 23:43:42.000','2024-02-08 07:54:17.000','santiagoperez@ufps.edu.co','1234532','felipegomez@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-09 19:35:45.000','Falta de actualización tecnológica','2024-03-05 07:02:49.000','2024-12-24 02:31:22.000','felipegomez@ufps.edu.co','3210987','lauragonzalez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-08-08 18:24:32.000','Problemas de presentación y comunicación','2024-10-01 16:37:41.000','2024-10-11 07:45:30.000','mauricioflores@ufps.edu.co','9876123','marcelaherrera@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-05-23 01:50:32.000','Falta de actualización tecnológica','2024-10-10 06:09:21.000','2024-09-21 21:34:36.000','felipegomez@ufps.edu.co','2354534','sofiatoro@ufps.edu.co'),
	 ('Habilidades de Programación','2024-09-21 03:23:01.000','Escasez de habilidades de investigación','2024-09-27 21:08:20.000','2024-10-25 21:23:59.000','julianariveros@ufps.edu.co','8765432','andreaperez@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-06-16 21:18:14.000','Problemas en la resolución de problemas','2024-12-02 20:01:10.000','2024-08-31 00:18:33.000','julianariveros@ufps.edu.co','1098765','mariacardenas@ufps.edu.co'),
	 ('Comprensión Teórica','2024-12-15 09:21:59.000','Falta de colaboración y trabajo en equipo','2024-06-07 11:32:31.000','2024-01-31 23:36:10.000','julianariveros@ufps.edu.co','8765432','kevin@ufps.edu.co'),
	 ('Colaboración y Trabajo en Equipo','2024-02-06 19:57:00.000','Problemas en la resolución de problemas','2024-08-21 19:05:39.000','2024-05-11 04:03:59.000','julianariveros@ufps.edu.co','7654321','sofiatoro@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-03 08:24:47.000','Problemas en la resolución de problemas','2024-01-19 11:21:36.000','2024-08-03 21:12:46.000','mauricioflores@ufps.edu.co','7654321','camilogomez@ufps.edu.co');
INSERT INTO public.consultancy (aspects_to_improve,creation_date,difficulties_encountered,end_date,start_date,academic_friend,course,student) VALUES
	 ('Habilidades de Programación','2024-12-12 08:09:21.000','Dificultades para la gestión del tiempo','2024-01-22 02:47:13.000','2024-04-05 19:35:40.000','santiagoperez@ufps.edu.co','2345678','jorge@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-06-04 16:54:39.000','Escasez de habilidades de investigación','2024-03-31 02:26:35.000','2024-05-01 23:19:30.000','felipegomez@ufps.edu.co','1098765','javierrodriguez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-06-27 06:36:35.000','Dificultades para la gestión del tiempo','2024-09-05 23:47:23.000','2024-12-10 16:43:42.000','felipegomez@ufps.edu.co','9876543','lauragonzalez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-12-16 19:43:59.000','Falta de actualización tecnológica','2024-10-15 15:26:08.000','2024-05-07 04:24:32.000','mauricioflores@ufps.edu.co','4321098','andreafernandez@ufps.edu.co'),
	 ('Presentación y Comunicación','2024-03-04 09:01:35.000','Problemas de comprensión teórica','2024-04-18 15:00:26.000','2024-11-12 18:05:44.000','felipegomez@ufps.edu.co','83254234','camilovalencia@ufps.edu.co'),
	 ('Gestión del Tiempo','2024-02-08 09:27:03.000','Problemas de comprensión teórica','2024-02-29 05:27:04.000','2024-04-30 04:13:03.000','felipegomez@ufps.edu.co','3421567','camilogomez@ufps.edu.co'),
	 ('Habilidades de Programación','2024-07-20 21:40:43.000','Problemas de comprensión teórica','2024-06-16 00:43:26.000','2024-03-17 08:58:11.000','santiagoperez@ufps.edu.co','7654321','mariapineda@ufps.edu.co'),
	 ('Comprensión Teórica','2024-02-25 10:26:38.000','Problemas de comprensión teórica','2024-12-13 06:59:50.000','2024-01-06 06:14:07.000','mauricioflores@ufps.edu.co','8765432','mariapineda@ufps.edu.co'),
	 ('Comprensión Teórica','2024-08-29 08:39:14.000','Problemas de presentación y comunicación','2024-05-03 06:33:45.000','2024-02-21 07:55:05.000','mauricioflores@ufps.edu.co','2345678','danielmartinez@ufps.edu.co'),
	 ('Habilidades de Investigación','2024-10-01 20:10:39.000','Problemas de presentación y comunicación','2024-11-18 18:26:55.000','2024-04-11 21:40:58.000','julianariveros@ufps.edu.co','7654321','juanlopez@ufps.edu.co');
