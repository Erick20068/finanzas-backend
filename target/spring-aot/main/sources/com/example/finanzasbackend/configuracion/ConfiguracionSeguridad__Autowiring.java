package com.example.finanzasbackend.configuracion;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ConfiguracionSeguridad}.
 */
@Generated
public class ConfiguracionSeguridad__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ConfiguracionSeguridad apply(RegisteredBean registeredBean,
      ConfiguracionSeguridad instance) {
    AutowiredFieldValueResolver.forRequiredField("jwtSecret").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
