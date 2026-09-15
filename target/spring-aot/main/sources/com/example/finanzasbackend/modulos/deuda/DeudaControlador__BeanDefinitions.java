package com.example.finanzasbackend.modulos.deuda;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeudaControlador}.
 */
@Generated
public class DeudaControlador__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'deudaControlador'.
   */
  private static BeanInstanceSupplier<DeudaControlador> getDeudaControladorInstanceSupplier() {
    return BeanInstanceSupplier.<DeudaControlador>forConstructor(DeudaServicio.class)
            .withGenerator((registeredBean, args) -> new DeudaControlador(args.get(0)));
  }

  /**
   * Get the bean definition for 'deudaControlador'.
   */
  public static BeanDefinition getDeudaControladorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeudaControlador.class);
    beanDefinition.setInstanceSupplier(getDeudaControladorInstanceSupplier());
    return beanDefinition;
  }
}
