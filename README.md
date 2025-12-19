# ACompletar
Proyecto de aplicacion para facilitar el completar la obtención de todos los elementos de Animal Crossing New Horizons.

[MongoDB]:
- Añadir más Queries y pasarlas a un documento. (Alex)
- Retener la conexion 30 segundos con "maxConnectionIdleTime" o alternativas. (Ekaitz)

[DIN - ADTi]:
- DIN:
    - VENTANA LISTAS
        - Añadir la lógica de los checkbox (Añadir o eliminar más de un juego). (Alex)
        - Modificar el nombre de las listas con el click. (Alex)

    - VENTANA REVIEWS
        - Al elegir un juego con una review ya existente por el propio usuario que se le muestre en la ventana de Nueva Review. (Mikel)
        - En la ventana de Nueva Review bloquear el ComboBox de Games cuando no hay una Plataforma seleccionada. (Mikel) [OPCIONAL]
        - Implementar filtro por nombre al darle a intro y/o botón buscar. (Mikel)

    - VENTANA MAIN MENU
        - Añadir la lógica de los checkbox: (Ekaitz)
            - Al cargar la ventana que aparezcan marcados los juegos que tiene guardados el Usuario.
            - Al seleccionar el checkbox el juego se tiene que guardar automaticamente en la lista principal (My Games) del Usuario y viceversa.
            - Por si acaso: Verificar que al ordenar la tabla los checkbox se mueven con su respectuvo VideoJuego.
        - Implementar filtro por nombre al darle a intro y/o botón buscar.
        - Implementar filtros generales. (Ekaitz)
        - Implementar acordeon en  los filtros. (Ekaitz) [OPCIONAL]
- ADTi:
    - Implementar Hibernate: (Ekaitz & Alex & Mikel)
        - Buscar y añadir los .jar al proyecto. (Ekaitz) [PRIORIDAD]

[DW]:
- CLIENTE:
    - HTML y CSS de Menu Principal, Listas y Reviews. (Alex)
    - Quitar peticion duplicada de contraseña en el SignUp y Modify y añadir lógica del ojo. (Alex & Mikel)

- SERVIDOR:
    - Implementar sesiones. (Ekaitz)
    - Implementar validaciones. (Ekaitz)
    - Hashear contraseña. (Ekaitz)
