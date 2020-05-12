package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.json.Json;
import javax.json.JsonObject;
/**
 *
 * @author Ajitata & Lawal
 */
public class Profile implements Serializable{
    
    private String id;
    private String firstName;
    private String middleName;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private String roleId;
    private String createdBy;
    private LocalDateTime entryTime;
    private String modifiedBy;
    private LocalDateTime changeTime;
    
    public Profile(String id, String firstname,String middleName, String surname, String phone, String email, String password, String role) {
        this.id = id;
        this.firstName = firstname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.surname=surname;
        this.middleName=middleName;
        this.roleId = role;
    }

    public Profile() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDateTime changeTime) {
        this.changeTime = changeTime;
    }
    
    public JsonObject toJSON(){
        return Json.createObjectBuilder()
                        .add("id", getId())
                        .add("firstname", getFirstName())
                        .add("middlename", getMiddleName())
                        .add("surname", getSurname())
                        .add("phone", getPhone())
                        .add("email", getEmail())
                        .add("roleid", getRoleId())
                        .build();
    }

}
