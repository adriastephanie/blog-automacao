# Projeto

##Benefícios desta Estrutura

Organização: Separa claramente as responsabilidades em diferentes pacotes e classes.

Manutenibilidade: Ao usar o padrão Page Object Model, as alterações na interface da aplicação só precisam ser atualizadas em um único lugar (na classe da página correspondente).

Reutilização: Os métodos comuns estão nas classes base (BasePage e Base), evitando duplicação de código.

Legibilidade: Os testes ficam mais limpos e fáceis de entender, pois as ações estão encapsuladas nas classes de página.

Escalabilidade: É fácil adicionar novas páginas e novos testes sem alterar a estrutura existente.

Page Object Model: Usado muito com o java para entender e padronizar melhor a leitura da arquitetura, é indicado enforcement para selenium.


## Comandos

Roda os testes positivos:

```mvn test -Dgroups=funcional```

Roda os testes negativo passando navegador:

```mvn test -Dgroups=negativo```

Rodar todos os testes:

``` mvn test -Dtest=BlogPageTest  ```