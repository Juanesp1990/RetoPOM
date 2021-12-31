Feature: Búsqueda y selección de tiquetes aéreos Despegar
  Yo como cliente quiero tener la posibilidad de buscar y separar
  vuelos áereos en la página despegar.com

  @viajeBogota
  Scenario: Destino Bogotá
    Given el cliente se encuentra en la url de la página de despegar.com en la sección de vuelos
    When el cliente selecciona el lugar de origen-destino, solo ida y oprime el botón buscar
    And el cliente escoge el vuelo, indica su equipaje y completa la información de la reserva
    Then el cliete debería ver los datos de la persona que viaja antes de presionar el botón comprar

  @viajeBarranquilla
  Scenario: Destino Barranquilla
    Given el cliente se encuentra en la url de la página de despegar en la sección de vuelos
    When el cliente selecciona el lugar de origen-destino, ida y vuelta y oprime el botón buscar
    And el cliente escoge el vuelo, indica su equipaje adicional
    Then el cliete debería ver un mensaje de falta poco y el lugar de origen-destino