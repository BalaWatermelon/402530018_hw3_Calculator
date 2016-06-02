package developer.jackson.calculator;

import android.widget.TextView;

/**
 * Created by Jackson on 2016/6/1.
 */
public class Caluculator {

    String current;
    String store;
    boolean new_num;
    boolean combo;
    String op;
    TextView display;

    public Caluculator(TextView display) {
        current = "0";
        store = "";
        new_num = true;
        combo = false;
        op = "";
        this.display = display;
    }

    public void numberPress(String num){
        String origin = "";
        if(combo){
            origin = (String)display.getText();
        }else if(op!=""){
            combo = true;
            display.setText("");
        }else{
            origin = (String)display.getText();
        }

        String temp = num;

        if(new_num){
            current = temp;
            new_num = false;
        }else{
            if(temp == "."){
                if(origin.indexOf(".")<0){
                    current = origin + temp;
                }
            }
        }
        display.setText(current);
    }

    public void oper(String op){
        if(combo){
            this.execute();
            this.op = op;
            // Design operation display box
            combo = false;
        }
        store = (String)display.getText();
        this.op = op;
        // Display op on operation box
        new_num = true;
    }

    public void execute(){
        String historyFormula = store + op + current; // Store pre-calculate formula to display in history box
        Float result = new Float(0);
        try{
            System.out.println(op);
            // Start calculation
            if ( op.equals("+") ){
                System.out.println("Stored Value: "+Float.valueOf(store));
                System.out.println("Current Value: "+Float.valueOf(current));
                result = Float.valueOf(store) + Float.valueOf(current);
            }else if(op.equals("-")){
                result = Float.valueOf(store) - Float.valueOf(current);
            }else if(op.equals("*")){
                result = Float.valueOf(store) * Float.valueOf(current);
            }else if(op.equals("/")){
                if(Float.valueOf(current) == 0){
                    if(Float.valueOf(store) == 0){
                        current = "Infinity";
                        op = "";
                        display.setText(current);
                    }else{
                        current = "NaN";
                        op = "";
                        display.setText(current);
                    }

                }else {
                    result = Float.valueOf(store) - Float.valueOf(current);
                }
            }
            // End of calculation
            op = "";
            display.setText(String.valueOf(result));
        }catch (Error e){
            current = "NaN";
            op = "";
            display.setText(current);
        }
        // Clear operation box here
    }

    public void equal(){
        if(op != ""){
            this.execute();
            new_num = true;
            combo = false;
        }
    }

    public void clear(){
        display.setText("0");
        current = "0";
        new_num = true;
    }

    public void all_clear(){
        display.setText("0");
        op = "";
        store = "";
        current = "";
        new_num = true;
        combo = false;
    }
}
