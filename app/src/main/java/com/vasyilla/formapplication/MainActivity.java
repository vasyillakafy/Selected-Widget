package com.vasyilla.formapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn ;

    //deklarasikan variabel LIST VIEW(UKM)
    ListView ListViewUKM;
    String[] ukm;

    //deklarasikan variabel pada SPINNER (uang saku)
    TextInputLayout formUangSaku;
    AutoCompleteTextView formIsiUangSaku;
    ArrayList<String> arrayList_uangsaku;
    ArrayAdapter<String> arrayAdapter_uangsaku;

    //deklarasikan variabel pada AUTOCOMPLETE (kota/kabupaten)
    AutoCompleteTextView formIsiKota;
    private static final String[] Kota = new String[]{
            "Aceh", "Ambon",
            "Bandung", "Bangka", "Banjarmasin", "Banyuwangi", "Batam", "Bengkulu", "Bekasi", "Bogor", "Bojonegoro", "Bukittinggi",
            "Cilacap", "Cilegon", "Cirebon",
            "Demak", "Denpasar", "Depok",
            "Garut", "Gresik", "Grobongan", "Gunungkidul", "Gorontalo", "Gowa",
            "Halmahera",
            "Indramayu",
            "Jakarta", "Jambi", "Jayapura", "Jember", "Jepara", "Jombang",
            "Karanganyar", "Karawang", "Karo", "Kebumen", "Kediri", "Kupang",
            "Lamongan", "Lampung", "Lumajang", "Lombok",
            "Madiun", "Makassar", "Malang", "Magelang", "Magetan", "Majalengka", "Manado", "Medan", "Mojokerto",
            "Nias", "Nganjuk", "Ngawi",
            "Padang", "Palembang", "Pangkal Pinang", "Pekalongan", "Pekanbaru", "Purwakarta", "Purbalingga", "Probolinggo",
            "Samosir", "Sampang", "Semarang", "Serang", "Sidoarjo", "Situbondo", "Subang", "Sukabumi", "Surabaya",
            "Rembang",
            "Tangerang", "Tanjung Pinang", "Tasikmalaya", "Tebing Tinggi", "Trenggalek", "Tuban", "Tulungagung",
            "Wonogiri", "Wonosobo",
            "Yogyakarta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        //membuat aksi pada button ketika di klik.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //membuat toast pada button
                Toast.makeText(MainActivity.this, "Pergi ke Halaman Selanjutnya.", Toast.LENGTH_LONG).show();
            }
        });

        //exposed dropdown (SPINNER)
        formUangSaku = (TextInputLayout)findViewById(R.id.formUangSaku);
        formIsiUangSaku = (AutoCompleteTextView)findViewById(R.id.formIsiUangSaku);

        arrayList_uangsaku= new ArrayList<>();
        arrayList_uangsaku.add("Rp2.000");
        arrayList_uangsaku.add("Rp3.000 - Rp5.000");
        arrayList_uangsaku.add("Rp6.000 - Rp10.000");
        arrayList_uangsaku.add("Rp11.000 - Rp15.000");
        arrayList_uangsaku.add("Rp16.000 - Rp20.000");
        arrayList_uangsaku.add(">Rp20.000");

        arrayAdapter_uangsaku = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_uangsaku);
        formIsiUangSaku.setAdapter(arrayAdapter_uangsaku);
        formIsiUangSaku.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String uangsaku = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"Uang Saku Anda: "+uangsaku, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        //untuk menentukan banyaknya karakter yg ditampilkan
        formIsiUangSaku.setThreshold(1);

        //AUTOCOMPLETE TEXT VIEW (kota/kabupaten)
        formIsiKota = findViewById(R.id.formIsiKota);
        AutoCompleteTextView formIsiKota = findViewById(R.id.formIsiKota);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Kota);
        formIsiKota.setAdapter(adapter);

        //LISTVIEW
        ListViewUKM = (ListView)findViewById(R.id.ListViewUKM);
        ukm = new String[]{ "Basket", "BEM", "Dance Modern", "Futsal", "Himpunan Mahasiswa",
                "Marching Band", "Paskibra", "Pencinta Alam", "Taekwondo", "Tari Tradisional",
                "Remaja Masjid", "Renang", "Voli"};
        ArrayAdapter<String> adapterukm = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ukm);
        ListViewUKM.setAdapter(adapterukm);
        ListViewUKM.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String ukm = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(), "UKM "+ukm, Toast.LENGTH_SHORT).show();
            }
        });
    }

}