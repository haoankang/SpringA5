package ank.hao.spEL;

public class AA {

    private Integer code;
    private String msg;

    public AA(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AA{" + "code=" + code + ", msg='" + msg + '\'' + '}';
    }
}
