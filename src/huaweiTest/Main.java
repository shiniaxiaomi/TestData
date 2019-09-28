package huaweiTest;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();

        while (scanner.hasNext()) {

            String s = scanner.next();
            for(int i=0;i<s.length();i++){
                hashSet.add(s.charAt(i));
            }

            Iterator<Character> iterator = hashSet.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next());
            }
            hashSet.clear();

        }
    }


}
