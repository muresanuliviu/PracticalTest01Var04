package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private int nr_clicks=0;

    private class ButtonClickListener implements Button.OnClickListener {


        @Override
        public void onClick(View view) {
            TextView textView = findViewById(R.id.textView);
            String txt = textView.getText().toString();
            EditText editText = findViewById(R.id.editText);
            switch (view.getId()) {
                case R.id.top_left:
                    textView.setText(textView.getText().toString() + "top left,");
                    nr_clicks++;
                    editText.setText(String.valueOf(nr_clicks));
                    break;
                case R.id.top_right:
                    textView.setText(textView.getText().toString() + "top right,");
                    nr_clicks++;
                    editText.setText(String.valueOf(nr_clicks));

                    break;
                case R.id.center:
                    textView.setText(textView.getText().toString() + "top center,");
                    nr_clicks++;
                    editText.setText(String.valueOf(nr_clicks));
                    break;

                case R.id.bottom_left:
                    textView.setText(textView.getText().toString() + "bottom left,");
                    nr_clicks++;
                    editText.setText(String.valueOf(nr_clicks));

                    break;
                case R.id.bottom_right:
                    textView.setText(textView.getText().toString() + "bottom right,");
                    nr_clicks++;
                    editText.setText(String.valueOf(nr_clicks));
                    break;
                case R.id.nr_clicks:
                    Context context = getApplicationContext();
                    CharSequence text = String.valueOf(nr_clicks);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    break;
                case R.id.secondary:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    String sablon = ((TextView)findViewById(R.id.textView)).getText().toString();
                    intent.putExtra("sablon", sablon);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_01_var04_main);

        TextView textView = findViewById(R.id.textView);
        Button top_left = findViewById(R.id.top_left);
        Button top_right = findViewById(R.id.top_right);
        Button center = findViewById(R.id.center);
        Button bottom_left = findViewById(R.id.bottom_left);
        Button bottom_right = findViewById(R.id.bottom_right);
        Button clicks = findViewById(R.id.nr_clicks);
        Button navigate = findViewById(R.id.secondary);
        textView.setText("");

        top_left.setOnClickListener(buttonClickListener);
        top_right.setOnClickListener(buttonClickListener);
        center.setOnClickListener(buttonClickListener);
        bottom_left.setOnClickListener(buttonClickListener);
        bottom_right.setOnClickListener(buttonClickListener);
        clicks.setOnClickListener(buttonClickListener);
        navigate.setOnClickListener(buttonClickListener);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.EDITEXT, ((EditText)findViewById(R.id.editText)).getText().toString());
        savedInstanceState.putString(Constants.TEXTVIEW, ((TextView)findViewById(R.id.textView)).getText().toString());
        savedInstanceState.putInt(Constants.CLICKS, nr_clicks);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.EDITEXT)) {
            EditText editText = (EditText)findViewById(R.id.editText);
            editText.setText(savedInstanceState.getString(Constants.EDITEXT));
        }
        if (savedInstanceState.containsKey(Constants.TEXTVIEW)) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(savedInstanceState.getString(Constants.TEXTVIEW));
        }
        if (savedInstanceState.containsKey(Constants.CLICKS)) {
            nr_clicks = savedInstanceState.getInt(Constants.CLICKS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }
}
