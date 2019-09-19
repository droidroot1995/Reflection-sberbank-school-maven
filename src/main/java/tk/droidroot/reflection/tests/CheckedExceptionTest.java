package tk.droidroot.reflection.tests;

import tk.droidroot.reflection.exceptions.MyCheckedException;

public class CheckedExceptionTest {
    public CheckedExceptionTest(){
    }

    public void test() throws MyCheckedException {
        throw new MyCheckedException("My checked Exception");
    }
}
