package something;

public class ProgrammerBuf {

    int buf;
    boolean buf_flag;

    public ProgrammerBuf(){
        buf = 0;
        buf_flag = false;
    }

    public void setBuf(int input) {
        if (buf_flag) { buf = buf*10 + input; }
        else {buf = input; buf_flag = true;}
    }


    // 输出十进制
    public String toString(){
        return " "+buf;
    }

    // 输出二进制
    public String toStringBin(){
        if (buf_flag) {
            return ""+Integer.toBinaryString(buf);
        }
        else return null;
    }


    // 输出16进制
    public String toStringHex(){
        if (buf_flag){
            return ""+Integer.toHexString(buf);
        }
        else return null;
    }

    public void init(){
        buf = 0;
        buf_flag = false;
    }
}
