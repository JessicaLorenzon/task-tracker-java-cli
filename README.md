# Task Tracker

Projeto feito seguindo o roadmap de projetos do [roadmap.sh](https://roadmap.sh/projects/task-tracker), com o objetivo
de praticar Java.

## Descrição

O Task Tracker é uma aplicação de linha de comando (CLI) para gerenciar tarefas. Ele permite que você adicione, liste,
atualize e remova tarefas, mantendo o controle do status e datas importantes.

## Tecnologias utilizadas

- **Java** - Linguagem principal
- [**Gson**](https://github.com/google/gson) - Biblioteca para serialização e desserialização de objetos JSON
- **CLI (Command Line Interface)** - Interface baseada em terminal
- **Arquivo `.jar`** - Distribuição da aplicação empacotada

## Como rodar o projeto

### 1. Baixe ou clone o repositório

```bash
git clone https://github.com/JessicaLorenzon/task-tracker-java-cli.git
cd task-tracker-java-cli
```

### 2. Navegue até o diretório onde está o `.jar`:

```bash
cd out/artifacts/task_tracker_java_cli_jar
```

### 3. Execute o aplicativo:

```bash
java -jar task-tracker-java-cli.jar
```

## Exemplo de uso:

```bash
# Adicionar uma nova tarefa
$ java -jar task-tracker-java-cli.jar adicionar "Comprar frutas"
# Saida: Tarefa adicionada com sucesso (ID: 1)

# Atualizar e remover tarefas
$ java -jar task-tracker-java-cli.jar atualizar 1 "Comprar frutas e verduras"
$ java -jar task-tracker-java-cli.jar remover 1

# Marcar uma tarefa para em andamento ou concluida
$ java -jar task-tracker-java-cli.jar em-andamento 1
$ java -jar task-tracker-java-cli.jar concluir 1

# Listar todas as tarefas
$ java -jar task-tracker-java-cli.jar listar

# Listar tarefas por status
$ java -jar task-tracker-java-cli.jar listar concluidas
$ java -jar task-tracker-java-cli.jar listar pendentes
$ java -jar task-tracker-java-cli.jar listar em-andamento
```