Feature: Búsqueda en Airbnb

  @test
  Scenario: Búsqueda de hospedaje en Vichayito

    Given que ingreso a la aplicación Airbnb
    And cierro la ventana de inciar sesión
    When ingreso al formulario Where To?
    And realizo la busqueda "Hoteles en Vichayito"
    And salto la seleción de días y demás filtros
    Then debo encontrar más de un resultado disponible
    And muestra el texto "Over 1,000 places"