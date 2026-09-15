package com.example.finanzasbackend.modulos.categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link CategoriaRepositorio}.
 */
@Generated
public class CategoriaRepositorioImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public CategoriaRepositorioImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link CategoriaRepositorio#findByUsuarioId(java.util.UUID)}.
   */
  public List<CategoriaEntidad> findByUsuarioId(UUID usuarioId) {
    String queryString = "SELECT c FROM CategoriaEntidad c WHERE c.usuario.id = :usuarioId";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("usuarioId", usuarioId);

    return (List<CategoriaEntidad>) query.getResultList();
  }
}
