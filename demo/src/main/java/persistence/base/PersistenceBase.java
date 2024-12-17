package persistence.base;

import java.util.List;

public abstract class PersistenceBase<I> {
  public abstract void save(I item);
  public abstract void delete(String id);
  public abstract I get(String id);
  public abstract List<I> getAll();
  public abstract I update(I item);
}
