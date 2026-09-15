package com.example.finanzasbackend.modulos.categoria;

import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CategoriaServicio}.
 */
@Generated
public class CategoriaServicio__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'categoriaServicio'.
   */
  private static BeanInstanceSupplier<CategoriaServicio> getCategoriaServicioInstanceSupplier() {
    return BeanInstanceSupplier.<CategoriaServicio>forConstructor(CategoriaRepositorio.class, UsuarioRepositorio.class)
            .withGenerator((registeredBean, args) -> new CategoriaServicio(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'categoriaServicio'.
   */
  public static BeanDefinition getCategoriaServicioBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CategoriaServicio.class);
    beanDefinition.setInstanceSupplier(getCategoriaServicioInstanceSupplier());
    return beanDefinition;
  }
}
