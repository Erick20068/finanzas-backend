package com.example.finanzasbackend;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FinanzasBackendApplication}.
 */
@Generated
public class FinanzasBackendApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'finanzasBackendApplication'.
   */
  public static BeanDefinition getFinanzasBackendApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FinanzasBackendApplication.class);
    beanDefinition.setInstanceSupplier(FinanzasBackendApplication::new);
    return beanDefinition;
  }
}
