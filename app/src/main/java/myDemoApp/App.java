package myDemoApp;
import java.util.ArrayList;


public class App {

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        System.out.println(isSameElement(array1,array2,0));
       
    }


    public static boolean isSameElement(ArrayList<Integer> list1 , ArrayList<Integer> list2 , Integer k){

        if ( list1 == null || list1.size() == 0 )
            return false ;

        if ( list2 == null || list2.size() == 0 )
            return false ;
        
        if ( list1.get(k) != null && list2.get(k) != null && list1.get(k) == list2.get(k) )
            return true;
        
        return false ;
    }


    
}
