package uhh_lt.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;


public class TranslationActivity extends AppCompatActivity {

    private static final String username = "uuuuuuu";
    private static final String password = "ppppppppppppppp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

    }

    protected void translate(View view) {
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            EditText text = (EditText) findViewById(R.id.inputTextTranslation);
            String inputText = text.getText().toString();

            LanguageTranslator service = new LanguageTranslator();
            service.setUsernameAndPassword(username, password);

            TranslationResult translationResult = service.translate(inputText, Language.ENGLISH, Language.SPANISH).execute();

            System.out.println(translationResult);
            TextView output = (TextView) findViewById(R.id.textViewTranslation);
            output.setText(translationResult.getTranslations().get(0).toString());

        }
    }
}

