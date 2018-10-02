/*
$Tommy Prevatt
 */
package cs230_ip3;

public class Node {

    //String firstName;
    String name;
    String city;
    String country;
    String phone;
    double contrib;
    int id;
    Node next;

    public Node(String name, String city, String country, String phone, double contrib, int id) {

        this.name = name;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.contrib = contrib;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public double getContrib() {
        return contrib;
    }

    public int getID() {
        return id;
    }

    /*
    overridden toString() method. It isn't formatted pretty. It just displays the
    data retrieved from the nodes. 
     */
    @Override
    public String toString() {
        return String.format(name + " " + city + " " + country + " " + phone + " " + contrib + " " + id);
    }

}
