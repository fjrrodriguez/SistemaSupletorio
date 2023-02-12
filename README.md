# Supletorio
### Para el desarrollo de la actividade se plantearon inicialmente seis clases:
#### Cita: Id, tipo de cita, paciente, estado, descripcion, fecha de registro, hora de registro, hora de modificacion y fecha de modificacion.
#### Datos personales: id, nombres, apellidos, direccion, telefono y sexo.
#### Horario disponibilidad:id, medico, fecha, hora de inicio y hora final.
#### Medico: Extiende de la clase datos personales.
#### Paciente: extiende de la clase datos personales.
#### Tipo de cita: id, nombre.
### Se manejo la estructura por capas escencialmente controller, service, repository.
### Se implementa herencia, polimorfismo y se incluyen interfaces como ICitaRepository, IPersonaRepository, entre otras.
###  Para la ejecucion del programa utilizaremos las siguientes lineas de comando en postman:
#### Crear paciente: localhost:8080/api/personas/crear-paciente
#### Listar paciente: localhost:8080/api/personas/listar-pacientes
####  Actualiza datos del paciente: localhost:8080/api/personas/actualizar-paciente
#### Eliminar paciente: localhost:8080/api/personas/eliminar-paciente/4
#### Listar medicos: localhost:8080/api/personas/listar-medicos
####  Establecer horario medico: localhost:8080/api/citas/establecer-horario-medico
####  Listar horario medico: localhost:8080/api/citas/consultar-horario-medico/2
#### Agendar cita medica : localhost:8080/api/citas/agendar-cita-medica
#### Consultar el historial medico por paiente: localhost:8080/api/citas/listar-historial-medico-paciente/1
