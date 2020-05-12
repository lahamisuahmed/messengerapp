package dao;


import entity.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import util.DBUtil;
import util.JB;

/**
 *
 * @author laham
 */
public class ProfileDAO {
    
    public Optional<Profile> findProfile(String username) {

        String fetchQuery = "SELECT p.id,p.firstname,p.surname,p.middlename,p.email,p.phone,p.password,p.role FROM profile AS p WHERE p.email=? OR p.phone=?";

        try (Connection connection = DBUtil.getInstanceOfDBUtil().getConnection();
                PreparedStatement fetchProfilePS = connection.prepareStatement(fetchQuery,
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
            fetchProfilePS.setString(1, username);
            fetchProfilePS.setString(2, username);
            try (ResultSet result = fetchProfilePS.executeQuery()) {
                if (result.isBeforeFirst()) {
                    if (result.first()) {
                        Profile p = new Profile(result.getString("id"), result.getString("firstname"), result.getString("middlename"), result.getString("surname"), result.getString("phone"), result.getString("email"), result.getString("password"), result.getString("role"));
                        return Optional.of(p);
                    }
                }
                return Optional.empty();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(JB.buildISResponse()).type(MediaType.APPLICATION_JSON).build());
        }
    }

}
