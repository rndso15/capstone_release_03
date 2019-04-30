package com.example.capstone_release_01;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 파일 리스트 관리 - 리스트 엑티비티.
public class FileList extends ListActivity {

    private File file;  // 사용되는 file
    private ArrayList<String> mylist;   // file 내 list.
    private File selected_file; // 선택되는 file.

    private String state;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 객체 구현.
        mylist = new ArrayList<String>();

        // 1. 어떤 발표문을 가져와서 확인하는지 해당 폴더를 가져오는 역할.
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/capstone","MyDocAPP");

        // 1-1../capstone 폴더가 존재하지 않으면 mkdir을 이용해서 폴더생성.
        if(!file.exists()) {
            if(!file.mkdir()){
                // 디텍토리 생성 x 인 경우 - 로그를 생성.
                Log.d("MyDocApp" , "Failed to create directory");
                return;
            }
        }

        // 파일내 list 를 가져옴.
        File list[] = file.listFiles();

        // list의 이름을 가져옴. + add
        for(int i =0 ; i< list.length ; i++) {
            mylist.add(list[i].getName());
        }

        // Adapter 생성 , list view 로 매칭.
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,
                R.layout.activity_file_list, R.id.listview ,mylist);
        setListAdapter(Adapter);
    }
    /*
    public void Get_list() {
        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_file_list,
                R.id.listview,mylist));

        //############################### list 리턴해주는 부분 마무리.
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        selected_file = new File(file , (String) mylist.get(position));

        if(!selected_file.isFile()) {
            file = new File(file, (String) mylist.get(position));
            File list[] = file .listFiles();

            mylist.clear();

            for(int i = 0 ; i<list.length ; i++)
            {
                mylist.add(list[i].getName());
            }
            Toast.makeText(getApplicationContext(),file.toString() , Toast.LENGTH_LONG).show();

            setListAdapter
                    (new ArrayAdapter
                            (this, R.layout.activity_file_list,mylist)
                    );
        }
    }

    public List getSelected_file(){
        return (List) selected_file;
    }

    public  int getSelected_Count() {

        return 1;
    }

    boolean checkExternalStorage() {
        state = Environment.getExternalStorageState();
        // 외부메모리 상태
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // 읽기 쓰기 모두 가능
            Log.d("test", "외부메모리 읽기 쓰기 모두 가능");
            tv.setText("외부메모리 읽기 쓰기 모두 가능");
            return true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //읽기전용
            Log.d("test", "외부메모리 읽기만 가능");
            tv.setText("외부메모리 읽기만 가능");
            return false;
        } else {
            // 읽기쓰기 모두 안됨
            Log.d("test", "외부메모리 읽기쓰기 모두 안됨 : "+ state);
            tv.setText("외부메모리 읽기쓰기 모두 안됨 : "+ state);
            return false;
        }
    }
    */
}
