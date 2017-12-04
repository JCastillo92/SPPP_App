/*crear perfiles*/
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (1,'Estudiante');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (2,'Gestor');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (3,'Tutor');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (4,'Consejo');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (5,'Secretaria');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (6,'Coordinador');
insert into tb_perfil (id_tbperfil,descripcion_perfil) values (7,'Administrador');

/*creacion empresas ficticia de prueba para probar AUTOCOMPLETAR en timepo real*/
/*
insert into tb_empresa (id_empresa,nombre_empresa,nombre_gerente,telefono_empresa,direccion_empresa) values (1721397113,'empresa ficticia','nombre gerente','3060649','direccion empresa');
*/


/*crear tb_usuario para cada perfil*/
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1111111111','unoest@hotmail.com','1111','nestnombre','aestapellido','3060649','unodirecc',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('2222222222','dos@hotmail.com','2222','2nombre','2apellido','222222','dos direcccion',2);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('3333333333','tres@hotmail.com','3333','3nombre','3apellido','3333','tres direcccion',3);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('4444444444','cuatro@hotmail.com','4444','4nombre','4apellido','44444','cuatro direcccion',4);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('5555555555','cinco@hotmail.com','5555','5nombre','5apellido','55555','cinco direcccion',5);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('6666666666','seis@hotmail.com','6666','6nombre','6apellido','66666','seis direcccion',6);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('7777777777','siete@hotmail.com','7777','7nombre','7apellido','77777','siete direcccion',7);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('333','tres@hotmail.com','333','33nombre','33apellido','333','tres3 direcccion',3);


/*LLENAR TABLA ESTUDIANTES como si fuese llenado automaticamente con los datos del EXCEL cabe mencionar que dichos usuarios deben pasarse la ci como USUARIO Y CLAVE a la tabla usuarios (primero se debe crear en la tb_usuario)*/
/*primero crearlos en tb_usuario*/
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('123','123@hotmail.com','123','123nombre','123apellido','123','123 direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1234','1234@hotmail.com','1234','1234nombre','1234apellido','1234','1234 direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('321','321@hotmail.com','321','321nombre','321apellido','321','321 direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1111','hotm','1111','nom','app','3060649','direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1112','hotm','1112','nom','app','3060649','direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1113','hotm','1113','nom','app','3060649','direcccion',1);
insert into tb_usuario (id_usuario,correo,clave,nombre,apellido,telefono,direccion,id_perfil) values ('1114','hotm','1114','nom','app','3060649','direcccion',1);


insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1111111111,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (123,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1234,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (321,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1111,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1112,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1113,6,60);
insert into tb_estudiante (cedula_est,ultimonivel,porcentajemateriasaprobadas) values (1114,6,60);

/*crear tb_tutor para completar usuarios*/

insert into tb_tutor (cedula_tut,cant_visitas,sector_preferencia) values (333,5,'sur');
insert into tb_tutor (cedula_tut,cant_visitas,sector_preferencia) values (3333333333,5,'sur');



/*AQUI ABAJO YA EMPIEZA EL PROCESO DE LLENADO QUE REALIZARIA EL ESTUDIANTE*/
/*tabla tipo_pregunta ESTA TABLA TENDRA DATOS QUEMADOS*/
insert into tb_tipopregunta (tipo) values ('TEXT');
insert into tb_tipopregunta (tipo) values ('SECRET');
insert into tb_tipopregunta (tipo) values ('TEXTAREA');
insert into tb_tipopregunta (tipo) values ('RADIO');
insert into tb_tipopregunta (tipo) values ('SELECTONE');
insert into tb_tipopregunta (tipo) values ('SELECTMANY');
insert into tb_tipopregunta (tipo) values ('CHECKONE');
insert into tb_tipopregunta (tipo) values ('CHECKMANY');




/*llenar tb_proceso ESTA TABLA TENDRA DATOS QUEMADOS*/
insert into tb_proceso(descripcion,estado) values ('solicitud inicio proceso pasantia',true);
insert into tb_proceso(descripcion,estado,proceso_de) values ('ingreso datos alumno',true,1);
insert into tb_proceso(descripcion,estado,proceso_de) values ('ingreso datos empresa',true,1);

insert into tb_proceso(descripcion,estado) values ('Seccion documentacion',true);
insert into tb_proceso(descripcion,estado,proceso_de) values ('descarga y carga de archivos',true,2);


/*llenar tb_formato*/
insert into tb_formato (nombre_formato,estado_formato) values ('FORMATO_LLENADO_DATOS_ESTUDIANTE',true);
insert into tb_formato (nombre_formato,estado_formato) values ('FORMATO_LLENADO_DATOS_EMPRESA',true);


/*llenar tb_preguntas BASARSE EN LA PRIMARYKEY DE tipo_pregunta y tb_formato (pencil 2.1 Alumno)*/
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Correo:',true,1,1);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Telefono estudiante:',true,1,1);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Actividades bien definidas:',true,3,1);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Pasantia:',true,8,1);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Practica pre-profesional:',true,8,1);


insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('RUC:',true,1,2);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Nombre empresa:',true,1,2);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Telefono empresa:',true,1,2);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Direccion empresa:',true,1,2);
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Nombre a quien va dirigido el oficio en la empresa:',true,1,2);/*este se guardara en el campo gerente*/
insert into tb_preguntas (descripcion,estado_preguntas,id_tipopregunta,id_tbformato) values ('Titulo profesional:',true,1,2);

/*llenado de datos sobre tutorrr*/

/*llenado de Periodo*/

insert into tb_periodo (periodo,estado_periodo) values('1',false);
insert into tb_periodo (periodo,estado_periodo) values('2',false);
insert into tb_periodo (periodo,estado_periodo) values('3',false);


/*llenado tb_periodotutor los cuales seran automaticos*/

insert into tb_periodo_tutor (cantidad_visitas,cedula_tut,id_periodo) values (200,333,1);
insert into tb_periodo_tutor (cantidad_visitas,cedula_tut,id_periodo) values (10,3333333333,2);


/*llenado tb_horariotutor*/

insert into tb_horariotutor (hora,dia,id_tbpt) values ('07:00','Viernes',1);
insert into tb_horariotutor (hora,dia,id_tbpt) values ('09:00','Lunes',1);

/*llenado tb_visitatutor sera automatica*/
insert into tb_visitatutor (fecha_visita,estado_visita,cedula_tut)values('2017-11-28',false,333);
insert into tb_visitatutor (fecha_visita,estado_visita,cedula_tut)values('2018-11-28',false,3333333333);

/*llenar tabla TB_PASANTIA*/
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PA',1,'2017-11-28','2017-12-13',0,true,'1111111111',1);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PP',1,'2017-11-28','2017-12-13',0,true,'123',2);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PA',2,'2017-11-28','2017-12-13',0,true,'1234',3);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PP',2,'2017-11-28','2017-12-13',0,true,'321',1);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PA',3,'2017-11-28','2017-12-13',0,true,'1111',1);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PA',4,'2017-11-28','2017-12-13',0,true,'1112',2);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PP',3,'2017-11-28','2017-12-13',0,true,'1113',3);
insert into tb_pasantia (tipo_ppp,cod_ppp,fechainicio,fechafin,tiempoesperaestado,estado,cedula,id_periodo) values ('PP',4,'2017-11-28','2017-12-13',0,true,'1114',1);


/*llenado de datos en tb_detalle_pasantia*/



# SPPP_App
#pasos para volver a un commit
git reset --hard #alquequieresregresar
git push --force
