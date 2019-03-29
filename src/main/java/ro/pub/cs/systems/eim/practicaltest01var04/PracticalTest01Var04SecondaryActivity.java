package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.verify:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel:
                    setResult(RESULT_CANCELED, null);
                    break;

            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("");
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("sablon")) {
            String sablon = intent.getStringExtra("sablon");
            textView.setText(sablon);
        }

        Button ok = findViewById(R.id.verify);
        Button cancel = findViewById(R.id.cancel);
        ok.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);
    }
}
