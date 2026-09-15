package com.example.finanzasbackend.modulos.transaccion;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransaccionControlador}.
 */
@Generated
public class TransaccionControlador__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'transaccionControlador'.
   */
  private static BeanInstanceSupplier<TransaccionControlador> getTransaccionControladorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransaccionControlador>forConstructor(TransaccionServicio.class)
            .withGenerator((registeredBean, args) -> new TransaccionControlador(args.get(0)));
  }

  /**
   * Get the bean definition for 'transaccionControlador'.
   */
  public static BeanDefinition getTransaccionControladorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransaccionControlador.class);
    beanDefinition.setInstanceSupplier(getTransaccionControladorInstanceSupplier());
    return beanDefinition;
  }
}
