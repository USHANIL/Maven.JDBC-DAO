package daos;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DaoUserTest {
    @Test
    public void testFindById() {

        DaoUser c1 = new DaoUser();
        DtoUser a1 = c1.findById(1);
        DtoUser e1 = new DtoUser(1 , "Usha" , "Kun" , "704 churchill rd" , "Chester Springs" );
        Assert.assertEquals(a1.toString(),e1.toString());
    }

    @Test
    public void testFindAll() {
        DaoUser c1 = new DaoUser();
        List<DtoUser> list = c1.findAll();
        Assert.assertEquals(5,list.size());

    }

    @Test
    public void testUpdate() {
        DaoUser c1 = new DaoUser();
        DtoUser e1 = new DtoUser(1, "Usha", "Kunnnnn", "704 churchill rd", "ChesterSprings");
        DtoUser a1 = c1.update(e1);
        Assert.assertEquals(a1.toString(), e1.toString());
    }

    @Test
    public void testInsert() {
        DaoUser c1 = new DaoUser();
        DtoUser e1 = new DtoUser(0,"Ushaaaaa", "Kun", "7churchill rd", "ChesterSprings");
        DtoUser a1 = c1.create(e1);
        Assert.assertEquals(a1.toString(), e1.toString());
    }
}
