# Showcase hexagonal architecture with domain driven design

## Methodology: Iterative, Pattern-Aware, Grounded

_We build systems through small, incremental steps, guided by proven architectural patterns and grounded in real use cases._

- **Iterative**: Evolve the system step by step, validating assumptions continuously.
- **Pattern-Aware**: Apply established patterns such as DDD, Hexagonal Architecture, and EIP where they add value.
- **Grounded**: Focus on real business problems and working software over theoretical design.

## Tech Stack

| Concern | Dev | Production-ready |
|---|---|---|
| Framework | Spring Boot | Spring Boot |
| Persistence | H2 (in-memory) | PostgreSQL |
| CDC | Simulated via domain events | Debezium + Kafka (requires PostgreSQL WAL) |
| Messaging | Spring ApplicationEventPublisher | Apache Kafka |

### Resilient API first software development

### Rich domain models with emphasis on tactical and strategic DDD

### Java and spring boot as frameworks

### H2 as persistence

### Using enterprise integration patterns

###  Debezium + Kafka CDC setup 

## Use Case
Salesforce-like CRM solution, starting with the `Sales` bounded context:
- Customer aggregate
- Opportunity entity
- Domain events driving downstream reactions

---
Code structure: application, domain, infrastructure