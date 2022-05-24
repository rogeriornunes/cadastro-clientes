# cadastro-clientes
Api de Gerenciamento de Clientes





Criação da Imagem Docker executando o Dockerfile

Entendendo a  configuração no pom.xml
Dentro da tag configuration, adicionamos a tag useMavenSettingsForAuth, como o nome já diz, estamos ativando a autenticação via settings do maven. Lembre de  substituir username, password email com as suas credenciais.

A configuração em si é muito simples, além de incluir a dependência do dockerfile-maven também adicionamos algumas tags, como a execution que incluindo uma etapa no ciclo de construção do maven para o build e push da imagem. Não necessária para criar uma imagem docker, apenas quando for enviar a imagem para um repositório.
Na tag repository, informei meu docker ID e o nome que queremos para a imagem. Se você possui um um docker ID, informe no lugar de docker_id [username], isso servirá para enviarmos para o docker hub.
Na tag com o nome de tag será a versão/tag da imagem.
E por fim, temos a tag JAR_FILE, que nada mais é do que o nosso pacote .jar.

Executando o Dockerfile e Enviando a imagem para o Docker Hub (registro)

Execular via linha de comando o Dockfile pelo plugin do maven 

mvn package executa e cria a imagem local latest e snapshot
mvn dockerfile:push envia imagem para Docker Hub remoto.