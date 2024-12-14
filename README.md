# Desafio Técnico - Sistema de Recrutamento Interno

## Objetivo do Desafio
O objetivo deste desafio é construir uma aplicação web que otimize o processo de recrutamento interno de uma empresa. A ferramenta deve permitir que os colaboradores possam facilmente buscar e se candidatar a vagas internas, utilizando filtros para refinar as opções de acordo com os requisitos das vagas.

## Funcionalidades

### Autenticação e Autorização
- Sistema de autenticação com tokens JWT, garantindo um processo seguro de login e autorização para os usuários.

### Cadastro de Vagas
- **Administradores** podem cadastrar novas vagas, incluindo informações como título, descrição e requisitos necessários para a posição.
- O administrador tem permissão para atualizar e excluir vagas já cadastradas.

### Candidatura a Vagas
- **Colaboradores** podem se candidatar às vagas disponíveis.

### Painel do Candidato (Bônus)
- Um painel dedicado ao candidato foi implementado para que ele possa acompanhar o status de suas candidaturas.
- O painel também permite que os candidatos recebam feedbacks sobre suas candidaturas.

### Avaliação de Candidatos (Bônus)
- Sistema de avaliação de candidatos pelos responsáveis pela vaga.
- Filtros de requisitos ou tempo de empresa podem ser aplicados para uma avaliação mais detalhada e precisa.

### RESPONSIVIDADE
   - A aplicação também funciona bem para dipositivos moveis e tablets

## Requisitos do Back-End
- **Java**: Para rodar a API, é necessário ter o Java 8 instalado na sua máquina.
- **URL da API**: A API está disponível em produção na seguinte URL: [https://desafio-pacto-vaga-back-production.up.railway.app](https://desafio-pacto-vaga-back-production.up.railway.app). Se preferir rodar localmente, altere os parâmetros  `apiUrl` no front-end para `http://localhost:8080`.


## 🚀 Como Rodar a Aplicação

Para rodar a aplicação localmente, siga os passos abaixo:

1. **Clone o repositório** ou **baixe o arquivo ZIP** diretamente do repositório:
   - Para clonar via Git:
     ```bash
     git clone https://github.com/jonathnawill/desafio-pacto-vaga-front.git
     ```
   - Ou baixe o arquivo ZIP diretamente no repositório e extraia os arquivos.

2. **Instale o Node.js** na versão 16.x ou superior, caso ainda não tenha instalado em sua máquina. Você pode verificar a versão instalada executando o comando:
   ```bash
   node -v
3. ** Instale as dependências do projeto. Navegue até a pasta desafio-pacto-front e execute: npm install: OBS: O comando --force é necessário devido a conflitos de versões das dependências.
4. Inicie a aplicação executando o comando: **ng serve**
5. Acesse a aplicação no navegador, indo para o endereço: **http://localhost:4200**

**Banco de Dados**: O banco de dados já está rodando em produção, então não é necessário configurar localmente para testes. A conexão está configurada diretamente na API.

Se, por algum motivo, você precisar rodar o banco de dados localmente em vez de usar a versão em produção, Entre e contato comigo que fornecerei os scripts SQL

## **🔑 Credenciais de Login**

**Usuário Comum:**
Login: jonathan
Senha: 123456

**Administrador:**
Login: admin
Senha: 123456

## Fotos do Sistema

Aqui estão algumas imagens do funcionamento do sistema:

### Tela de login
![Tale de login](https://github.com/user-attachments/assets/4c1e498f-8128-4195-b174-9f95129fd3d7)

### Tela de cadastro
![Tale de registro](https://github.com/user-attachments/assets/24203df0-0616-48ca-805e-489b055fe700)


### Dashbord inicial listagem de vagas
![Dashbord inicial usuario padrão](https://github.com/user-attachments/assets/68f48115-5b68-4783-ac33-1162b4c73c62)

### Candidatura à Vaga
![Tale de registro](https://github.com/user-attachments/assets/5054dd88-6a31-4eb6-afc4-f20abfecf34c)

### Minhas Vagas (Painel do Candidato)
![Meu painel de Candidaturas](https://github.com/user-attachments/assets/e76e2c68-9c4d-4454-93e3-48dfc9e28108)


### Avaliação de candidatos
![Tela de gestão de vagas](https://github.com/user-attachments/assets/7f961fd0-2c71-4eec-a5a8-5b067d650300)

### Mobile
![App](https://github.com/user-attachments/assets/d195ce88-f302-4183-b8a1-202ea9f7b692)

---


 
