# FrutasApp
Desafio Muxi

O Aplicativo proposto neste desafio consume um arquivo JSON na web e exibe uma lista de frutas com seu valor em dolar. 
Para desenvolver esta funcionalidade, foi utilizada a biblioteca Retrofit, passando a URL do arquivo fruits.json. 
O Retrofit, por sua vez, utiliza uma interface que retorna a lista dos elementos exibidos no aplicativo. 
Ao clicar em cada elemento da lista, é exibida informações do nome da fruta, a imagem, o valor em dolar e o valor em real. 
A obtenção dessas informações são guardadas em atributos dentro do modelo Fruta.java e assim trafegar as informações. 
Para exibição, a Activity activity_fruta.xml possui SmartImageView como recurso simples para exibição de imagens da internet através da URL de cada elemento. 
O processamento do valor em real foi realizado juntamente com os outros atributos mostrados, ou seja, a multiplicação do valor fixo em real 3.5 pelo valor em dolar do elemento clicado.
