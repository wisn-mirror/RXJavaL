package com.wisn.rxjava;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity";

    private ScrollView mMScroll_info;
    private TextView mTextResult;
    private TextView mShareText;
    private TextView mShareTextdelete;
    private Button test1;
    private Button test2;
    private Button test3;
    private Button test4;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private EditText mEdittext;
    private Observable<String> mObservable;
    private Observer mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("hello rxjava");
            }
        });
        mObserver = new Observer<String>(){
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void onClick(View view) {
        Log.e(TAG, "Build.VERSION.SDK_INT：" + Build.VERSION.SDK_INT);
        if (view == test1) {
            Log.e(TAG, "Build.VERSION.SDK_INT：" + Build.VERSION.SDK_INT);
            mObservable.subscribe(mObserver);
        } else if (view == test2) {
        } else if (view == test3) {
        } else if (view == test4) {
        }
    }

    private void initView() {
        mMScroll_info = (ScrollView) findViewById(R.id.scroll_info);
        mTextResult = (TextView) findViewById(R.id.testResult);
        mShareText = (TextView) findViewById(R.id.shareText);
        mShareTextdelete = (TextView) findViewById(R.id.shareTextdelete);
        mEdittext = (EditText) findViewById(R.id.edittext);
        test1 = (Button) findViewById(R.id.test1);
        test2 = (Button) findViewById(R.id.test2);
        test3 = (Button) findViewById(R.id.test3);
        test4 = (Button) findViewById(R.id.test4);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        test1.setOnClickListener(this);
        test2.setOnClickListener(this);
        test3.setOnClickListener(this);
        test4.setOnClickListener(this);
        mShareTextdelete.setOnClickListener(this);
        mShareText.setOnClickListener(this);
    }
}
