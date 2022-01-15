# DesafioPubFuture

## Terceira etapa do processo seletivo da PubFuture: criar uma solução que auxilie no controle das finanças pessoais.



## Sobre: 
Criei um projeto estruturado que utiliza padrão de arquitetura MVC e uma interface gráfica interativa por meio do Java Swing que auxilia na gestão financeira pessoal utilizando linguagem de programação Java e o banco de dados MySql. No programa é possível inserir e excluir receitas, despesas, cadastrar contas e vê o saldo total. 

## Requisitos para rodar a solução:
MySql Workbench
Java 17

## Como rodar a solução:
1. Faça download do arquivo 

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

![Inicialização](https://user-images.githubusercontent.com/95294368/149587246-01a38b8b-7b3f-469b-aad2-e5fac06db6f4.jpg)

- Tela inicial:

![Tela Inicial](https://user-images.githubusercontent.com/95294368/149587263-9628cd0a-f759-4c9f-b9db-a950ea4814aa.jpg)

- Categoria:

![Tela Categoria](https://user-images.githubusercontent.com/95294368/149587258-00c41d5a-3b9e-4df4-8fbf-d4579bae3929.jpg)

- Inserir categoria:

![Tela Cadastro de Categoria](https://user-images.githubusercontent.com/95294368/149587253-d4e2dd13-83e8-462a-8038-ca35a5e73afb.jpg)

- Alterar categoria:

![Tela Alteração de Categoria](https://user-images.githubusercontent.com/95294368/149587248-0127c301-36dc-43b6-9c01-bf614eca7982.jpg)

- Excluir categoria:

![Tela Exclusão de Categoria](https://user-images.githubusercontent.com/95294368/149587262-307adfa2-930c-4e42-a9d7-3c323cb119d3.jpg)

- Movimentação:

![Tela Movimentação](https://user-images.githubusercontent.com/95294368/149587240-d26553e6-8c46-4236-a4e5-86796f361cd3.jpg)

- Inserir receita:

![Tela Cadastro de Conta - Receita](https://user-images.githubusercontent.com/95294368/149587256-5ab90a95-6bce-43b5-9707-294c37846e4e.jpg)

- Inserir despesa:

![Tela Cadastro de Conta - Despesa](https://user-images.githubusercontent.com/95294368/149587254-e621866c-8a34-42bc-be66-24f53c362921.jpg)

- Alterar despesa:

![Tela Alteração](https://user-images.githubusercontent.com/95294368/149587250-75813b33-b323-4f34-b7b7-554723155389.jpg)

- Excluir despesa:

![Tela de Excluir](https://user-images.githubusercontent.com/95294368/149587260-c597d58e-4ba7-496f-848a-1670dc9b73f2.jpg)

- Botão Sair:

![Botão de Sair](https://user-images.githubusercontent.com/95294368/149587242-c458eb8d-91d6-4f27-9901-4c561252c601.jpg)


## Requisitos implementados: 

### Receitas
- [x] Cadastrar receitas ✔️
  - valor ✔️
  - dataRecebimento ✔️
  - dataRecebimentoEsperado ❌
  - descrição ✔️
  - conta ✔️
  - tipoReceita (salário, presente, prêmio, outros) ❌
- Editar receitas ✔️
- Remover receitas ✔️
- Listar receitas ✔️
- Filtro por período (dataInicial – dataFinal) ✔️
- Filtro por tipo de receita ✔️
- Listar total de receitas ✔️
### Despesas
- Cadastrar despesas ✔️
  - valor ✔️
  - dataPagamento ✔️
  - dataPagamentoEsperado ❌
  - tipoDespesa ❌
  - conta ✔️
- Editar despesas ✔️
- Remover despesas ✔️
- Listar despesas ✔️
- Filtro por período (dataInicial – dataFinal) ✔️
- Filtro por tipo de despesa ✔️
- Listar total de despesas ✔️
### Contas
- Cadastrar conta ✔️
  - saldo ✔️
  - tipoConta (carteira, conta corrente, poupança) ❌
  - instituicaoFinanceira ❌
- Editar conta ✔️
- Remover conta ✔️
- Listar contas ❌
- Transferir saldo entre contas ❌
- Listar saldo total ✔️

ℹ️ tipoConta e instiuicaoFinanceira não são opções na interface mas podem ser inseridas no campo "Descrição".
