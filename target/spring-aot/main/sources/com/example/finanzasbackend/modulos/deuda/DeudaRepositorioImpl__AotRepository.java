package com.example.finanzasbackend.modulos.deuda;

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
 * AOT generated JPA repository implementation for {@link DeudaRepositorio}.
 */
@Generated
public class DeudaRepositorioImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public DeudaRepositorioImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link DeudaRepositorio#findByUsuarioIdOrderByFechaVencimientoAsc(java.util.UUID)}.
   */
  public List<DeudaEntidad> findByUsuarioIdOrderByFechaVencimientoAsc(UUID usuarioId) {
    String queryString = "SELECT d FROM DeudaEntidad d WHERE d.usuario.id = :usuarioId ORDER BY d.fechaVencimiento asc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("usuarioId", usuarioId);

    return (List<DeudaEntidad>) query.getResultList();
  }
}
