package com.example.finanzasbackend.modulos.deuda;

import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeudaServicio}.
 */
@Generated
public class DeudaServicio__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'deudaServicio'.
   */
  private static BeanInstanceSupplier<DeudaServicio> getDeudaServicioInstanceSupplier() {
    return BeanInstanceSupplier.<DeudaServicio>forConstructor(DeudaRepositorio.class, UsuarioRepositorio.class)
            .withGenerator((registeredBean, args) -> new DeudaServicio(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'deudaServicio'.
   */
  public static BeanDefinition getDeudaServicioBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeudaServicio.class);
    beanDefinition.setInstanceSupplier(getDeudaServicioInstanceSupplier());
    return beanDefinition;
  }
}
