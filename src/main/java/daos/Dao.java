package daos;

import java.util.List;

public abstract class Dao <T extends Dto>{
     abstract T findById(int id);
     abstract List findAll();
     abstract T update(T dto);
     abstract T create(T dto);
     abstract void delete(int id);

}
