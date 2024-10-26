#PRODUCTOS

Para lograr usar este microservicio primero se tendrá que registrar usando la URL [http://localhost:8090/auth/registro](http://localhost:8090/auth/registro), ingresando:
-Email
-Contraseña
-Rol
Se deja un ejemplo:
{
    "email": "valen1@gmail.com",
    "password":"122234",
    "rol":"USER_ROLE"
}

Luego de que le da la confirmación (un 200), necesita ingresar (hacer el login), usando la URL [http://localhost:8090/auth/login](http://localhost:8090/auth/login), cargando los mismos datos que se cargaron anteriormente.
Cuando su confirmación se OK (200), se devolverá un token que, deberá ser colocado en la sección de <u>Authorization, la opción Bearer token</u> y, en el rectángulo que aparece al lado, colocará el token que se le ha dado.

##Una vez hecho estos pasos, dejamos las URL disponibles en este microservicio:
-[#Obtener todos los productos](Obtener todos los productos)
-[#Obtener_un_producto](Obtener un producto especifico)
-[#Producto_más_vendido](Obtener producto más vendido)
-[#Agregar_un_producto](Agregar un producto)
-[#Modificar_datos_de_un_producto](Modificar datos de un producto)
-[#Eliminar_un_producto](Eliminar un producto)

#Obtener todos los productos
La URI para obtener todos los productos es: http://localhost:8070/productos
Devolverá una lista de productos en caso de tener elementos cargados (200).
Si falla, devolverá un 404.

#Obtener un producto
La URI para obtener un producto en especifico es: http://localhost:8070/productos/{id}
Donde {id} será reemplazado por un número.
Si sucede todo con éxito (200), devolverá el producto.
Si falla, devolverá un 404.

#Producto más vendido
La URI para obtener el producto más vendido es: http://localhost:8070/productos/productoMasVendido
Si sucede todo con éxito (200), devolverá el producto.
Si falla, devolverá un 404.

#Agregar un producto
La URI para agregar un nuevo producto es: http://localhost:8070/productos
Si sucede todo con éxito (201), devolverá el producto.
Si falla, devolverá un 404.

#Modificar datos de un producto
La URI para modificar un producto en especifico es: http://localhost:8070/productos/{id}
Donde {id} será reemplazado por un número.
Si sucede todo con éxito (200), devolverá el producto.
Si falla, devolverá un 404.

#Eliminar un producto
La URI para eliminar un producto en especifico es: http://localhost:8070/productos/{id}
Donde {id} será reemplazado por un número.
Si sucede todo con éxito (200), devolverá el producto.
Si falla, devolverá un 404.
