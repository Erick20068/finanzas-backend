package com.example.finanzasbackend.modulos.categoria;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CategoriaControlador}.
 */
@Generated
public class CategoriaControlador__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'categoriaControlador'.
   */
  private static BeanInstanceSupplier<CategoriaControlador> getCategoriaControladorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CategoriaControlador>forConstructor(CategoriaServicio.class)
            .withGenerator((registeredBean, args) -> new CategoriaControlador(args.get(0)));
  }

  /**
   * Get the bean definition for 'categoriaControlador'.
   */
  public static BeanDefinition getCategoriaControladorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CategoriaControlador.class);
    beanDefinition.setInstanceSupplier(getCategoriaControladorInstanceSupplier());
    return beanDefinition;
  }
}
