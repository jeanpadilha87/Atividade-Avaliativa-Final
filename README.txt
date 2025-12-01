Professor Jackson.

Estrutura das pastas:
src/ = arquivos .java
lib/ = colocar aqui mysql-connector-java-8.0.18.jar
schema.sql-> script para criar banco e tabelas no workbench.

Como usar:
1) Colocar o connector em lib/
2) Execute schema.sql no MySQL Workbench (cria DB receitas)
3) Compilar: javac -cp "lib\mysql-connector-java-8.0.18.jar;." src\*.java
4) Executar: java -cp "lib\mysql-connector-java-8.0.18.jar;src;." Main

- Main.java testa apenas Usuario por padrão. Para testar outras entidades, descomentar as chamadas em main.
