#Author: naimferreira.ads12@gmail.com
#Date: 02/02/2024

@Web
Feature: Comprar produto

  @CT_01
  Scenario: Comprar camisa vermelha
    Given Que eu esteja logado no sistema saucedemo
    When coloco a camisa vermelha no carrinho
    And preencho as informações para finalizar compra
    Then valido se a compra foi feita com sucesso
    
    @CT_02
 Scenario: Comprar bolsa
    Given Que eu esteja logado no sistema saucedemo
    When coloco a bolsa no carrinho 
    And preencho as informações para finalizar compra
    Then valido se a compra foi feita com sucesso
    
     @CT_03
  Scenario: Comprar com preço menor
    Given Que eu esteja logado no sistema saucedemo
    When adiciono produtos no carrinho com preço menor
    And preencho as informações para finalizar compra
    Then valido se a compra foi feita com sucesso

