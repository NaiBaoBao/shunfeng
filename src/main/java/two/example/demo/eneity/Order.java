package two.example.demo.eneity;

public class Order {
    private Integer noOrder;
    private Integer idOrder;
    private Integer idMenu;
    private String name;
    private Integer quantity;
    private String idCostomer;
    private String condition;
    private Float total;
    private String nameCostomer;
    private String addressCostomer;

    public Integer getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(Integer noOrder) {
        this.noOrder = noOrder;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIdCostomer() {
        return idCostomer;
    }

    public void setIdCostomer(String idCostomer) {
        this.idCostomer = idCostomer;
    }

    public String getNameCostomer() {
        return nameCostomer;
    }

    public void setNameCostomer(String nameCostomer) {
        this.nameCostomer = nameCostomer;
    }

    public String getAddressCostomer() {
        return addressCostomer;
    }

    public void setAddressCostomer(String addressCostomer) {
        this.addressCostomer = addressCostomer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Order(){

    }
}
