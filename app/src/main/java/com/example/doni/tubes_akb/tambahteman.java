package com.example.doni.tubes_akb;
/*nama  : Doni Wiranata
  nim   : 10116024
  Tanggal pengiriman : 12 - 08 - 2019
  kelas : IF-1/AKB-1
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class tambahteman extends AppCompatActivity {
    Realm realm;
    Button tambah;
    EditText nama, nim, notelp, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahteman);


        nama = (EditText) findViewById(R.id.nama);
        nim = (EditText) findViewById(R.id.nim);
        notelp = (EditText) findViewById(R.id.notelp);
        email = (EditText) findViewById(R.id.email);
        Button tambah = (Button) findViewById(R.id.tambah);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();

                User user = realm.createObject(User.class, nama.getText().toString());
                user.setNim(nim.getText().toString());
                user.setNotelp(notelp.getText().toString());
                user.setEmail(email.getText().toString());

                realm.commitTransaction();
            }
        });


    }
}
