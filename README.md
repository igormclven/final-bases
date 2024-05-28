# Proyecto Final Bases

Usando SpringBoot - Postgres y Thymeleaf (Tailwind). 


Consultas varias

```sql
select * from espacio where espacio."n_Estado" = 'disponible';

select *from public.registro;

select * from registro where "k_idEspacio" = 1 and "f_fechaSalida" is null;

SELECT COUNT(*) FROM pago;

select * from pago;

SELECT COUNT(*) from pago;


SELECT
    FLOOR(EXTRACT(EPOCH FROM (r."f_fechaSalida" - r."f_fechaEntrada")) / 60 * t."v_valor") AS valor
FROM
    registro r
INNER JOIN
    tarifa t
ON
    r."n_tipoVehiculo" = t."n_tipoVehiculo"
WHERE
    r."k_idRegistro" = 1;

insert into tarifa("k_idTarifa","n_tipoVehiculo", "f_añoVigencia", "v_valor") values (2, 'automovil', 2024, 160);

select * from pago;

select * from tarifa;

select * from registro where n_placa = 'ABC123';

select *  from espacio  where "k_idArea" = 1  order by "k_idEspacio" asc;

select * from parqueadero;

select * from tarifa;
```


Consultas varias
```sql
select * from pago

select * from registro where  "f_fechaSalida" is null



ALTER TABLE pago
ADD CONSTRAINT "CK_fechaPago"
CHECK (
    "f_fechaPago" >= '2021-01-01 00:00:00'::timestamp AND 
    "f_fechaPago" <= CURRENT_TIMESTAMP
);
```

Calcular Tarifa
```sql
-- Todos los registros
select * from registro;

-- Diferencia de fechas en minutos
SELECT EXTRACT(EPOCH FROM ("f_fechaSalida" - "f_fechaEntrada")) / 60 AS minutos
FROM registro;

-- Tarifas aplicadas al parqueadero
SELECT tarifa.*
FROM parqueadero_tarifa AS pt
JOIN tarifa ON pt."k_idTarifa" = tarifa."k_idTarifa"
WHERE pt."k_idParqueadero" = 1;

-- Combinación para calcular la tarifa
SELECT (EXTRACT(EPOCH FROM (reg."f_fechaSalida" - reg."f_fechaEntrada")) / 60) * tar."v_valor" AS total_costo
FROM registro AS reg
JOIN (
	SELECT tarifa.*
	FROM parqueadero_tarifa AS pt
	JOIN tarifa ON pt."k_idTarifa" = tarifa."k_idTarifa"
	) AS tar ON reg."n_tipoVehiculo" = tar."n_tipoVehiculo"
WHERE reg."k_idRegistro" = 1;

-- Redondear a enteros
SELECT FLOOR((EXTRACT(EPOCH FROM (reg."f_fechaSalida" - reg."f_fechaEntrada")) / 60) * tar."v_valor") AS total_costo
FROM registro AS reg
JOIN (
	SELECT tarifa.*
	FROM parqueadero_tarifa AS pt
	JOIN tarifa ON pt."k_idTarifa" = tarifa."k_idTarifa"
	) AS tar ON reg."n_tipoVehiculo" = tar."n_tipoVehiculo"
WHERE reg."k_idRegistro" = 51;

```
