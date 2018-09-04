package jp.co.training;

public abstract class Entity {

    protected String createUser;
    protected String createdDate;
    protected String updateUser;
    protected String updatedDate;

    public String getCreateUser() {
        return createUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

}
