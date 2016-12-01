/**
 * Created by Acer on 01.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Person stepa = new Person("stepa", 21, false, 171);
        Person nikita = new Person("nikita", 22, true, 174);

        BeanUtils.assign(nikita,stepa);

        System.out.println(nikita.toString());
        System.out.println(stepa.toString());
    }
}
