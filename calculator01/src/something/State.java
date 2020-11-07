package something;
/**
 * 计算器的状态
 * a op b =
 * 以下为状态码
 * 0 表示 非法状态
 * 1 表示 a未输入 op未输入 b未输入 =未输入
 * 2 表示 a已输入 op未输入 b未输入 =未输入
 * 3 表示 a已输入 op已输入 b未输入 =未输入
 * 4 表示 a已输入 op已输入 b已输入 =未输入
 * 5 表示 a已输入 op未输入 b未输入 =已输入
 * 6 表示 a已输入 op已输入 b已输入 =未输入
 */

public class State {

    private double a = 0;
    private boolean a_flag = false;
    private double b = 0;
    private boolean b_flag = false;
    private char op = ' ';
    private boolean op_flag = false;
    private double res = 0;
    private boolean res_flag = false;

    private String show = " ";


    public State(boolean a, boolean b, boolean op) {
        a_flag = a;
        b_flag = b;
        op_flag = op;
    }


    /**
     * 输出结果
     */
    public String toString(){
        FormatOutput();
        return show;
    }


    /**
     * 返回状态的编码
     * 以下为状态码
     * 0 表示 非法状态
     * 1 表示 a未输入 op未输入 b未输入 =未输入
     * 2 表示 a已输入 op未输入 b未输入 =未输入
     * 3 表示 a已输入 op已输入 b未输入 =未输入
     * 4 表示 a已输入 op已输入 b已输入 =未输入
     * 5 表示 a已输入 op未输入 b未输入 =已输入
     * 6 表示 a已输入 op已输入 b已输入 =未输入
     *
     * @return 编码值
     */
    public int StateID() {
        if (!a_flag && !b_flag && !op_flag && !res_flag) return 1;
        if (a_flag && !b_flag && !op_flag && !res_flag) return 2;
        if (a_flag && !b_flag && op_flag && !res_flag) return 3;
        if (a_flag && b_flag && op_flag && !res_flag) return 4;
        if (a_flag && !b_flag && !op_flag && res_flag) return 5;
        if (a_flag && b_flag && op_flag && res_flag) return 6;
        else return 0;
    }


    /**
     * 状态转移
     * 按下 加减乘除或者等号 时状态的改变
     * @param value 代表输入是 加减乘除或者等号 中的哪一个
     */
    public void setState(char value) {
        if (this.StateID() == 2) {
            if (value == '+' || value == '-' || value == '*' || value == '/') {
                op = value;
                op_flag = true;
            }
            if (value == '=') {
                res = a;
                res_flag = true;
            }
        }
        else if (this.StateID() == 4) {
            if (value == '+' || value == '-' || value == '*' || value == '/') {
                caluate_in();
                a = res;
                res = 0;
                op = value;
                b_flag = false;
            }
            if (value == '=') {
                caluate_in();
                res_flag = true;
            }
        }
        else if (this.StateID() == 5) {
            if (value == '+' || value == '-' || value == '*' || value == '/'){
                res_flag = false;
                op = value;
                op_flag = true;
            }
        }
        else if (this.StateID() == 6) {
            caluate_in();
            a = res;
            op = value;
            b_flag = false;
            res_flag = false;
        }
    }


    /**
     * 状态转移
     * 按下 数字键 后状态的改变
     * @param value 改变的值是多少
     */
    public void setState(int value) {
        if (this.StateID() == 1 || this.StateID() == 2) {
            if (a_flag) a = a*10+value;
            else {a = value; a_flag = true;}
        }
        else if (this.StateID() == 3 || this.StateID() == 4) {
            if (b_flag) b = b*10+value;
            else {b = value; b_flag = true;}
        }
        else if (this.StateID() == 5 || this.StateID() == 6) {
            this.initState();
            a = value;
            a_flag = true;
        }
    }


    /**
     * 初始化状态
     */
    public void initState() {
        this.a = 0;
        this.a_flag = false;
        this.op = ' ';
        this.op_flag = false;
        this.b = 0;
        this.b_flag = false;
        this.res = 0;
        this.res_flag = false;
    }



    /**
     * 在可计算时计算最后的结果
     */
    private void caluate_in(){
        if (a_flag && op_flag && b_flag) {
            switch (op){
                case '+': res = a+b; break;
                case '-': res = a-b; break;
                case '*': res = a*b; break;
                case '/': if (b == 0) b = 1;
                            res = a/b; break;
            }
        }
    }


    /**
     * 格式化输出信息
     * @return 计算式信息
     */
    private String FormatOutput() {
        switch (this.StateID()){
            case 1: show = "\n\n0"; break;
            case 2: show = a + "\n\n" + a; break;
            case 3: show = a + " " + op + "\n\n"; break;
            case 4: show = a + " " + op + "\n\n" + b; break;
            case 5: show = a + "\n\n" + res; break;
            case 6: show = a + " " + op + " " + b + "\n\n" + res; break;
        }
        return show;
    }
}

