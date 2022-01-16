# Desafio PubFuture

## Terceira etapa do processo seletivo da PubFuture: criar uma solução que auxilie no controle das finanças pessoais.

## Sumário
1. [Sobre](#Sobre)
2. [Pré-requisitos para rodar a solução:](#pré-requisitos-para-rodar-a-solução)
3. [Como rodar a solução](#como-rodar-a-solução)
   - [Banco de dados](#banco-de-dados)
   - [Aplicação](#aplicação)
4. [Documentação](#documentação)
5. [Ferramentas utilizadas](#documentação)
6. [Programa](#programa)
7. [Requisitos implementados](#requisitos-implementados)

## Sobre: 
Criei um projeto estruturado com padrões de arquitetura MVC e uma interface gráfica interativa, por meio do Java Swing, que auxilia na gestão financeira pessoal utilizando linguagem de programação Java e o banco de dados MySql. No programa é possível inserir e excluir receitas e despesas, cadastrar contas e vê o saldo total. 

## Pré-requisitos para rodar a solução:
<table>
 <tr> 
  <td>Java</td>
  <td>MySql Workbench</td>
 </tr>
</table>

## Como rodar a solução:
   ### Banco de dados:
   1. Faça download do arquivo ZIP do projeto
   2. Abra o zip e procure o arquivo `bd_controle-financeiro.sql`
   3. Abra o MySQL Workbench
   4. Tools > Data Import > Import from Self-Contained File
   5. Vá na pasta em que você salvou o arquivo `bd_controle-financeiro.sql` e o escolha
   6. Start Import
   7. Logue no MySQL Workbench com seu localhost e a sua senha
   8. Verifique se o banco de dados "controle" foi importado com sucesso.

   ### Aplicação:
   1. Abra o arquivo ZIP do projeto baixado anteriormente 
   2. Extraia o arquivo `Sistema de Controle Financeiro Pessoal.jar`
   3. Abra na sua máquina
   4. Verifique se está rodando com sucesso.

## Documentação: 
A documentação está presente no código-fonte.

## Ferramentas utilizadas:
<table>
 <tr> 
  <td>Apache NetBeans IDE</td>
  <td>Java</td>
  <td>MySql Workbench</td>
  <td>HeidiSQL</td>
 </tr>
<tr>
  <td>12.6</td>
  <td>17.0.1</td>
  <td>8.0.27</td>
  <td>11.3.0.6295</td>
 </tr>
</table>

## Programa:

- Inicialização:

![Iniciazalização](https://user-images.githubusercontent.com/95294368/149638195-3ff3a13b-020f-4a90-845d-538213656325.gif)

- Tela inicial:

![Tela Inicial](https://user-images.githubusercontent.com/95294368/149587263-9628cd0a-f759-4c9f-b9db-a950ea4814aa.jpg)

- Categoria:

![Tela Categoria](https://user-images.githubusercontent.com/95294368/149587258-00c41d5a-3b9e-4df4-8fbf-d4579bae3929.jpg)

- Inserir, alterar e excluir categoria:

![Categoria](https://user-images.githubusercontent.com/95294368/149638304-c07ead95-9fd9-4ec9-81b8-825b76d718b7.gif)

- Movimentação:

![Tela Movimentação](https://user-images.githubusercontent.com/95294368/149587240-d26553e6-8c46-4236-a4e5-86796f361cd3.jpg)

- Inserir receita e despesa:

![Movimentação - Inserir receita e despesa](https://user-images.githubusercontent.com/95294368/149638479-764f43fa-5e63-4d87-b4b2-2d385eedd520.gif)

- Alterar e excluir despesa:

![Movimentacao - Alterar e excluir](https://user-images.githubusercontent.com/95294368/149641089-f7d789a3-0c41-4de8-9d59-f50815913d20.gif)


## Requisitos implementados: 

### Receitas
- [x] Cadastrar receitas 
  - [x] valor 
  - [x] dataRecebimento 
  - [ ] dataRecebimentoEsperado 
  - [x] descrição 
  - [x] conta 
  - [ ] tipoReceita (salário, presente, prêmio, outros) 
- [x] Editar receitas 
- [x] Remover receitas 
- [x] Listar receitas 
- [ ] Filtro por período (dataInicial – dataFinal) 
- [x] Filtro por tipo de receita 
- [x] Listar total de receitas 
### Despesas
- [x] Cadastrar despesas 
  - [x] valor 
  - [x] dataPagamento 
  - [ ] dataPagamentoEsperado 
  - [ ] tipoDespesa 
  - [x] conta 
- [x] Editar despesas 
- [x] Remover despesas 
- [x] Listar despesas 
- [ ] Filtro por período (dataInicial – dataFinal) 
- [ ] Filtro por tipo de despesa 
- [x] Listar total de despesas 
### Contas
- [x] Cadastrar conta 
  - [x] saldo 
  - [ ] tipoConta (carteira, conta corrente, poupança) 
  - [ ] instituicaoFinanceira 
- [x] Editar conta 
- [x] Remover conta 
- [ ] Listar contas 
- [ ] Transferir saldo entre contas 
- [x] Listar saldo total 

ℹ️ tipoConta e instiuicaoFinanceira não são opções na interface mas podem ser inseridas no campo "Descrição".
