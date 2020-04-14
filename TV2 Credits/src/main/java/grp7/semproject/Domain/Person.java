package grp7.semproject.Domain;

public class Person {
    String name;
    String role;
    String address;
    String phone;
    String email;
    int id = 0;

    public Person(String name, String role, String address, String phone, String email) {
        this.name = name;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Person(int id, String name, String role, String address, String phone, String email) {
        this.name = name;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    @Override
    public String toString() {
        if (id != 0){
            return  "{id=" + id +
                    ", name=" + name +
                    ", role=" + role +
                    ", address=" + address +
                    ", phone=" + phone +
                    ", email=" + email +
                    '}';
        } else {
            return  "{name=" + name +
                    ", role=" + role +
                    ", address=" + address +
                    ", phone=" + phone +
                    ", email=" + email +
                    '}';
        }


    }
}
