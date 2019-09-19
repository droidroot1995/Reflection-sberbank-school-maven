package tk.droidroot.reflection;

import tk.droidroot.reflection.tests.CheckedExceptionTest;
import tk.droidroot.reflection.tests.UncheckedExceptionTest;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /* ------------- Serialization test start ------------- */

        ClonedClass original = new ClonedClass("original");
        System.out.println("Original object name " + original.getName());
        ByteArrayOutputStream baous = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baous);
        ous.writeObject(original);

        ByteArrayInputStream bais = new ByteArrayInputStream(baous.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        ClonedClass cloned = (ClonedClass)ois.readObject();
        System.out.println("Cloned object name " + cloned.getName());

        System.out.println(original == cloned);
        System.out.println(original.equals(cloned));

        /* ------------- Serialization test end ------------- */

        /* ------------- Checked exception test start ------------- */

        CheckedExceptionTest chetest = new CheckedExceptionTest();

        try{
            chetest.test();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Checked exception was catch");
        }

        /* ------------- Checked exception test end ------------- */

        /* ------------- Unchecked exception test start ------------- */

        UncheckedExceptionTest uetest = new UncheckedExceptionTest();
        try{
            uetest.div(1, 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Unchecked exception was catch");
        }

        /* ------------- Unchecked exception test end ------------- */

        /* ------------- Reflection test start ------------- */

        ArrayList<Integer> lst = new ArrayList<Integer>();

        Class type = (((ParameterizedType) lst.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getClass();
        System.out.println(type);

        /* ------------- Reflection test end ------------- */
    }
}
