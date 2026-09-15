package com.example.finanzasbackend.modulos.cuenta;

import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CuentaServicio}.
 */
@Generated
public class CuentaServicio__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'cuentaServicio'.
   */
  private static BeanInstanceSupplier<CuentaServicio> getCuentaServicioInstanceSupplier() {
    return BeanInstanceSupplier.<CuentaServicio>forConstructor(CuentaRepositorio.class, UsuarioRepositorio.class)
            .withGenerator((registeredBean, args) -> new CuentaServicio(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'cuentaServicio'.
   */
  public static BeanDefinition getCuentaServicioBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CuentaServicio.class);
    beanDefinition.setInstanceSupplier(getCuentaServicioInstanceSupplier());
    return beanDefinition;
  }
}
