package daos;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DaoUser extends Dao <DtoUser>  {
    Connection conn1 = ConnectDatabase.getConnection();

    public DtoUser findById(int id){
        try{
            DtoUser user;
            //Statement selQuery = conn1.prepareStatement("Select user_id,first_name,last_name,address,city from Users where user_id=" + id);
            //ResultSet rs = selQuery.getResultSet();

            Statement selQuery = conn1.createStatement();
            ResultSet rs = selQuery.executeQuery("Select user_id,first_name,last_name,address,city from Users where user_id=" + id);
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
                return user;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public List findAll() {
        try{
        DtoUser user;
        List users = new LinkedList();
        Statement selQuery = conn1.createStatement();
        ResultSet rs = selQuery.executeQuery("Select user_id,first_name,last_name,address,city from Users");
        while (rs.next()) {
            user = extractUserFromResultSet(rs);
            users.add(user);
        }
            return users;
    }
        catch(SQLException ex){
            ex.printStackTrace();
    }

        return null;
    }

    public DtoUser update(DtoUser dtouser) {
        try{

            /*PreparedStatement selQuery = conn1.prepareStatement("update first_name=?,last_name=?,address=?,city=? from Users where user_id=?");
            selQuery.setString(1,dtouser.getFirstName());
            selQuery.setString(2,dtouser.getLastName());
            selQuery.setString(3,dtouser.getAddress());
            selQuery.setString(4,dtouser.getCity()); */
            PreparedStatement selQuery = prepStatement(dtouser);
            selQuery.setInt(5,dtouser.getId());
            int i = selQuery.executeUpdate();
            if (i == 1) {
                return dtouser;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public DtoUser create(DtoUser dtouser) {
        try{

           /* PreparedStatement selQuery = conn1.prepareStatement("Insert into Users values (first_name=?,last_name=?,address=?,city=?)");
            selQuery.setString(1,dtouser.getFirstName());
            selQuery.setString(2,dtouser.getLastName());
            selQuery.setString(3,dtouser.getAddress());
            selQuery.setString(4,dtouser.getCity()); */
           PreparedStatement selQuery = prepStatement(dtouser);
            int i = selQuery.executeUpdate();
            if (i == 1) {
                return dtouser;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public PreparedStatement prepStatement(DtoUser dtouser){
        try {
            PreparedStatement selQuery;
            if (dtouser.getId() == 0){
                 selQuery = conn1.prepareStatement("Insert into Users values (null,first_name=?,last_name=?,address=?,city=?)");
            }
            else {
                selQuery = conn1.prepareStatement("update Users set first_name=?,last_name=?,address=?,city=? where user_id=?");
            }
            selQuery.setString(1,dtouser.getFirstName());
            selQuery.setString(2,dtouser.getLastName());
            selQuery.setString(3,dtouser.getAddress());
            selQuery.setString(4,dtouser.getCity());
            return selQuery;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try{

            Statement stmt = conn1.createStatement();
            stmt.executeUpdate("DELETE FROM Users WHERE user_id=" + id);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public DtoUser extractUserFromResultSet(ResultSet resultSet) {
        try {
            DtoUser foundUser = new DtoUser();
            foundUser.setId(resultSet.getInt("user_id"));
            foundUser.setFirstName(resultSet.getString("first_name"));
            foundUser.setLastName(resultSet.getString("last_name"));
            foundUser.setAddress(resultSet.getString("address"));
            foundUser.setCity(resultSet.getString("city"));
            return foundUser;
        }
        catch(SQLException ex){
        }
        return null;
    }
}
