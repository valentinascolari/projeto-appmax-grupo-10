# 🚚 Mensagens de Rastreio – Backend

> Backend desenvolvido em Java / Spring Boot para monitorar o status de pedidos e automatizar o rastreio de entregas da Appmax, com foco em redução de chamados de suporte e melhoria da experiência do cliente.

---

![Java Backend](https://img.shields.io/badge/Java%20Backend-black?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-gray?style=for-the-badge)
![API](https://img.shields.io/badge/API-black?style=for-the-badge)
![Banco%20de%20Dados](https://img.shields.io/badge/Banco%20de%20Dados-gray?style=for-the-badge)

---

## 📌 Visão Geral

Este projeto é o **backend** de um sistema de rastreio de entregas para a **Appmax**, permitindo:

- Centralizar informações de pedidos e seus eventos de entrega
- Disponibilizar uma API REST para consulta de status
- Automatizar notificações ao cliente em pontos-chave da jornada do pedido
    - (confirmação de compra + código de rastreio, saída para entrega, entregue)
- Gerar insumos para análise de desempenho da operação
    - (métricas e indicadores)

O foco é **diminuir retrabalho do suporte**, reduzir dúvidas sobre rastreio e **melhorar a jornada do cliente** desde a confirmação da compra até a entrega.

---

## 🎯 Objetivos da Solução

- **Reduzir custo operacional** com atendimento repetitivo sobre status de pedidos.
- **Aumentar a satisfação do cliente final** enviando as informações necessárias sobre a entrega do produto adquirido.
- **Fornecer dados** para mensurar eficiência (tempo médio de entrega, falhas, reentregas, etc.)
- **Apoiar decisões de negócio**, com métricas que podem ser acompanhadas via dashboards ou ferramentas externas de BI

---

## 🏗️ Arquitetura em Alto Nível

A solução foi pensada com uma arquitetura simples, porém escalável:

- **API REST** em Spring Boot
- **Camadas bem definidas**:
    - `controller` – exposição dos endpoints HTTP
    - `service` – regras de negócio e orquestração
    - `repository` – acesso a dados (JPA/ORM)
    - `entity` – entidades de domínio (Pedido, Evento de Rastreamento, etc.)
    - `dto` / `mapper` – transporte e conversão de dados entre camadas
- **Integração externa** com sistemas de rastreio de transportadoras / ERP (via APIs HTTP)
- **Banco de dados relacional** para armazenamento das informações de pedidos e eventos

---

## 🔑 Principais Funcionalidades

- Cadastro e atualização de **pedidos**
- Registro de **eventos de rastreamento**
    - (ex.: “Confirmação do pedido + Código de Rastreio”, “Em trânsito”, “Entregue”)
- Consulta de status consolidado do pedido
- Exposição de endpoints para integração com outros sistemas da Appmax
- Base de dados preparada para **análises futuras**

---

## 🧰 Tecnologias & Ferramentas

- **Java** (JDK 21)
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Bean Validation
  
- **Banco de dados**
    - PostgreSQL 
  
- **Build Tool**
    - Maven
  
- **Outros**
    - Lombok 
    - Docker Compose

---

## 📂 Estrutura de Pastas

```text
src/
 └── main/
     ├── java/
     │   └── org/example/
     │       ├── client/
     │       ├── configurations/
     │       ├── controller/
     │       ├── dto/
     │       ├── entity/
     │       ├── enumerator/
     │       ├── exception/
     │       ├── mapper/
     │       ├── repository/
     │       ├── service/
     │       └── AppmaxApplication.java
     └── resources/
         ├── application.yml
         └── (outros recursos)

```
# 👥 Equipe / Autoria

Desenvolvedores: Valentina Scolari e Gustavo Becker.