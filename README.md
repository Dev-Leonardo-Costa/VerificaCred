<!-- HEADER -->
<div align="center" style="padding: 24px 16px; border-radius: 16px; border: 1px solid #e5e7eb; background: #ffffff;">
  <h1 style="margin: 0; font-size: 32px;">💳 Sistema de Crédito para Liberação de Cartão</h1>
  <p style="margin: 8px 0 0 0; font-size: 15px; color: #6b7280;">
    Projeto desenvolvido no curso <strong>Domine Microserviços e Mensageria com Spring Cloud e Docker</strong> (Udemy) – Instrutor: <em>Douglas Sousa</em>.
  </p>

  <!-- BADGES -->
  <div style="margin-top: 14px; display: inline-flex; flex-wrap: wrap; gap: 8px; align-items: center; justify-content: center;">
    <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <img alt="Spring Cloud" src="https://img.shields.io/badge/Spring%20Cloud-339933?style=for-the-badge&logo=spring&logoColor=white">
    <img alt="RabbitMQ" src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white">
    <img alt="Kafka" src="https://img.shields.io/badge/Apache%20Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white">
    <img alt="Docker" src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
    <img alt="Docker Compose" src="https://img.shields.io/badge/Docker%20Compose-003f8c?style=for-the-badge&logo=docker&logoColor=white">
  </div>
</div>

<br/>

<!-- ABOUT -->
<div style="border: 1px solid #e5e7eb; border-radius: 12px; padding: 16px; background: #fafafa;">
  <h2 style="margin-top: 0;">📘 Sobre</h2>
  <p style="margin: 0;">
    Este repositório apresenta um sistema baseado em <strong>microserviços</strong> para <strong>análise de crédito</strong> e
    <strong>liberação de cartões</strong>, aplicando <strong>Spring Boot</strong>, <strong>Spring Cloud</strong> (Eureka, API Gateway, Config Server),
    <strong>mensageria</strong> (RabbitMQ/Kafka) e <strong>Docker</strong> para containerização e orquestração.
  </p>
</div>

<br/>

<!-- FEATURES -->
<div style="border: 1px solid #e5e7eb; border-radius: 12px; padding: 16px; background: #ffffff;">
  <h2 style="margin-top: 0;">📌 Funcionalidades</h2>
  <ul style="margin: 0;">
    <li>Cadastro de clientes</li>
    <li>Solicitação de cartão de crédito</li>
    <li>Análise de crédito automatizada</li>
    <li>Liberação e controle de cartões</li>
    <li>Comunicação assíncrona entre serviços via mensageria</li>
  </ul>
</div>

<br/>

<!-- ARCHITECTURE -->
<div style="border: 1px solid #e5e7eb; border-radius: 12px; padding: 16px; background: #fafafa;">
  <h2 style="margin-top: 0;">🛠️ Arquitetura</h2>
  <p style="margin-top: 0;">
    A solução é composta por múltiplos microserviços independentes, governados por <strong>API Gateway</strong>, registrados no
    <strong>Eureka</strong> e com configuração centralizada no <strong>Config Server</strong>. A integração entre domínios é feita por
    <strong>eventos</strong> usando <strong>RabbitMQ</strong> ou <strong>Kafka</strong>.
  </p>

  <!-- SIMPLE BOARD-LIKE DIAGRAM USING TABLE (works well in GitHub HTML) -->
  <div style="overflow-x: auto;">
    <table style="width: 100%; border-collapse: collapse; font-size: 14px;">
      <thead>
        <tr>
          <th style="border: 1px solid #e5e7eb; padding: 8px; background: #f3f4f6;">Camada</th>
          <th style="border: 1px solid #e5e7eb; padding: 8px; background: #f3f4f6;">Componentes</th>
          <th style="border: 1px solid #e5e7eb; padding: 8px; background: #f3f4f6;">Observações</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Entrada</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">🌐 API Gateway</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Roteamento e segurança das APIs</td>
        </tr>
        <tr>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Descoberta</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">📡 Eureka (Service Discovery)</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Registro e localização de serviços</td>
        </tr>
        <tr>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Configuração</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">⚙️ Config Server</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Config centralizada por ambiente</td>
        </tr>
        <tr>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Domínios</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">
            📂 Serviço de Clientes → 🗄️ DB Clientes<br/>
            💳 Serviço de Cartões → 🗄️ DB Cartões<br/>
            📊 Serviço de Análise de Crédito → 🗄️ DB Análise
          </td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Cada serviço possui seu banco (princípio do <em>database per service</em>)</td>
        </tr>
        <tr>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Mensageria</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">📬 RabbitMQ / Kafka</td>
          <td style="border: 1px solid #e5e7eb; padding: 8px;">Eventos assíncronos entre serviços</td>
        </tr>
      </tbody>
    </table>
  </div>

  <!-- ASCII Mini Diagram -->
  <details style="margin-top: 10px;">
    <summary><strong>Ver mini diagrama em texto</strong></summary>
    <pre style="background:#0b1021;color:#e5e7eb;padding:12px;border-radius:8px;overflow:auto;line-height:1.4;">
Cliente → API Gateway → (Eureka)
                 │
        ┌────────┼─────────┐
        │        │         │
   Serviço   Serviço   Serviço
  Clientes    Cartões   Análise
    │           │          │
  DB Cli      DB Cart     DB An
        └───────Eventos (RabbitMQ/Kafka)───────┘
    </pre>
  </details>
</div>

<br/>

<!-- RUN -->
<div style="border: 1px solid #e5e7eb; border-radius: 12px; padding: 16px; background: #ffffff;">
  <h2 style="margin-top: 0;">▶️ Como executar</h2>
  <ol style="margin: 0;">
    <li>Clone o repositório
      <pre style="background:#0b1021;color:#e5e7eb;padding:12px;border-radius:8px;overflow:auto;margin-top:6px;">git clone https://github.com/<strong>seu-usuario</strong>/<strong>nome-do-repositorio</strong>.git
cd <strong>nome-do-repositorio</strong></pre>
    </li>
    <li>Suba os containers (Docker Compose)
      <pre style="background:#0b1021;color:#e5e7eb;padding:12px;border-radius:8px;overflow:auto;margin-top:6px;">docker-compose up -d</pre>
    </li>
    <li>Acesse as rotas pelo <strong>API Gateway</strong> (ver portas no compose).</li>
  </ol>
</div>

<br/>

<!-- LEARNINGS -->
<div style="border: 1px solid #e5e7eb; border-radius: 12px; padding: 16px; background: #fafafa;">
  <h2 style="margin-top: 0;">📖 Aprendizados</h2>
  <ul style="margin: 0;">
    <li>Arquitetura de <strong>microserviços escaláveis</strong></li>
    <li>Comunicação assíncrona com <strong>RabbitMQ/Kafka</strong></li>
    <li><strong>Containerização e orquestração</strong> com Docker e Compose</li>
    <li>Governança com <strong>Spring Cloud</strong> (Eureka, Gateway, Config Server)</li>
    <li>Boas práticas: <strong>Clean Code, logs centralizados, testes de integração</strong></li>
  </ul>
</div>

<br/>

<!-- FOOTER -->
<div align="center" style="padding: 8px 0; color: #6b7280; font-size: 12px;">
  Feito com ☕ e Spring. Sinta-se livre para abrir issues e sugestões!
</div>
