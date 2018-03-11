package tunglt.exercise2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeTitleActivity extends AppCompatActivity {

    public String background;

    @BindView(R.id.editText) EditText editText;
    @BindView(R.id.viewSample) View viewSample;

    @OnClick(R.id.iv1)
    public void onClick1(){
        viewSample.setBackgroundColor(Color.parseColor("#D81B60"));
    }

    @OnClick(R.id.iv2)
    public void onClick2(){
        viewSample.setBackgroundColor(Color.parseColor("#8E24AA"));
    }

    @OnClick(R.id.iv3)
    public void onClick3(){
        viewSample.setBackgroundColor(Color.parseColor("#3949AB"));
    }

    @OnClick(R.id.iv4)
    public void onClick4(){
        viewSample.setBackgroundColor(Color.parseColor("#1E88E5"));
    }

    @OnClick(R.id.iv5)
    public void onClick5(){
        viewSample.setBackgroundColor(Color.parseColor("#00897B"));
    }

    @OnClick(R.id.iv6)
    public void onClick6(){
        viewSample.setBackgroundColor(Color.parseColor("#43A047"));
    }

    @OnClick(R.id.save)
    public void onClickBtn(){
        Intent changeTitleIntent = new Intent(ChangeTitleActivity.this, MainActivity.class);
        changeTitleIntent.putExtra("textColor",((ColorDrawable) viewSample.getBackground()).getColor());
        changeTitleIntent.putExtra("text", editText.getText().toString());
        changeTitleIntent.putExtra("imageName", background);
        startActivity(changeTitleIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_title);

        ButterKnife.bind(ChangeTitleActivity.this);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        int textColor = intent.getIntExtra("textColor", 0);
        editText.setText(text);
        viewSample.setBackgroundColor(textColor);
        background = intent.getStringExtra("imageName");
    }
}
