package qetz.components;

import com.google.common.base.Preconditions;

import java.util.Collection;

public final class ComponentScan implements ClassStreamable {
  public static ComponentScan fromScan(ClassScan scan) {
    Preconditions.checkNotNull(scan, "scan");
    return new ComponentScan(scan.stream()
      .findAnnotated(Component.class)
      .allClassCasted()
    );
  }

  private final Collection<Class<?>> components;

  private ComponentScan(
    Collection<Class<?>> components
  ) {
    this.components = components;
  }

  @Override
  public ClassStream<?> stream() {
    return ClassStream.withClasses(components);
  }
}