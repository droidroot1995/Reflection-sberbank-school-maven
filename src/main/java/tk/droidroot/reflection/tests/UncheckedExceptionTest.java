package tk.droidroot.reflection.tests;

import tk.droidroot.reflection.exceptions.MyUncheckedException;

public class UncheckedExceptionTest {
    public UncheckedExceptionTest(){
    }

    public int div(int a, int b){
        if(b == 0)
            throw new MyUncheckedException(String.format("%s/%s: Division by zero", a, b));
        else
            return a/b;
    }
}
