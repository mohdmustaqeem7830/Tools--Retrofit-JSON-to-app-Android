package mustaqeem.zubair.jsontoretrofit;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  TextView tv ;
  String url = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tv = findViewById(R.id.tv);
            tv.setText("");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            myapi api = retrofit.create(myapi.class);

            Call<List<model>>  call = api.getmodel();
            call.enqueue(new Callback<List<model>>() {
                @Override
                public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                    List<model> data = response.body();

                    for (int i =0 ; i < data.size();i++){
                        tv.append("Sl No. "+data.get(i).getId()+"\n Title : "+data.get(i).getTitle()+"\n\n\n ");
                    }
                }

                @Override
                public void onFailure(Call<List<model>> call, Throwable t) {

                }
            });

            return insets;
        });
    }
}