package com.example.finanzasbackend.compartido.excepciones;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ManejadorGlobalExcepciones}.
 */
@Generated
public class ManejadorGlobalExcepciones__BeanDefinitions {
  /**
   * Get the bean definition for 'manejadorGlobalExcepciones'.
   */
  public static BeanDefinition getManejadorGlobalExcepcionesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ManejadorGlobalExcepciones.class);
    beanDefinition.setInstanceSupplier(ManejadorGlobalExcepciones::new);
    return beanDefinition;
  }
}
