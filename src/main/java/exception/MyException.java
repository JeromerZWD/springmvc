package exception;

/**
 * @author yyh
 * @date 2019/8/6-14:43
 */
public class MyException extends Exception {
    public String msg;

    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
