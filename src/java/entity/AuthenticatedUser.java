package entity;

/**
 *
 * @author Lawal
 */
public class AuthenticatedUser {
    
    private final String businessId;
    private final String profileId;
    private final String roleId;

    public AuthenticatedUser(String businessId, String profileId, String roleId) {
        this.businessId = businessId;
        this.profileId = profileId;
        this.roleId = roleId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getRoleId() {
        return roleId;
    } 

    @Override
    public String toString() {
        return "AuthenticatedUser{" + "businessId=" + businessId + ", profileId=" + profileId + ", roleId=" + roleId + '}';
    }
    
}
