-- A. Nombre de la oficina de la cual es gerente una persona, de la cual conocemos el nombre (no se posee el nombre completo)
SELECT o.nombre AS nombre_oficina
FROM oficina o
WHERE o.gerente LIKE '%nombre_parcial%';

-- B. Nombre de todas las oficinas que posee la empresa. Incluir en la consulta el nombre de la ciudad y del departamento en el cual se encuentran.

SELECT o.nombre AS nombre_oficina, ci.nombre AS nombre_ciudad, d.nombre AS nombre_departamento
FROM oficina o
INNER JOIN ciudades ci ON o.cod_ciudad = ci.codigo
INNER JOIN departamento d ON ci.cod_departamento = d.codigo;


--C. Listado (nombre) de las oficinas en las cuales se encuentra un producto en particular, del cual se conoce parcialmente el NOMBRE
SELECT DISTINCT o.nombre AS nombre_oficina
FROM oficina o
INNER JOIN inventario inv ON o.codigo = inv.cod_oficina
INNER JOIN producto p ON inv.cod_producto = p.codigo
WHERE p.descripcion LIKE '%nombre_parcial%';

--D. Nombre de la oficina que posee la mayor cantidad de existencia en toda la empresa (sumar todas las existencias de la oficina).

SELECT o.nombre AS nombre_oficina
FROM oficina o
INNER JOIN (
    SELECT cod_oficina, SUM(existencia) AS total_existencia
    FROM inventario
    GROUP BY cod_oficina
    ORDER BY total_existencia DESC
    LIMIT 1
) AS max_exist ON o.codigo = max_exist.cod_oficina;

--E. Listado de las oficinas que poseen una existencia menor a “###”. Incluir en el listado oficina, ciudad, producto y existencia

SELECT o.nombre AS nombre_oficina, ci.nombre AS nombre_ciudad, p.descripcion AS nombre_producto, inv.existencia
FROM oficina o
INNER JOIN ciudades ci ON o.cod_ciudad = ci.codigo
INNER JOIN inventario inv ON o.codigo = inv.cod_oficina
INNER JOIN producto p ON inv.cod_producto = p.codigo
WHERE inv.existencia < 5;


--F. Sentencia que actualice la existencia de todos los productos del inventario que pertenezcan a una oficina de una ciudad en particular (se conoce el código de la ciudad).
UPDATE inventario inv
SET existencia = nuevo_valor_existencia
WHERE inv.cod_oficina IN (
    SELECT o.codigo
    FROM oficina o
    WHERE o.cod_ciudad = codigo_ciudad
);

