package com.example.finanzasbackend.modulos.transaccion;

import com.example.finanzasbackend.modulos.categoria.CategoriaRepositorio;
import com.example.finanzasbackend.modulos.cuenta.CuentaRepositorio;
import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransaccionServicio}.
 */
@Generated
public class TransaccionServicio__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'transaccionServicio'.
   */
  private static BeanInstanceSupplier<TransaccionServicio> getTransaccionServicioInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransaccionServicio>forConstructor(TransaccionRepositorio.class, CuentaRepositorio.class, UsuarioRepositorio.class, CategoriaRepositorio.class)
            .withGenerator((registeredBean, args) -> new TransaccionServicio(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'transaccionServicio'.
   */
  public static BeanDefinition getTransaccionServicioBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransaccionServicio.class);
    beanDefinition.setInstanceSupplier(getTransaccionServicioInstanceSupplier());
    return beanDefinition;
  }
}
