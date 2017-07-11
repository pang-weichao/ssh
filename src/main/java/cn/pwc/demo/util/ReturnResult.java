package cn.pwc.demo.util;

/**
 * @author boom
 * @description 统一返回的对象
 * @create 2017-05-14 16:15
 **/
public class ReturnResult {

    private String result;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
