package tunglt.exercise2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public String backgroundDafault = "hn4";

    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.backgroundImage)
    ImageView backgroundImage;

    @OnClick(R.id.changeTitle)
    public void onButtonClick(){
        Intent mainIntent = new Intent(MainActivity.this, ChangeTitleActivity.class);
        mainIntent.putExtra("textColor", textView.getTextColors().getDefaultColor());
        mainIntent.putExtra("text", textView.getText().toString());
        mainIntent.putExtra("imageName", backgroundDafault);
        startActivity(mainIntent);
    }

    @OnClick(R.id.changeBackground)
    public void onClickBackground(){
        Intent backgroundIntent = new Intent(MainActivity.this, ChangeBackgroundActivity.class);
        backgroundIntent.putExtra("imageName", backgroundDafault);
        backgroundIntent.putExtra("textColor", textView.getTextColors().getDefaultColor());
        backgroundIntent.putExtra("text", textView.getText().toString());
        startActivity(backgroundIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        Intent intent = getIntent();
        if(intent != null){
            String text = intent.getStringExtra("text");
            if(text != null){
                textView.setText(text);
            }

            int color = intent.getIntExtra("textColor", 0);
            if(color != 0){
                textView.setTextColor(color);
            }

            String background = intent.getStringExtra("imageName");
            if(background != null){
                switch (background){
                    case "hn4": backgroundImage.setImageResource(R.drawable.hn4);
                        break;
                    case "hn2": backgroundImage.setImageResource(R.drawable.hn2);
                        break;
                    case "hn3": backgroundImage.setImageResource(R.drawable.hn3);
                        break;
                    case "hn5": backgroundImage.setImageResource(R.drawable.hn5);
                        break;
                    case "hn6": backgroundImage.setImageResource(R.drawable.hn6);
                        break;
                    case "hn7": backgroundImage.setImageResource(R.drawable.hn7);
                        break;
                }
                backgroundDafault = background;
            }
        }
    }
}
