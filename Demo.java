/*
javac Demo.java 
jar cf demo.jar ./com/normee/*.class ./*.class
jar uvfm demo.jar mani.mf

java -Djava.library.path=$(pwd) -jar demo.jar Student 5
*/
import com.normee.*;
public class Demo {
    public static void main (String[] args) { 
    Hello hello = new Hello(); 
    hello.sayHi(args[0], Integer.parseInt(args[1]));
    }
}