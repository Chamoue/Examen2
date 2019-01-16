package ca.csf.pobj.examen2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.examen2.Model.HashListener;
import ca.csf.pobj.examen2.R;
import ca.csf.pobj.examen2.Task.HashingTask;
import ca.csf.pobj.examen2.util.CharactersFilter;

public class MainActivity extends AppCompatActivity implements HashListener {

    private static final char[] SUPPORTED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private EditText inputEditText;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        outputTextView = findViewById(R.id.outputTextView);

        inputEditText.setFilters(new InputFilter[]{new CharactersFilter(SUPPORTED_CHARACTERS)});
    }

    public void onHashButtonClicked(View view) {
        createHash(inputEditText.getText().toString());
    }

    private void createHash(String input) {
        HashingTask hashingTask = new HashingTask();
        hashingTask.addToListeners(this);
        hashingTask.execute(input);
    }

    @Override
    public void onHashingTaskCompleted(String string) {
        outputTextView.setText(string);
    }
}
