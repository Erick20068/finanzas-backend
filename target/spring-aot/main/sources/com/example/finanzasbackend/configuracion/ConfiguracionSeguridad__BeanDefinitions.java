package com.example.finanzasbackend.configuracion;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * Bean definitions for {@link ConfiguracionSeguridad}.
 */
@Generated
public class ConfiguracionSeguridad__BeanDefinitions {
  /**
   * Get the bean definition for 'configuracionSeguridad'.
   */
  public static BeanDefinition getConfiguracionSeguridadBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConfiguracionSeguridad.class);
    beanDefinition.setTargetType(ConfiguracionSeguridad.class);
    ConfigurationClassUtils.initializeConfigurationClass(ConfiguracionSeguridad.class);
    InstanceSupplier<ConfiguracionSeguridad> instanceSupplier = InstanceSupplier.using(ConfiguracionSeguridad$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(ConfiguracionSeguridad__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(ConfiguracionSeguridad$$SpringCGLIB$$0.class, "filterChain", HttpSecurity.class, CorsConfigurationSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("configuracionSeguridad", ConfiguracionSeguridad.class).filterChain(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'filterChain'.
   */
  public static BeanDefinition getFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setFactoryBeanName("configuracionSeguridad");
    beanDefinition.setInstanceSupplier(getFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtDecoder'.
   */
  private static BeanInstanceSupplier<JwtDecoder> getJwtDecoderInstanceSupplier() {
    return BeanInstanceSupplier.<JwtDecoder>forFactoryMethod(ConfiguracionSeguridad$$SpringCGLIB$$0.class, "jwtDecoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("configuracionSeguridad", ConfiguracionSeguridad.class).jwtDecoder());
  }

  /**
   * Get the bean definition for 'jwtDecoder'.
   */
  public static BeanDefinition getJwtDecoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtDecoder.class);
    beanDefinition.setFactoryBeanName("configuracionSeguridad");
    beanDefinition.setInstanceSupplier(getJwtDecoderInstanceSupplier());
    return beanDefinition;
  }
}
