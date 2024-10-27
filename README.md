# PRODUCTOS

Para lograr usar este microservicio primero se tendrá que registrar usando la URL [http://localhost:8090/auth/registro](http://localhost:8090/auth/registro), ingresando:

- Email

- Contraseña

- Rol

Se deja un ejemplo:

{

    "email": "valen1@gmail.com",
    
    "password":"122234",
    
    "rol":"USER_ROLE"
    
}

Luego de que se da la confirmación (OK 200), necesitará ingresar (hacerse el login), usando la URL [http://localhost:8090/auth/login](http://localhost:8090/auth/login) , cargando los mismos datos que se cargaron anteriormente.

Cuando su confirmación sea afirmativa (OK 200), se devolverá un token que, deberá ser colocado en la sección de Postman **Authorization, la opción Bearer token** y, en el rectángulo que aparece al lado, colocará el token que se le ha dado en cada endpoint que desee usar.



## Una vez hecho estos pasos, dejamos las URL disponibles en este microservicio:

- [Obtener todos los productos](#obtener-todos-los-productos)

- [Obtener un producto en especifico](#obtener-un-producto)

- [Producto_más_vendido](#producto-más-vendido)

- [Agregar un producto](agregar-un-producto)

- [Modificar datos de un producto](modificar-datos-de-un-producto)

- [Eliminar un producto](eliminar-un-producto)

### Se aclara que el valor del producto, debe cargarse sin tenerse en cuenta el valor del dólar, ya que ese calculo se hace automáticamente en el servicio

## Obtener todos los productos
La URI para obtener todos los productos es: [http://localhost:8070/productos](http://localhost:8070/productos)

Devolverá una lista de productos en caso de tener elementos cargados (200).

Si falla, devolverá un 404.

## Obtener un producto
La URI para obtener un producto en especifico es: [http://localhost:8070/productos/{id}](http://localhost:8070/productos/{id})

Donde {id} será reemplazado por un número.

Si sucede todo con éxito (200), devolverá el producto.

Si falla, devolverá un 404.

## Producto más vendido
La URI para obtener el producto más vendido es: [http://localhost:8070/productos/productoMasVendido](http://localhost:8070/productos/productoMasVendido)

Si sucede todo con éxito (200), devolverá el producto.

Si falla, devolverá un 404.

## Agregar un producto
La URI para agregar un nuevo producto es: http://localhost:8070/productos

Si sucede todo con éxito (201), devolverá el producto.

Si falla, devolverá un 404.

Se deja un ejemplo de como cargar un producto nuevo:

{

    "cantidad_stock":4,
    
    "valor":2050.3,
    
    "nombre":"Azucar"
    
}

## Modificar datos de un producto
La URI para modificar un producto en especifico es: [http://localhost:8070/productos/{id}](http://localhost:8070/productos/{id})

Donde {id} será reemplazado por un número. Además que se tiene que enviar el producto a modificar con los nuevos datos.

Si sucede todo con éxito (200), devolverá el producto.

Si falla, devolverá un 404.

Se deja un ejemplo de como enviar un producto que se le desea modificar un atributo a partir del ejemplo anterior:

{

    "cantidad_stock":7,
    
    "valor":2012.9,
    
    "nombre":"Azucar"
    
}

## Eliminar un producto
La URI para eliminar un producto en especifico es: [http://localhost:8070/productos/{id}](http://localhost:8070/productos/{id})

Donde {id} será reemplazado por un número.

Si sucede todo con éxito (200), devolverá el producto.

Si falla, devolverá un 404.
