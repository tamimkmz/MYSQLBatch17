public class E5 {
    public static void main(String[] args) {
        var data= DbUtils.fetch("select * from employee");
        System.out.println(data.get(0));
        System.out.println(data.get(0).get("salary"));

    }
}
