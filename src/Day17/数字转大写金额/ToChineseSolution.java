package Day17.数字转大写金额;

public class ToChineseSolution {
    public static void main(String[] args) {
        ToChineseSolution solution = new ToChineseSolution();
        System.out.println(solution.toChinese("1600"));
    }
    String[] digit={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    String[] unit={"元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万","拾","佰","仟"};
    String[] doubleUnit={"角","分","厘"};
    public String toChinese (String str) {

        if (str.isEmpty()||!str.matches("(-)?[\\d]*(.)?[\\d]*")){
            return "抱歉，输入数字不符合要求！";
        }

        String integerStr;//整数部分
        String decimalStr;//小数部分
        if (str.indexOf(".")>0){
            integerStr=str.substring(0,str.indexOf("."));
            decimalStr=str.substring(str.indexOf(".")+1);
        }else{
            integerStr=str;
            decimalStr="";
        }
        if (integerStr.length()>16){
            return "超出计算能力！";
        }

        int[] intArray = toIntArray(integerStr);//整数部分
        if (intArray.length>1&&intArray[0]==0){
            return "抱歉，输入数字不符合要求！";
        }
        boolean isWan = isWan(integerStr);//设置万单位

        int[] decimalArray = toIntArray(decimalStr);//小数部分

        //返回最终的大写
        String res = getChineseInteger(intArray,isWan)+getChineseDecimal(decimalArray);

        return res;

    }

    private String getChineseDecimal(int[] decimalArray) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < decimalArray.length; i++) {
            if (i==3){
                break;
            }
            stringBuffer.append(decimalArray[i]==0?"":(digit[decimalArray[i]]+doubleUnit[i]));
        }
        return stringBuffer.toString();
    }

    private String getChineseInteger(int[] intArray, boolean isWan) {
        StringBuffer stringBuffer = new StringBuffer("");
        int length = intArray.length;
        if (length==1&&intArray[0]==0){
            return "";
        }
        for (int i = 0; i < length; i++) {
            String key ="";
            if (intArray[i]==0){
                if ((length-i)==13){
                    key=unit[4];
                }else if ((length-i)==9){
                    key=unit[8];
                }else if ((length-i)==5&&isWan){
                    key=unit[4];
                }else if ((length-i)==1){
                    key=unit[0];
                }
                if ((length-i)>1&&intArray[i+1]!=0){
                    key+=digit[0];
                }
            }
            stringBuffer.append(intArray[i]==0?key:(digit[intArray[i]]+unit[length-i-1]));
        }
        return stringBuffer.toString();
    }

    public static boolean isWan(String integerStr){
        int length = integerStr.length();
        if (length>4){
            String subInteger = "";
            if (length>8){
                subInteger=integerStr.substring(length-8,length-4);
            }else {
                subInteger=integerStr.substring(0,length-4);
            }
            return Integer.parseInt(subInteger)>0;
        }else {
            return false;
        }
    }

    public static int[] toIntArray(String number){
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i]=Integer.parseInt(number.substring(i,i+1));
        }
        return array;
    }
}
