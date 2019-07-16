package two.example.demo.eneity;

public class Menu {
    private Integer idMenu;
    private String name;
    private String type;
    private Integer num;
    private Float price;
    private String description;

    public Menu(){
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
