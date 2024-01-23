package anoop.test.sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNestedElements {

    public static boolean isPartOf(String customerId, List<String> customerIds, List<Customer> customers){
        System.out.println("--------------------");
        System.out.println("Processing for >> " + customerId);
        Set<String> accessibleIds = flatternSet(customers);
        System.out.println("Updated Id sets >> ");
        for (String id : accessibleIds) {
            System.out.println("    "+id);
        }
        return accessibleIds.contains(customerId);
    }

    private static Set<String> flatternSet(List<Customer> customers) {
        Set<String> flatSet = new HashSet<>();
        for (Customer customer : customers) {
            flatSet.add(customer.getId());
            flatSet.addAll(flatternSet(customer.getChildren()));
        }
        return flatSet;
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(getCustomer("group_1", 3, 3));
        customers.add(getCustomer("group_2", 3, 2));
        /*customers.add(getCustomer("group_3", 2, 3));
        customers.add(getCustomer("group_4", 4, 4));*/
        print(customers, "");

        System.out.println(isPartOf("group_3_1",
                List.of("group_1_1_1", "group_3_1", "group_3_1_1"),
                customers)); // True

        /*
        System.out.println(isPartOf("group_3",
                List.of("group_1_1_1", "group_3_1", "group_3_1_1"),
                customers)); // True


        System.out.println(isPartOf("group_3_0",
                List.of("group_1_1_1", "group_3_1", "group_3_1_1"),
                customers)); // False

        System.out.println(isPartOf("group_4_0",
                List.of("group_1_1_1", "group_3_1", "group_4_3_3"),
                customers)); // True
         */
    }

    private static Customer getCustomer(String idPref, int childCount, int numbers){
        Customer customer = new Customer(idPref, "", idPref + "_name");
        for (int count = 0; count < numbers; count++) {
            String cIdPref = idPref + "_" +count;
            Customer cCustomer = new Customer(cIdPref, idPref, cIdPref +"_name");
            for (int cCount = 0; cCount < childCount; cCount++) {
                String ccIdPref = cIdPref + "_" +count;
                cCustomer.getChildren().add(new Customer(ccIdPref, cIdPref, ccIdPref +"_name"));
            }
            customer.getChildren().add(cCustomer);
        }
        return customer;
    }

    private static void print(List<Customer> customers, String prefix){
        for (Customer customer : customers) {
            System.out.println(prefix + "" + customer.getId());
            print(customer.getChildren(), prefix + "    ");
        }
    }
}

class Customer{
    private String id;
    private String parentId;
    private String name;
    private List<Customer> children = new ArrayList<>();

    public Customer(String id, String parentId, String name) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public List<Customer> getChildren() {
        return children;
    }

    public void setChildren(List<Customer> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
