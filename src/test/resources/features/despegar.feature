Feature: Busqueda y selección de tiquetes áereos Despegar
  Yo como cliente quiero tener la posibilidad de buscar y separar
  vuelos áereos en la página despegar.com

  Scenario: Selección como persona natural
    Given el cliente se encuentra en la url de la página en la opcion de vuelos
    When el cliente selecciona el lugar de destino
    And llena el formulario de datos personales y confirma su información
    Then la página deberá mostrar un mensaje indicando selección