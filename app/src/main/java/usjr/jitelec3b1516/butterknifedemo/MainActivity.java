package usjr.jitelec3b1516.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.etItem)
    EditText mEtItem;

    @Bind(R.id.listItem)
    ListView mListItem;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>());
        mListItem.setAdapter(mAdapter);
    }

    @OnClick(R.id.btnAddItem)
    public void addItem() {
        String item = mEtItem.getText().toString();

        if (!TextUtils.isEmpty(item)) {
            mAdapter.add(item);
            mAdapter.notifyDataSetChanged();
            mEtItem.setText("");
        } else {
            Toast.makeText(this, R.string.empty_item_to_input, Toast.LENGTH_SHORT).show();
        }
    }

    @OnItemClick(R.id.listItem)
    public void selectItemInList(int position) {
        String item = mAdapter.getItem(position);
        Toast.makeText(this, "Item Selected: " + item, Toast.LENGTH_SHORT).show();
    }
}
