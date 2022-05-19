- [ ] Adicionar os filtros por perfis nos endpoints da API **@PreAuthorize("hasAnyRole('PERFIL-DO-USUARIO-SEM-O-ROLE')")

- [ ] Apenas o próprio usuário deve poder alterar/acessar suas informações (semelhante ao filtro aplicado no findById dos services)
    - [ ] Lembrar de tratar a exceção no controller (try-catch) utilizando o **AuthorizationException**