package siit.model;

public class Customer {

    private String adress;
    private int id;
    private String name;
    private String phone;

    public Customer() {
        super();
    }

    public Customer(int id, String name, String phone, String adress) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", adress=" + adress + "]";
    }


}
