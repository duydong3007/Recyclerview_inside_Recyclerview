package model;

import java.util.List;

public class listdata {
    private int type;
    private List<category> categories;
    private List<user> users;

    public listdata(int type, List<category> categories, List<user> users) {
        this.type = type;
        this.categories = categories;
        this.users = users;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<category> getCategories() {
        return categories;
    }

    public void setCategories(List<category> categories) {
        this.categories = categories;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }
}
