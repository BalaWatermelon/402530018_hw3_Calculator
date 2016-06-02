package developer.jackson.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button one, two, three, four, five, six, seven, eight, nine, zero, ac, c, equal;
    Caluculator myCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get display reference from view
        text = (TextView) this.findViewById(R.id.display);

        // Create Calculator object
        myCal = new Caluculator(text);
    }

    public void buttonOnclick(View v){
        Button b = (Button) v;
        myCal.numberPress((String)b.getText());
    };

    public void operationOnClick(View v){
        Button b = (Button) v;
        myCal.oper((String)b.getText());
    }

    public void acClicked(View v){
        myCal.all_clear();
    };

    public void cClicked(View v){
        myCal.clear();
    };

    public void equalClicked(View v){
        myCal.equal();
    };
}
