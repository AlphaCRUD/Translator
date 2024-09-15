package com.alphacrud.phototranslator;

import static com.alphacrud.phototranslator.MyApplication.options;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alphacrud.phototranslator.Adapter.LanguageAdapterText;
import com.alphacrud.phototranslator.Model.LanguageModel;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextTranslator extends AppCompatActivity {


    private static final int SECOND_ACTIVITY_REQUEST_CODE = 3;
    private static final int SECOND_ACTIVITY_REQUEST_CODE2 = 4;
    public static int position = 17;
    public static boolean isCurrentClick = false;
    String txt;
    EditText editCurrent;
    EditText editTarget;
    ArrayList<LanguageModel> list;
    TextView currentTextView;
    TextView currentTextViewT;
    TextView targetLanguage;
    TextView targetLanguageTwo;
    String t2;
    RelativeLayout target;
    String detectLanCode = "en";
    String t;
    Button BtnTranslate;
    private ImageButton btnshare;
    private Dialog dialogLan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_translator);

        addLanguages();

        Configuration configuration = getResources().getConfiguration();
        int screenHeightDp = configuration.screenHeightDp; //T// he current width of the available screen space, in dp units, corresponding to screen width resource qualifier.\
        AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_small);
//        if (screenHeightDp < 680) {
//            AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_small);
//        } else {
//            AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_medium);
//        }

        findViewById(R.id.tvOpenPT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TextTranslator.this, Home.class));
                finish();
            }
        });


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextTranslator.super.onBackPressed();
            }
        });


        target = findViewById(R.id.target);
        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialgLanguage();
            }
        });


        currentTextView = (TextView) findViewById(R.id.currentLanguage);
        currentTextViewT = (TextView) findViewById(R.id.currentLanguageT);
        targetLanguageTwo = (TextView) findViewById(R.id.targetLanguageT);
        targetLanguage = (TextView) findViewById(R.id.targetLanguage);
        editCurrent = (EditText) findViewById(R.id.editText);
        editTarget = (EditText) findViewById(R.id.editTarget);


        btnshare = findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder data = new StringBuilder(editCurrent.getText().toString());
                data.append("\n \n");
                data.append(editTarget.getText().toString());


                if (!TextUtils.isEmpty(data)) {
                    Intent intent = new Intent(TextTranslator.this, ShareActivity.class);
                    intent.putExtra("txt", data.toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(TextTranslator.this, "Please type your text first!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BtnTranslate = findViewById(R.id.btnTranslate);
        BtnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editCurrent.getText().toString();
                if (!TextUtils.isEmpty(data)) {
                    if (isOnline()) {
                        targetLanguage.setText(list.get(position).getText());
                        targetLanguageTwo.setText(list.get(position).getText());
                        Log.d("TAGRES", "onClick: " + list.get(position).getText() + " " + list.get(position).getText());
                        AvailOffer(list.get(position).getText(), list.get(position).getShortCode());
                    } else {
                        Toast.makeText(TextTranslator.this, "Please Connect Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TextTranslator.this, "Please type your text first!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCurrentClick = true;
                dialogLan = new Dialog(TextTranslator.this);
                dialogLan.setContentView(R.layout.dialog_select_language);
                dialogLan.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                RecyclerView recyclerView = dialogLan.findViewById(R.id.recyclerView);
                EditText etSearch = dialogLan.findViewById(R.id.etSearch);
                ImageView ivClear = dialogLan.findViewById(R.id.ivClear);
                LanguageAdapterText languageAdapter = new LanguageAdapterText(list, TextTranslator.this);
                recyclerView.setAdapter(languageAdapter);

                ivClear.setOnClickListener(v -> {
                    ivClear.setVisibility(View.GONE);
                });

                etSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

                        if (languageAdapter != null) {
                            languageAdapter.getFilter().filter(s);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                dialogLan.show();
            }
        });

    }


    private void DialgLanguage() {
        dialogLan = new Dialog(TextTranslator.this);
        dialogLan.setContentView(R.layout.dialog_select_language);
        dialogLan.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        RecyclerView recyclerView = dialogLan.findViewById(R.id.recyclerView);
        EditText etSearch = dialogLan.findViewById(R.id.etSearch);
        ImageView ivClear = dialogLan.findViewById(R.id.ivClear);
        LanguageAdapterText languageAdapter = new LanguageAdapterText(list, this);
        recyclerView.setAdapter(languageAdapter);

        ivClear.setOnClickListener(v -> {
            ivClear.setVisibility(View.GONE);
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

                if (languageAdapter != null) {
                    languageAdapter.getFilter().filter(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dialogLan.show();
    }


    private void addLanguages() {


        list = new ArrayList<>();
        list.add(new LanguageModel("English", "en"));
        list.add(new LanguageModel("Persian", "fr"));
        list.add(new LanguageModel("Turkish", "tr"));
        list.add(new LanguageModel("Urdu", "ur"));
//        list.add(new LanguageModel("Chinese", "zh"));
        list.add(new LanguageModel("Russian", "ru"));
        list.add(new LanguageModel("Afrikaans", "af"));
        list.add(new LanguageModel("Arabic", "ar"));
        list.add(new LanguageModel("Belarusian", "be"));
        list.add(new LanguageModel("Bulgarian", "bg"));
        list.add(new LanguageModel("Bengali", "bn"));
        list.add(new LanguageModel("Catalan", "ca"));
        list.add(new LanguageModel("Czech", "cs"));
        list.add(new LanguageModel("Welsh", "cy"));
        list.add(new LanguageModel("Danish", "da"));
        list.add(new LanguageModel("German", "de"));
        list.add(new LanguageModel("Greek", "el"));
        list.add(new LanguageModel("Esperanto", "eo"));
        list.add(new LanguageModel("Spanish", "es"));
        list.add(new LanguageModel("Estonian", "et"));
        list.add(new LanguageModel("Finnish", "fi"));
        list.add(new LanguageModel("French", "fr"));
        list.add(new LanguageModel("Irish", "ga"));
        list.add(new LanguageModel("Galician", "gl"));
        list.add(new LanguageModel("Gujarati", "gu"));
        list.add(new LanguageModel("Hebrew", "he"));
        list.add(new LanguageModel("Hindi", "hi"));
        list.add(new LanguageModel("Croatian", "hr"));
        list.add(new LanguageModel("Haitian", "ht"));
        list.add(new LanguageModel("Hungarian", "hu"));
        list.add(new LanguageModel("Indonesian", "id"));
        list.add(new LanguageModel("Icelandic", "is"));
        list.add(new LanguageModel("Italian", "it"));
        list.add(new LanguageModel("Japanese", "ja"));
        list.add(new LanguageModel("Georgian", "ka"));
        list.add(new LanguageModel("Kannada", "kn"));
        list.add(new LanguageModel("Korean", "ko"));
        list.add(new LanguageModel("Macedonian", "mk"));
        list.add(new LanguageModel("Marathi", "mr"));
        list.add(new LanguageModel("Malay", "ms"));
        list.add(new LanguageModel("Albanian", "sq"));
//        list.add(new LanguageModel("Norwegian", "no"));
//        list.add(new LanguageModel("Polish", "pl"));
//        list.add(new LanguageModel("Portuguese", "pt"));
        list.add(new LanguageModel("Romanian", "ro"));
//        list.add(new LanguageModel("Slovak", "sk"));
        list.add(new LanguageModel("Tamil", "ta"));
        list.add(new LanguageModel("Telugu", "te"));
        list.add(new LanguageModel("Thai", "th"));
        list.add(new LanguageModel("Ukrainian", "uk"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (options != null) {
            Translator translator = Translation.getClient(options);
            getLifecycle().addObserver(translator);

        }
    }

    public boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        } else {
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                // Set text view with string

                if (returnString != null && returnString.contains("ok")) {
                    txt = getIntent().getStringExtra("txt");

                }


            }
        } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE2) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                // Set text view with string

                if (returnString != null && returnString.contains("ok")) {
                    txt = getIntent().getStringExtra("txt");

                }


            }
        }

    }

    public void AvailOffer(String text, String s) {

        Log.d("currrent", "AvailOffer: " + isCurrentClick);

        if (isCurrentClick) {
            isCurrentClick = false;
            currentTextView.setText(text);
            currentTextViewT.setText(text);
            detectLanCode = s;

            if (dialogLan != null && dialogLan.isShowing()) {
                dialogLan.dismiss();
            }

        } else {

            targetLanguage.setText(text);
            targetLanguageTwo.setText(text);

            Log.d("TAGRES", "AvailOffer: " + text);
            String url = "https://translate-plus.p.rapidapi.com/translate";
            ProgressDialog progress = new ProgressDialog(TextTranslator.this);
            progress.setMessage("Translating...");
            progress.show();

            if (dialogLan != null && dialogLan.isShowing()) {
                dialogLan.dismiss();
            }

            JSONObject notifications = new JSONObject();

            try {
                notifications.put("text", editCurrent.getText().toString().trim());
                notifications.put("source", detectLanCode);
                notifications.put("target", s);

            } catch (Exception e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, notifications,
                    new com.android.volley.Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONObject jsonObject = null;

                          AdsManager.showInterstitialAd(TextTranslator.this, () -> {

                              try {
                                  progress.dismiss();
                                  target.setClickable(true);
                                  detectLanCode = s;
                                  JSONObject obj = response.getJSONObject("translations");
                                  String text1 = obj.getString("translation");
                                  editTarget.setText(text1);
                                  Log.d("TAGRES", "onResponse: " + text1);


                              } catch (JSONException e) {
                                  e.printStackTrace();
                              }


                          });


                        }
                    },
                    new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            target.setClickable(true);
                            progress.dismiss();

                            if (error != null) {
                                Log.d("Error", error.toString());
                            }
                            try {
                                Log.d("Error", error.getLocalizedMessage());
                            } catch (Exception ignored) {
                                ignored.printStackTrace();
                            }

                            Toast.makeText(TextTranslator.this, "Try again later!", Toast.LENGTH_SHORT).show();
                        }
                    }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("X-RapidAPI-Key", "7b3868b8edmsh22c0a478f87d25dp1023eejsn874378684a26");
                    params.put("content-type", "application/json");
                    //params.put("Accept", "application/json");
                    params.put("X-RapidAPI-Host", "translate-plus.p.rapidapi.com");
                    return params;
                }

            };

            RequestQueue rQueue = Volley.newRequestQueue(getApplicationContext());
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(150000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            rQueue.add(jsonObjectRequest);
        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AdsManager.showInterstitialWithInterval(this, () -> {

        });
    }


}