# Audit with Spring Data JPA and Spring Security

## key point
* @EntityListeners(AuditingEntityListener.class) on entity
* @EnableJpaAuditing
* implement AuditorAware interface
* implement UserDetailsService 
* right config for SecurityFilterChain