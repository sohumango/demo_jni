/*
ref: https://www.protechtraining.com/blog/post/java-native-interface-jni-example-65
javac ./com/normee/Hello.java 
javah -jni com.normee.Hello
nm libHelloImpl.dylib 


java Hello Student 5 
java -cp . -Djava.library.path=$(pwd) Hello Student 5
java -Djava.library.path=$(pwd) Hello Student 5

jar -cf Hello.jar Hello.class
*/
package com.normee;

import java.util.StringTokenizer;

public class Hello { 
    public native void sayHi(String who, int times);
      static { 
        try {
          System.loadLibrary("HelloImpl");
        } catch (UnsatisfiedLinkError e){
          String property = System.getProperty("java.library.path");
          StringTokenizer parser = new StringTokenizer(property, ";");
          while (parser.hasMoreTokens()) {
              System.err.println(parser.nextToken());
          }
        }
         
      }
      // public static void main (String[] args) { 
      //   Hello hello = new Hello(); 
      //   hello.sayHi(args[0], Integer.parseInt(args[1]));
      // }
  }