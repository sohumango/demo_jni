## JNI demo

### create jni java class
    mkdir -p ./com/normee
    [ -f ./com/normee/Hello.java ] || touch ./com/normee/Hello.java
        ├── com
        │   └── normee
        │       └── Hello.java
    # coding Hello.java and compile Hello.java
    javac ./com/normee/Hello.java 

### create jni h file
    # auot create com_normee_Hello.h by javah cmd
    javah -jni com.normee.Hello

### create jni c function
    # coding com_normee_Hello.c and compile com_normee_Hello.c
    # mac osx
    gcc -o libHelloImpl.dylib -lc -shared -I$(/usr/libexec/java_home)/include \
        -I$(/usr/libexec/java_home)/include/darwin com_normee_Hello.c
    # linux centos
    gcc -o libHelloImpl.so -lc -shared -I/usr/lib/jvm/java/include \
        -I/usr/lib/jvm/java/include/linux com_normee_Hello.c -fPIC

### create Demo.java to call jar and jni lib
    # coding Demo.java and compile it.
    javac Demo.java
    # create jar and update manifest with main class.
    jar cf demo.jar ./com/normee/*.class ./*.class
    jar uvfm demo.jar mani.mf

### run demo.jar with jni lib
    java -Djava.library.path=$(pwd) -jar demo.jar jack 2
