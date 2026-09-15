package com.example.finanzasbackend.modulos.transaccion;

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
 * AOT generated JPA repository implementation for {@link TransaccionRepositorio}.
 */
@Generated
public class TransaccionRepositorioImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public TransaccionRepositorioImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link TransaccionRepositorio#findByUsuarioIdOrderByFechaMovimientoDesc(java.util.UUID)}.
   */
  public List<TransaccionEntidad> findByUsuarioIdOrderByFechaMovimientoDesc(UUID usuarioId) {
    String queryString = "SELECT t FROM TransaccionEntidad t WHERE t.usuario.id = :usuarioId ORDER BY t.fechaMovimiento desc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("usuarioId", usuarioId);

    return (List<TransaccionEntidad>) query.getResultList();
  }
}
