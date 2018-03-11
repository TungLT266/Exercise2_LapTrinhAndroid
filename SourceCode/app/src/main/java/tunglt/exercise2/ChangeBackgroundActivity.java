package tunglt.exercise2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeBackgroundActivity extends AppCompatActivity {

    public String background;
    public String text;
    public int textColor;

    @BindView(R.id.backgroundImage)
    ImageView backgroundImage;

    @OnClick(R.id.iv1)
    public void iv1(){
        backgroundImage.setImageResource(R.drawable.hn4);
        background = "hn4";
    }

    @OnClick(R.id.iv2)
    public void iv2(){
        backgroundImage.setImageResource(R.drawable.hn2);
        background = "hn2";
    }

    @OnClick(R.id.iv3)
    public void iv3(){
        backgroundImage.setImageResource(R.drawable.hn3);
        background = "hn3";
    }

    @OnClick(R.id.iv4)
    public void iv4(){
        backgroundImage.setImageResource(R.drawable.hn5);
        background = "hn5";
    }

    @OnClick(R.id.iv5)
    public void iv5(){
        backgroundImage.setImageResource(R.drawable.hn6);
        background = "hn6";
    }

    @OnClick(R.id.iv6)
    public void iv6(){
        backgroundImage.setImageResource(R.drawable.hn7);
        background = "hn7";
    }

    @OnClick(R.id.save)
    public void changeBackground(){
        Intent backgroundIntent = new Intent(ChangeBackgroundActivity.this, MainActivity.class);
        backgroundIntent.putExtra("imageName", background);
        backgroundIntent.putExtra("textColor", textColor);
        backgroundIntent.putExtra("text", text);
        startActivity(backgroundIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        ButterKnife.bind(ChangeBackgroundActivity.this);

        Intent intent = getIntent();
        background = intent.getStringExtra("imageName");
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
        text = intent.getStringExtra("text");
        textColor = intent.getIntExtra("textColor", 0);
    }
}
