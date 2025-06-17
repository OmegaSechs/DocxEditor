# DocxEditor
Editor de arquivos .docx - Gerador de Lista de Autorizações
📖 Descrição
Este projeto em Java utiliza a biblioteca Apache POI para automatizar o preenchimento de um formulário de autorização de entrada, baseado em um modelo de documento Word (.docx), para uma associação.

O objetivo é eliminar a necessidade de preenchimento manual, lendo os dados de variáveis dentro do código e gerando um novo documento pronto para ser impresso e assinado.

✨ Funcionalidades
Lê um modelo de documento Word (.docx) existente.
Preenche dinamicamente os campos de texto do formulário, como:
Nome do Proprietário 
Quadra e Lote 
Período da autorização 
Nome do representante dos convidados 
Popula uma tabela com uma lista de até 25 convidados, incluindo Nome, RG/CPF e Placa do Veículo. 
Insere automaticamente o ano corrente na data do documento. 
Salva um novo arquivo .docx com todas as informações preenchidas, preservando o modelo original.
🛠️ Tecnologias Utilizadas
Java: Linguagem de programação principal.
Apache POI: Biblioteca para manipulação de arquivos Microsoft Office.
Maven: Ferramenta de gerenciamento de dependências e build do projeto.
⚙️ Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina:

JDK (Java Development Kit) - Versão 11 ou superior;
Apache Maven.
