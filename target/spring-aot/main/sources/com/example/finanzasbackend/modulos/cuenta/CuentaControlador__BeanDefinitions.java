package com.example.finanzasbackend.modulos.cuenta;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CuentaControlador}.
 */
@Generated
public class CuentaControlador__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'cuentaControlador'.
   */
  private static BeanInstanceSupplier<CuentaControlador> getCuentaControladorInstanceSupplier() {
    return BeanInstanceSupplier.<CuentaControlador>forConstructor(CuentaServicio.class)
            .withGenerator((registeredBean, args) -> new CuentaControlador(args.get(0)));
  }

  /**
   * Get the bean definition for 'cuentaControlador'.
   */
  public static BeanDefinition getCuentaControladorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CuentaControlador.class);
    beanDefinition.setInstanceSupplier(getCuentaControladorInstanceSupplier());
    return beanDefinition;
  }
}
