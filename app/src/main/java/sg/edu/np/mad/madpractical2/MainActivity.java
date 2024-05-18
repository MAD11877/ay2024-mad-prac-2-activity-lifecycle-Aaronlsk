package sg.edu.np.mad.madpractical2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        User user = new User("Isaac Tiew", "MAD Developer", 1, false);

        TextView tvName = findViewById(R.id.textView);
        TextView tvDescription = findViewById(R.id.textView2);
        Button btnFollow = findViewById(R.id.button2);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(v -> {
            user.followed = !user.followed;
            updateFollowButton(btnFollow, user.followed);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateFollowButton(Button btnFollow, boolean followed) {
        if (followed) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }
    }
}