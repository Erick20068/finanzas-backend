package com.example.finanzasbackend.configuracion;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ConfiguracionCors}.
 */
@Generated
public class ConfiguracionCors__BeanDefinitions {
  /**
   * Get the bean definition for 'configuracionCors'.
   */
  public static BeanDefinition getConfiguracionCorsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConfiguracionCors.class);
    beanDefinition.setTargetType(ConfiguracionCors.class);
    ConfigurationClassUtils.initializeConfigurationClass(ConfiguracionCors.class);
    beanDefinition.setInstanceSupplier(ConfiguracionCors$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
