package com.alphacrud.phototranslator;

import static android.content.ContentValues.TAG;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static com.alphacrud.phototranslator.MyApplication.Arabicoptions;
import static com.alphacrud.phototranslator.MyApplication.BelarusianTranslator;
import static com.alphacrud.phototranslator.MyApplication.Belarusianoptions;
import static com.alphacrud.phototranslator.MyApplication.Bengali;
import static com.alphacrud.phototranslator.MyApplication.BengalienglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.BulgarianTranslator;
import static com.alphacrud.phototranslator.MyApplication.Bulgarianoptions;
import static com.alphacrud.phototranslator.MyApplication.Catalan;
import static com.alphacrud.phototranslator.MyApplication.CatalanenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Croatian;
import static com.alphacrud.phototranslator.MyApplication.CroatianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Czech;
import static com.alphacrud.phototranslator.MyApplication.CzechenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Danish;
import static com.alphacrud.phototranslator.MyApplication.DanishenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.EngTurkoptions;
import static com.alphacrud.phototranslator.MyApplication.EngtoAfrikaansptions;
import static com.alphacrud.phototranslator.MyApplication.EngtoChineseoptions;
import static com.alphacrud.phototranslator.MyApplication.EngtoPersianoptions;
import static com.alphacrud.phototranslator.MyApplication.EngtoRussianoptions;
import static com.alphacrud.phototranslator.MyApplication.EngtoUrduoptions;
import static com.alphacrud.phototranslator.MyApplication.Esperanto;
import static com.alphacrud.phototranslator.MyApplication.EsperantoenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Finnish;
import static com.alphacrud.phototranslator.MyApplication.FinnishenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.French;
import static com.alphacrud.phototranslator.MyApplication.FrenchenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Galician;
import static com.alphacrud.phototranslator.MyApplication.GalicianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.German;
import static com.alphacrud.phototranslator.MyApplication.GermanenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Greek;
import static com.alphacrud.phototranslator.MyApplication.GreekenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Gujarati;
import static com.alphacrud.phototranslator.MyApplication.GujaratienglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Haitian;
import static com.alphacrud.phototranslator.MyApplication.HaitianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Hebrew;
import static com.alphacrud.phototranslator.MyApplication.HebrewenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Hindi;
import static com.alphacrud.phototranslator.MyApplication.HindienglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Hungarian;
import static com.alphacrud.phototranslator.MyApplication.HungarianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Icelandic;
import static com.alphacrud.phototranslator.MyApplication.IcelandicenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Indonesian;
import static com.alphacrud.phototranslator.MyApplication.IndonesianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Irish;
import static com.alphacrud.phototranslator.MyApplication.IrishenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Italian;
import static com.alphacrud.phototranslator.MyApplication.ItalianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Japanese;
import static com.alphacrud.phototranslator.MyApplication.JapaneseenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Kannada;
import static com.alphacrud.phototranslator.MyApplication.KannadaenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Korean;
import static com.alphacrud.phototranslator.MyApplication.KoreanenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Macedonian;
import static com.alphacrud.phototranslator.MyApplication.MacedonianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Malay;
import static com.alphacrud.phototranslator.MyApplication.MalayenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Marathi;
import static com.alphacrud.phototranslator.MyApplication.MarathienglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Romanian;
import static com.alphacrud.phototranslator.MyApplication.RomanianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Spanish;
import static com.alphacrud.phototranslator.MyApplication.SpanishenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Tamil;
import static com.alphacrud.phototranslator.MyApplication.TamilenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Telugu;
import static com.alphacrud.phototranslator.MyApplication.TeluguenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Thai;
import static com.alphacrud.phototranslator.MyApplication.ThaienglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Ukrainian;
import static com.alphacrud.phototranslator.MyApplication.UkrainianenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.Welsh;
import static com.alphacrud.phototranslator.MyApplication.WelshenglishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishAfrikaansTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishArabicTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishChineseTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishGermanTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishPersianTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishRussianTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishTurkishTranslator;
import static com.alphacrud.phototranslator.MyApplication.englishUrduTranslator;
import static com.alphacrud.phototranslator.MyApplication.options;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.print.PdfPrint;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.alphacrud.phototranslator.Adapter.LanguageAdapter;
import com.alphacrud.phototranslator.Model.LanguageModel;
import com.alphacrud.phototranslator.ads.AdsCallBack;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;

public class ScanResult extends AppCompatActivity {
    ProgressBar progress;
    String txt;
    EditText tvtxt;
    AdView mAdView;
    ProgressBar progressed;
    TextToSpeech t1;
    ArrayList<LanguageModel> list;
    TextView filterText;
    String t2;
    private ImageButton btnshare;
    private ImageView speack;
    private int result;
    private ProgressDialog progressDialog;
    private Button Trans;
    private TextView txt2;
    private LinearLayout language;
    private Dialog dialogLan;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 3;
    private static final int SECOND_ACTIVITY_REQUEST_CODE2 = 4;
    String detectLanCode = "en";
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

//    Translator englishGermanTranslator = null;
//    Translator CroatianenglishGermanTranslator = null;
//    Translator HebrewenglishGermanTranslator = null;
//    Translator IrishenglishGermanTranslator = null;
//    Translator CatalanenglishGermanTranslator = null;
//    Translator BengalienglishGermanTranslator = null;
//    Translator englishUrduTranslator = null;
//    Translator englishPersianTranslator = null;
//    Translator englishTurkishTranslator = null;
//    Translator englishChineseTranslator = null;
//    Translator englishRussianTranslator = null;
//    Translator englishAfrikaansTranslator = null;
//    Translator englishArabicTranslator = null;
//    Translator BelarusianTranslator = null;
//    Translator BulgarianTranslator = null;
//    TranslatorOptions options = null;
//    TranslatorOptions EngTurkoptions = null;
//    TranslatorOptions EngtoUrduoptions = null;
//    TranslatorOptions EngtoPersianoptions = null;
//    TranslatorOptions EngtoChineseoptions = null;
//    TranslatorOptions EngtoRussianoptions = null;
//    TranslatorOptions EngtoAfrikaansptions = null;
//    TranslatorOptions Arabicoptions = null;
//    TranslatorOptions Belarusianoptions = null;
//    TranslatorOptions Bulgarianoptions = null;
//    TranslatorOptions Bengali = null;
//    TranslatorOptions Telugu = null;
//    TranslatorOptions Catalan = null;
//    TranslatorOptions Czech = null;
//    TranslatorOptions Marathi = null;
//    TranslatorOptions Romanian = null;
//    Translator CzechenglishGermanTranslator = null;
//    Translator TeluguenglishGermanTranslator = null;
//    TranslatorOptions Welsh = null;
//    Translator WelshenglishGermanTranslator = null;
//    TranslatorOptions Danish = null;
//    Translator DanishenglishGermanTranslator = null;
//    TranslatorOptions German = null;
//    Translator GermanenglishGermanTranslator = null;
//    TranslatorOptions Greek = null;
//    Translator GreekenglishGermanTranslator = null;
//    TranslatorOptions Esperanto = null;
//    Translator EsperantoenglishGermanTranslator = null;
//    TranslatorOptions Spanish = null;
//    Translator SpanishenglishGermanTranslator = null;
//    TranslatorOptions Estonian = null;
//    Translator EstonianenglishGermanTranslator = null;
//    TranslatorOptions Finnish = null;
//    Translator FinnishenglishGermanTranslator = null;
//    Translator MarathienglishGermanTranslator = null;
//    TranslatorOptions French = null;
//    TranslatorOptions Irish = null;
//    TranslatorOptions Galician = null;
//    TranslatorOptions Gujarati = null;
//    TranslatorOptions Hebrew = null;
//    TranslatorOptions Hindi = null;
//    TranslatorOptions Croatian = null;
//    TranslatorOptions Haitian = null;
//    TranslatorOptions Indonesian = null;
//    TranslatorOptions Icelandic = null;
//    TranslatorOptions Hungarian = null;
//    TranslatorOptions Japanese = null;
//    TranslatorOptions Italian = null;
//    TranslatorOptions Georgian = null;
//    TranslatorOptions Kannada = null;
//    TranslatorOptions Korean = null;
//    TranslatorOptions Malay = null;
//    TranslatorOptions Thai = null;
//    TranslatorOptions Ukrainian = null;
//    TranslatorOptions Tamil = null;
//
//    TranslatorOptions Macedonian = null;
//    Translator FrenchenglishGermanTranslator = null;
//    Translator GalicianenglishGermanTranslator = null;
//    Translator GujaratienglishGermanTranslator = null;
//    Translator HindienglishGermanTranslator = null;
//    Translator HaitianenglishGermanTranslator = null;
//    Translator HungarianenglishGermanTranslator = null;
//    Translator IndonesianenglishGermanTranslator = null;
//    Translator IcelandicenglishGermanTranslator = null;
//    Translator KoreanenglishGermanTranslator = null;
//    Translator ItalianenglishGermanTranslator = null;
//    Translator KannadaenglishGermanTranslator = null;
//    Translator JapaneseenglishGermanTranslator = null;
//    Translator MacedonianenglishGermanTranslator = null;
//    Translator MalayenglishGermanTranslator = null;
//    Translator RomanianenglishGermanTranslator = null;
//    Translator ThaienglishGermanTranslator = null;
//    Translator UkrainianenglishGermanTranslator = null;
//    Translator TamilenglishGermanTranslator = null;

    String t;
    ImageButton btnBack;
    TemplateView template;
    private AdLoader adLoader;
    private boolean adLoaded = false;
    // google paly rating review dialog
    private ReviewManager reviewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        addLanguages();

        AdsManager.loadNativeAd(this, findViewById(R.id.llNativeLarge), R.layout.ad_unified_medium);


        progress = findViewById(R.id.progress);
        filterText = findViewById(R.id.filterText);
        btnshare = findViewById(R.id.btnshare);
        txt2 = findViewById(R.id.txt2);
        language = findViewById(R.id.language);
        speack = findViewById(R.id.speack);
        Trans = findViewById(R.id.Trans);
        tvtxt = findViewById(R.id.txt);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        txt = getIntent().getStringExtra("txt");
        t2 = txt;
        tvtxt.setText(txt);
        btnBack = findViewById(R.id.btnBack);

        findViewById(R.id.shareTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanResult.this, ShareActivity.class);
                intent.putExtra("txt", txt);
                startActivity(intent);
            }
        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        progress.setVisibility(View.GONE);
        progressed = findViewById(R.id.progressed);
        progressed.setVisibility(View.VISIBLE);


        LanguageIdentifier languageIdentifier =
                LanguageIdentification.getClient();
        languageIdentifier.identifyLanguage(txt)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(@Nullable String languageCode) {
                                if (languageCode.equals("und")) {
                                    detectLanCode = "en";
                                    Log.i(TAG, "Can't identify language.");
                                    filterText.setText("English");

                                } else {
                                    Log.i(TAG, "Language: " + languageCode);
                                    detectLanCode = languageCode;
                                    if (list.size() > 0) {
                                        for (int i = 0; i < list.size(); i++) {
                                            if (detectLanCode.contains(list.get(i).getShortCode())) {
                                                filterText.setText(list.get(i).getText());
                                                break;
                                            }

                                        }

                                    }


                                }
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                detectLanCode = "en";
                                filterText.setText("English");

                                // Model couldn’t be loaded or other internal error.
                                // ...
                            }
                        });

//        mAdView = findViewById(R.id.adView);
//        mAdView.setVisibility(View.GONE);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdClicked() {
//                // Code to be executed when the user clicks on an ad.
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when the user is about to return
//                // to the app after tapping on an ad.
//            }
//
//            @Override
//            public void onAdFailedToLoad(LoadAdError adError) {
//                progressed.setVisibility(View.GONE);
//
//                // Code to be executed when an ad request fails.
//            }
//
//            @Override
//            public void onAdImpression() {
//                // Code to be executed when an impression is recorded
//                // for an ad.
//            }
//
//            @Override
//            public void onAdLoaded() {
//                mAdView.setVisibility(View.VISIBLE);
//                progressed.setVisibility(View.GONE);
//
//                // Code to be executed when an ad finishes loading.
//            }
//
//            @Override
//            public void onAdOpened() {
//                // Code to be executed when an ad opens an overlay that
//                // covers the screen.
//            }
//        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanResult.this, ShareActivity.class);
                intent.putExtra("txt", txt);
                startActivity(intent);

            }
        });
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
//                    int result =   t1.setLanguage(Locale.US);
//                    int result =   t1.setLanguage(new Locale("ur"));
//                    if (ur) {
//                        result = t1.setLanguage(new Locale("ur"));
//                    } else {
                    result = t1.setLanguage(Locale.US);


//                  int result =   t1.setLanguage(new Locale("ur"));

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.d("textllflfl", "This Language is not supported");
                    }
                } else {
                    Log.d("textdddfdsf", "Initilization Failed!");
                }
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
            }
        });
        speack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.speak(tvtxt.getText().toString().trim(), TextToSpeech.QUEUE_FLUSH, null);

            }
        });

//        Trans.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialgLanguage();
            }
        });
//        adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110").forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//
//            private ColorDrawable background;
//            @Override
//            public void onNativeAdLoaded(@NonNull NativeAd unifiedNativeAd) {
//
//                NativeTemplateStyle styles = new
//                        NativeTemplateStyle.Builder().build();
//
//                template = findViewById(R.id.nativeTemplateView);
//                template.setStyles(styles);
//                template.setNativeAd(unifiedNativeAd);
//                adLoaded = true;
//
////
//
//                // Showing a simple Toast message to user when Native an ad is Loaded and ready to show
//
//            }
//
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
        reviewManager = ReviewManagerFactory.create(this);
        showRatingDialog();
    }


    private void DialgLanguage() {
        dialogLan = new Dialog(ScanResult.this);
        dialogLan.setContentView(R.layout.dialog_select_language);
        dialogLan.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        RecyclerView recyclerView = dialogLan.findViewById(R.id.recyclerView);
        EditText etSearch = dialogLan.findViewById(R.id.etSearch);
        ImageView ivClear = dialogLan.findViewById(R.id.ivClear);
        LanguageAdapter languageAdapter = new LanguageAdapter(list, this);
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

    private void DialogsssNew() {
        final Dialog dialog = new Dialog(ScanResult.this);
        dialog.setContentView(R.layout.layout_share);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout linearsahre = dialog.findViewById(R.id.linearsahre);
        LinearLayout linearDoc = dialog.findViewById(R.id.linearDoc);

// Custom animation speed or duration.
        // Declaring the animation view
        LottieAnimationView animationView
                = dialog.findViewById(R.id.animation_view);
        animationView
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView
                .playAnimation();
        LottieAnimationView animationView2
                = dialog.findViewById(R.id.animation_view2);
        animationView2
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView2
                .playAnimation();


        linearsahre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Share2(tvtxt.getText().toString().trim());
            }
        });
        linearDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Dialogsss();
            }
        });

        dialog.show();
    }

    private void Dialogsss() {
        final Dialog dialog = new Dialog(ScanResult.this);
        dialog.setContentView(R.layout.dialog_pdfs);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout lineartxt = dialog.findViewById(R.id.lineartxt);
        LinearLayout linearPDF = dialog.findViewById(R.id.linearPDF);
        LinearLayout linearDoc = dialog.findViewById(R.id.linearDoc);
        LinearLayout linearMsg = dialog.findViewById(R.id.linearMsg);
        lineartxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = getIntent().getStringExtra("txt");
                generateNoteOnSD(ScanResult.this, System.currentTimeMillis() + "Notes", txt);
//                Intent in = new Intent(ScanResult.this, Adds.class);
//                in.putExtra("call", "check_info_kunda");
//                in.putExtra("screen_name", "kunnda");
//                startActivityForResult(in, SECOND_ACTIVITY_REQUEST_CODE2);
//                progressDialog.show();
                dialog.dismiss();
            }
        });
        linearDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                txt = getIntent().getStringExtra("txt");

                dialog.dismiss();
                generateDoc(ScanResult.this, System.currentTimeMillis() + "Doc", txt);
            }
        });
        linearPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = getIntent().getStringExtra("txt");
                if (ContextCompat.checkSelfPermission(ScanResult.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ScanResult.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                } else {
//                    if (filter.equals("all")) {
//                        promptReportDialog();
//                    } else {
//                        if (filter.equals("zero")) {
//                            zero_customers = true;
//                        }
//                        doWebViewPrint();
//                    }
//                    doWebViewPrint();
                    pdfOnBackground();
//                    generatePDf(ScanResult.this, System.currentTimeMillis() + "PDF", txt);

                }

//                Intent in = new Intent(ScanResult.this, Adds.class);
//                in.putExtra("call", "check_info_kunda");
//                in.putExtra("screen_name", "kunnda");
//                startActivityForResult(in, SECOND_ACTIVITY_REQUEST_CODE);
//                progressDialog.show();

                dialog.dismiss();
            }
        });
        linearMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = getIntent().getStringExtra("txt");

                dialog.dismiss();
                Share(txt);
            }
        });

        dialog.show();
//        dialog.setContentView(R.layout.di);
    }


    private void detectText(Bitmap b) {

        InputImage image = InputImage.fromBitmap(b, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


        //   Uri uri= getImageUri(LiveFeed.this,b);

        //  b=  rotateImageIfRequired(b,uri);
        Task<Text> result =
                recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text text) {

                        progress.setVisibility(View.GONE);
                        String scannedText = text.getText().trim();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();

                        Toast.makeText(ScanResult.this, "Please capture a clear picture of ID card", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }

    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOCUMENTS);
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName + ".txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            progressDialog.dismiss();
//            openFile(ScanResult.this,gpxfile);
            previewPdf(ScanResult.this, gpxfile);
//            readFile(root+sFileName+".doc");
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateDoc(Context context, String sFileName, String sBody) {
        try {
            File root = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOCUMENTS);
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName + ".doc");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            progressDialog.dismiss();
//            openFile(ScanResult.this,gpxfile);
            previewPdf(ScanResult.this, gpxfile);
//            readFile(root+sFileName+".doc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePDf(Context context, String sFileName, String sBody) {
        try {
            progressDialog.setMessage("Generating PDF");
            progressDialog.show();
            File root = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOCUMENTS);
            if (!root.exists()) {
                root.mkdirs();
            }

//            openFile(ScanResult.this,gpxfile);
            File gpxfile = new File(root, sFileName + ".pdf");
            FileWriter writer = null;
            try {
                writer = new FileWriter(gpxfile);
                writer.append(sBody);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    progressDialog.dismiss();

                    previewPdf2(ScanResult.this, gpxfile);

                }
            }, 10000);
//            readFile(root+sFileName+".doc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createWebPrintJob(WebView webView) {
        try {
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP
                    || Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1) {
                PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);
                String jobName = "Customers_List_Report_" + System.currentTimeMillis();
                PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);
                if (printManager != null) {
                    PrintAttributes.Builder builder = new PrintAttributes.Builder();
                    builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
                    printManager.print(jobName, printAdapter, builder.build());
                } else {
                    Toast.makeText(ScanResult.this, "Error!", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            } else {
                PrintDocumentAdapter printAdapter;
                String jobName = getString(R.string.app_name) + " Document";
                PrintAttributes attributes = new PrintAttributes.Builder()
                        .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                        .setResolution(new PrintAttributes.Resolution("application/pdf", "application/pdf", 600, 600))
                        .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();

                final File docsFolder = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + "/");
                if (!docsFolder.exists()) {
                    boolean b = docsFolder.mkdirs();
                    if (b) {
                        Log.i("TAG", "Created a new directory for PDF");
                    } else {
                        Log.i("TAG", "Directory not created.");
                    }
                }

                PdfPrint pdfPrint = new PdfPrint(attributes, this);
                printAdapter = webView.createPrintDocumentAdapter(jobName);

                final String fileName = "Customers_List_Report_" + System.currentTimeMillis() + ".pdf";
                pdfPrint.print(printAdapter, docsFolder, fileName);

                new Handler().postDelayed(() -> {
                    try {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        File file = new File(docsFolder.getAbsolutePath(), fileName);
                        previewPdf2(this, file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, 3000);
            }

        } catch (Exception e) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void doWebViewPrint() {
        progressDialog.show();

        WebView webView = new WebView(ScanResult.this);
        webView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "page finished loading " + url);
                createWebPrintJob(view);
            }
        });

        webView.loadDataWithBaseURL("file:///android_asset/", finalPrint(), "text/HTML", "UTF-8", null);

    }

    private String finalPrint() {

        String s;


        s = "<html>" +
                "<head>" +
                "        <style>" +

                "            body{" +
                "                margin: 10px;" +
                "            }" +
                "            .footer {" +
                "                background: #e74425;" +
                "                color: white;" +
                "            }" +
                "" +
                "            .heading {" +
                "                display: table-header-group;" +
                "            }" +
                "" +
                "            table th {" +
                "                font-size: 14px;" +
                "            }" +
                "" +
                "            .font-12 td {" +
                "                font-size: 14px;" +
                "            }" +
                "" +
                "            @media print {" +
                "                .header {" +
                "                    position: fixed;" +
                "                    top: 0;" +
                "                }" +
                "" +
                "                .footer {" +
                "                    position: fixed;" +
                "                    bottom: 0;" +
                "                }" +
                "" +
                "                @page {" +
                "                    margin: 0px;" +
                "                }" +
                "" +
                "            }" +
                "" +
                "            .footer, .footer-space {" +
                "                height: 70px;" +
                "                width: 100%;" +
                "            }" +
                "" +
                "            .header, .header-space {" +
                "                height: 85px;" +
                "                width: 100%;" +
                "            }" +
                "" +
                "            .app-link{" +
                "                text-decoration: none;" +
                "                color: white;" +
                "            }" +
                "" +
                "            .transaction-table td{" +
                "                padding: 10px;" +
                "                border: 1px solid darkgray;" +
                "            }" +
                "" +
                "            .transaction-table th{" +
                "                padding: 10px !important;" +
                "                background: #f0f2f5 ;" +
                "" +
                "            }" +
                "" +
                "            .transaction-table{" +
                "                border-collapse: collapse;" +
                "                width: 100%; border-spacing: 0px;" +
                "                border: 1px solid darkgray;" +
                "            }" +
                "" +
                "            .install-btn{" +
                "                background: white;" +
                "                padding: 5px;" +
                "                font-size: 11px;" +
                "                text-decoration: none;" +
                "                font-weight: 700;" +
                "                margin-left: 15px;" +
                "                border-radius: 4px;" +
                "            }" +
                "" +
                "            .call-btn{" +
                "                color: white;" +
                "                text-decoration: none;" +
                "            }" +
                "" +
                "            .font-10{" +
                "                font-size: 10px;" +
                "            }" +
                "" +
                "            .amount-td{" +
                "                padding-top: 10px;" +
                "                padding-bottom: 7px;" +
                "                text-align: right;" +
                "                word-break: break-word;" +
                "            }" +
                "" +
                "            .color-green{" +
                "                background: #E5FFF2 !important;" +
                "            }" +
                "" +
                "            .color-red{" +
                "                background: #FFEDED  !important;" +
                "            }" +
                "" +
                "            .text-center{" +
                "                text-align: center;" +
                "            }" +
                "" +
                "            .border-bottom{" +
                "                border-bottom: 1px solid darkgray;" +
                "            }" +
                "" +
                "            .grand-total{" +
                "                margin-top: 10px;" +
                "            }" +
                "" +
                "            .total-balance-box{" +
                "                width: 100%;" +
                "                margin-bottom: 20px;" +
                "                border: 1px solid darkgray;" +
                "            }" +
                "" +
                "            .total-balance-box table{" +
                "                width: 100%;" +
                "                line-height: 1.4;" +
                "                font-size: 15px;" +
                "                font-weight: 500;" +
                "                padding: 20px;" +
                "                text-align: center;" +
                "            }" +
                "" +
                "            .red-color{" +
                "                color: #F00000;" +
                "            }" +
                "" +
                "            .green-color{" +
                "                color: #009900;" +
                "            }" +
                "" +
                "            .zero-color{" +
                "                color: #9494b8;" +
                "            }" +
                "" +
                "            .padding-zero{" +
                "                padding: 0px !important;" +
                "            }" +
                "" +
                "            .empty-table{" +
                "                width: 0px !important;" +
                "                padding: 0px;" +
                "            }" +
                "" +
                "            .td-line{" +
                "                height: 55px;" +
                "                border-right: 1px solid darkgray;" +
                "                padding: 0px;" +
                "            }" +
                "" +
                "            .text-left{" +
                "                text-align: left !important;" +
                "            }" +
                "" +
                "            .gray-color{" +
                "                color: gray !important;" +
                "            }" +
                "" +
                "            .border-left-zero{" +
                "                border-left: 0px !important;" +
                "            }" +
                "" +
                "            .border-right-zero{" +
                "                border-right: 0px !important;" +
                "            }" +
                "" +
                "            .padding-left-ten{" +
                "                padding-left: 10px !important;" +
                "            }" +
                "        </style>" +
                "    </head>" +
                "" +
                "<body>" +
                "<p>" + tvtxt.getText().toString().trim() + "" +
                "</body>" +
                "</html>";


        return s;
    }


    public void previewPdf(Context context, File pdfFile) {
        try {
            Uri photoURI = FileProvider.getUriForFile(this,
                    "com.androidapp.filetransfer.fileprovider",
                    pdfFile);

            PackageManager packageManager = getPackageManager();
            Intent testIntent = new Intent(Intent.ACTION_VIEW);
            testIntent.setType("application/msword");

//            List<Intent> emailAppLauncherIntents = new ArrayList<>();
            List<ResolveInfo> list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
//            for (ResolveInfo resolveInfo : list) {
//                String packageName = resolveInfo.activityInfo.packageName;
//                if (packageName.equals("com.google.android.apps.docs")){
//                    Intent launchIntent = packageManager.getLaunchIntentForPackage(packageName);
//                    emailAppLauncherIntents.add(launchIntent);
//                    break;
//                }
//            }
            if (list.size() > 0) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW)
                        .addFlags(FLAG_GRANT_WRITE_URI_PERMISSION)
                        .addFlags(FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(photoURI, "application/msword");
                Intent chooserIntent = Intent.createChooser(intent, "View Report With:");
                startActivity(chooserIntent);
            } else {
                Intent shareIntent = new Intent(Intent.ACTION_VIEW)
                        .addFlags(FLAG_GRANT_WRITE_URI_PERMISSION)
                        .addFlags(FLAG_GRANT_READ_URI_PERMISSION)
                        .setDataAndType(photoURI, "application/msword")
                        .setPackage("com.google.android.apps.docs");
                startActivity(shareIntent);
            }
        } catch (Exception e) {

            if (e instanceof ActivityNotFoundException) {
                Toast.makeText(this, "Download a PDF Viewer to see the generated PDF", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void previewPdf2(Context context, File pdfFile) {
        try {
            Uri photoURI = FileProvider.getUriForFile(this,
                    "com.androidapp.filetransfer.fileprovider",
                    pdfFile);

            PackageManager packageManager = getPackageManager();
            Intent testIntent = new Intent(Intent.ACTION_VIEW);
            testIntent.setType("application/pdf");
            testIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            testIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            List<Intent> emailAppLauncherIntents = new ArrayList<>();
            List<ResolveInfo> list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
//            for (ResolveInfo resolveInfo : list) {
//                String packageName = resolveInfo.activityInfo.packageName;
//                if (packageName.equals("com.google.android.apps.docs")){
//                    Intent launchIntent = packageManager.getLaunchIntentForPackage(packageName);
//                    emailAppLauncherIntents.add(launchIntent);
//                    break;
//                }
//            }
            if (list.size() > 0) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW)
                        .addFlags(FLAG_GRANT_WRITE_URI_PERMISSION)
                        .addFlags(FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(photoURI, "application/pdf");
                Intent chooserIntent = Intent.createChooser(intent, "View Report With:");
                startActivity(chooserIntent);
            } else {
                Intent shareIntent = new Intent(Intent.ACTION_VIEW)
                        .addFlags(FLAG_GRANT_WRITE_URI_PERMISSION)
                        .addFlags(FLAG_GRANT_READ_URI_PERMISSION)
                        .setDataAndType(photoURI, "application/pdf")
                        .setPackage("com.google.android.apps.docs");
                startActivity(shareIntent);
            }
        } catch (Exception e) {

            if (e instanceof ActivityNotFoundException) {
                Toast.makeText(this, "Download a PDF Viewer to see the generated PDF", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    //    private void Share(String amount) {
//        try {
//
//            String message = amount;
//
//            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//            sharingIntent.setType("text/plain");
////            sharingIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
//            sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
//            sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            startActivity(Intent.createChooser(sharingIntent, "Select"));
//        } catch (Exception e) {
//            Toast.makeText(ScanResult.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
    private void Share(String link) {
        t1 = null;
        String sms = link;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:+" + cPhone));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("smsto:" + ""));
        intent.putExtra("sms_body", sms);
        startActivity(intent);
    }

    private void Share2(String phone) {
        try {
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.share_image);
//            File file = new File(getExternalCacheDir(), "dgk_.jpeg");
//            FileOutputStream fOut = new FileOutputStream(file);
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
//            fOut.flush();
//            fOut.close();

//            String message = "Salam, I'm using one of my *limited invites* to refer you to DigiKhata - *Pakistan's #1* business app.\n\nIt is 100% *Free*, Safe and Secure. It also sends Free updates on every transaction.\n\nInstall DigiKhata using my link.\n\nhttps://digikhata.pk/install\n\n";

            String message = phone;
//            bitmap.recycle();

//            boolean w = appInstalledOrNot("com.whatsapp");
//            boolean w4b = appInstalledOrNot("com.whatsapp.w4b");
//
//            if (w && w4b) {
//                WhatsAppSelectionBottomSheet bottomSheet = new WhatsAppSelectionBottomSheet(InvitesActivity.this, file, phone, message);
//                bottomSheet.show(getSupportFragmentManager(), "WhatsAppSelectionBottomSheet");
//            } else if (w) {
//                sendToWhatsApp(file, phone, message, "com.whatsapp");
//            } else if (w4b) {
//                sendToWhatsApp(file, phone, message, "com.whatsapp.w4b");
//            } else {
////                Intent intent = new Intent(Intent.ACTION_SENDTO);
////                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                intent.setData(Uri.parse("smsto:" + phone));
////                intent.putExtra("sms_body", message);
////
////                startActivity(intent);
//
//                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
//                sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                startActivity(Intent.createChooser(sharingIntent, "Select"));
//            }
//            Uri photoURI = FileProvider.getUriForFile(EasyloadActivity.this, "com.androidapp.digikhata.fileprovider", file);
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
//            sharingIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
            sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(sharingIntent, "Select"));
        } catch (Exception e) {
            Toast.makeText(ScanResult.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String s = "";

    private void pdfOnBackground() {
        progressDialog.show();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {


                s = finalPrint();


                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        WebView webView = new WebView(getApplicationContext());
                        webView.setWebViewClient(new WebViewClient() {

                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                return false;
                            }

                            @Override
                            public void onPageFinished(WebView view, String url) {
                                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP
                                        || Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1) {

                                    PrintManager printManager = (PrintManager) ScanResult.this.getSystemService(Context.PRINT_SERVICE);
                                    String jobName = "Photo Translator PDF" + System.currentTimeMillis();
                                    PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);
                                    if (printManager != null) {
                                        PrintAttributes.Builder builder = new PrintAttributes.Builder();
                                        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
                                        printManager.print(jobName, printAdapter, builder.build());
                                    } else {
                                        Toast.makeText(ScanResult.this, "Error!", Toast.LENGTH_SHORT).show();
                                    }
                                    progressDialog.dismiss();
                                } else {
                                    try {
                                        registerReceiver(PdfReceiver, new IntentFilter("PDF-STATUS"));
                                        PrintDocumentAdapter printAdapter;
                                        String jobName = getString(R.string.app_name) + " Document";
                                        PrintAttributes attributes = new PrintAttributes.Builder()
                                                .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                                                .setResolution(new PrintAttributes.Resolution("application/pdf", "application/pdf", 600, 600))
                                                .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();

                                        final File docsFolder = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + "/");
                                        if (!docsFolder.exists()) {
                                            docsFolder.mkdirs();
                                        }
//                                        pdfPrint pdfPrint = new pdfPrint(attributes, CustomerReportActivity.this);
                                        printAdapter = webView.createPrintDocumentAdapter(jobName);

                                        String time = String.valueOf(System.currentTimeMillis());
                                        final String fileName = "Photo_Translator_" + time + ".pdf";
//                                        pdfPrint.printNew(printAdapter, docsFolder, fileName, getCacheDir().getPath());
                                        PdfPrint pdfPrint = new PdfPrint(attributes, ScanResult.this);
                                        pdfPrint.print(printAdapter, docsFolder, fileName);

//                                        progressDialog.setMessage(80 + "% completed");
//                                        double l = (double) 20000 / MyApplication.reportDelay;
//                                        new CountDownTimer(MyApplication.reportDelay, 1000) {
//
//                                            public void onTick(long millisUntilFinished) {
//                                                progress += l;
//                                                progressDialog.setMessage((int) progress + "% completed");
//                                            }
//
//                                            public void onFinish() {
//                                                try {
//                                                    if (progressDialog.isShowing()) {
//                                                        progressDialog.dismiss();
//                                                    }
//                                                    if (share) {
//                                                        share = false;
//                                                        pdfFile = new File(docsFolder.getAbsolutePath(), fileName);
//
//                                                        boolean w = appInstalledOrNot("com.whatsapp");
//                                                        boolean w4b = appInstalledOrNot("com.whatsapp.w4b");
//                                                        boolean gb = appInstalledOrNot("com.gbwhatsapp");
//
//                                                        if (w && w4b) {
//
//                                                            try {
//                                                                WhatsappBottomSheet bottomSheet = new WhatsappBottomSheet();
//                                                                bottomSheet.show(getSupportFragmentManager(), "whatsappBottomSheet");
//                                                            } catch (IllegalStateException e) {
//                                                                e.printStackTrace();
//                                                            }
//
//                                                        } else if (w) {
//
//                                                            shareImageToWhatsapp("com.whatsapp");
//
//                                                        } else if (gb) {
//
//                                                            shareImageToWhatsapp("com.gbwhatsapp");
//
//                                                        } else if (w4b) {
//
//                                                            shareImageToWhatsapp("com.whatsapp.w4b");
//
//                                                        } else {
//                                                            Toast.makeText(CustomerReportActivity.this, "Whatsapp not installed!", Toast.LENGTH_SHORT).show();
//                                                        }
//                                                    } else {
//                                                        File file = new File(docsFolder.getAbsolutePath() + "/", fileName);
//                                                        previewPdf(getApplicationContext(), file);
//                                                    }
//                                                } catch (Exception e) {
//                                                    e.printStackTrace();
//                                                }
//                                            }
//                                        }.start();
                                    } catch (Exception e) {
                                        if (progressDialog.isShowing()) {
                                            progressDialog.dismiss();
                                        }
                                        Toast.makeText(ScanResult.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });

                        webView.loadDataWithBaseURL("file:///android_asset/", s, "text/HTML", "UTF-8", null);

//                        makePDF(CustomerReportActivity.this, progressDialog, s, "Customer_Ledger_Report_");
                    }
                });
            }
        });
    }


    public BroadcastReceiver PdfReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            unregisterReceiver(PdfReceiver);
            String pdf_status = intent.getStringExtra("pdf_status");
            if (pdf_status != null && !pdf_status.isEmpty()) {
                if (pdf_status.equals("success")) {
                    String pdf_file_path = intent.getStringExtra("pdf_file_path");
                    String pdf_file_name = intent.getStringExtra("pdf_file_name");
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }

                    File file = new File(pdf_file_path, pdf_file_name);
                    previewPdf2(getApplicationContext(), file);

                } else {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    String msg = intent.getStringExtra("msg");
                    Toast.makeText(ScanResult.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public void Translate(String text, String s) {
        language.setClickable(false);
        language.setEnabled(false);

        if (dialogLan.isShowing()) {
            dialogLan.dismiss();

        }
        if (options != null) {
            Translator translator = Translation.getClient(options);
            getLifecycle().addObserver(translator);
        }
        progress.setVisibility(View.VISIBLE);
        englishGermanTranslator = null;
        options = null;
        t = text;
        if (!text.contains("English")) {
            if (text.contains("Urdu")) {
                EngtoUrduoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.URDU)
                                .build();
                englishUrduTranslator =
                        Translation.getClient(EngtoUrduoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishUrduTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        TranasUrdu();
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {
//                    int result =   t1.setLanguage(Locale.US);
//                    int result =   t1.setLanguage(new Locale("ur"));
//                    if (ur) {
//                        result = t1.setLanguage(new Locale("ur"));
//                    } else {
//                            result = t1.setLanguage(Locale.UR);
                                                    result = t1.setLanguage(new Locale(s));


//                  int result =   t1.setLanguage(new Locale("ur"));

                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
                                            }
                                        });

                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });


            } else if (text.contains("Persian")) {
                EngtoPersianoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.PERSIAN)
                                .build();
                englishPersianTranslator =
                        Translation.getClient(EngtoPersianoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishPersianTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        TranasPer();
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {
//                    int result =   t1.setLanguage(Locale.US);
//                    int result =   t1.setLanguage(new Locale("ur"));
//                    if (ur) {
//                        result = t1.setLanguage(new Locale("ur"));
//                    } else {
//                            result = t1.setLanguage(Locale.UR);
                                                    result = t1.setLanguage(new Locale("fa"));


//                  int result =   t1.setLanguage(new Locale("ur"));

                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
                                            }
                                        });


                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });


            } else if (text.contains("Turkish")) {
                EngTurkoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.TURKISH)
                                .build();
                englishTurkishTranslator =
                        Translation.getClient(EngTurkoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishTurkishTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {
//                    int result =   t1.setLanguage(Locale.US);
//                    int result =   t1.setLanguage(new Locale("ur"));
//                    if (ur) {
//                        result = t1.setLanguage(new Locale("ur"));
//                    } else {
//                            result = t1.setLanguage(Locale.UR);
                                                    result = t1.setLanguage(new Locale("tr"));


//                  int result =   t1.setLanguage(new Locale("ur"));

                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
                                            }
                                        });


                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Chinese")) {
                EngtoChineseoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.CHINESE)
                                .build();
                englishChineseTranslator =
                        Translation.getClient(EngtoChineseoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishChineseTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishChineseTranslator, EngtoChineseoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {
//                    int result =   t1.setLanguage(Locale.US);
//                    int result =   t1.setLanguage(new Locale("ur"));
//                    if (ur) {
//                        result = t1.setLanguage(new Locale("ur"));
//                    } else {
//                            result = t1.setLanguage(Locale.UR);
                                                    result = t1.setLanguage(new Locale("zh"));


//                  int result =   t1.setLanguage(new Locale("ur"));

                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                }
                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Russian")) {
                EngtoRussianoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.RUSSIAN)
                                .build();
                englishRussianTranslator =
                        Translation.getClient(EngtoRussianoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishRussianTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishRussianTranslator, EngtoRussianoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("ru"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Afrikaans")) {
                EngtoAfrikaansptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.AFRIKAANS)
                                .build();
                englishAfrikaansTranslator =
                        Translation.getClient(EngtoAfrikaansptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishAfrikaansTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishAfrikaansTranslator, EngtoAfrikaansptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("af"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();


                                    }
                                });
            } else if (text.contains("Arabic")) {
                Arabicoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ARABIC)
                                .build();
                englishArabicTranslator =
                        Translation.getClient(Arabicoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishArabicTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishArabicTranslator, Arabicoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("ar"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
                if (options != null) {
                    Translator translator = Translation.getClient(options);
                    getLifecycle().addObserver(translator);
                }
            } else if (text.contains("Belarusian")) {
                Belarusianoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.BELARUSIAN)
                                .build();
                BelarusianTranslator =
                        Translation.getClient(Belarusianoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                BelarusianTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(BelarusianTranslator, Belarusianoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("be"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Bulgarian")) {
                Bulgarianoptions =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.BULGARIAN)
                                .build();
                BulgarianTranslator =
                        Translation.getClient(Bulgarianoptions);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                BulgarianTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(BulgarianTranslator, Bulgarianoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("bg"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Bengali")) {
                Bengali =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.BENGALI)
                                .build();
                BengalienglishGermanTranslator =
                        Translation.getClient(Bengali);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                BengalienglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(BengalienglishGermanTranslator, Bengali);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("bn"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Catalan")) {
                Catalan =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.CATALAN)
                                .build();
                CatalanenglishGermanTranslator =
                        Translation.getClient(Catalan);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                CatalanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(CatalanenglishGermanTranslator, Catalan);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("ca"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Czech")) {
                Czech =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.CZECH)
                                .build();
                CzechenglishGermanTranslator =
                        Translation.getClient(Czech);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                CzechenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(CzechenglishGermanTranslator, Czech);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("cs"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Welsh")) {
                Welsh =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.WELSH)
                                .build();
                WelshenglishGermanTranslator =
                        Translation.getClient(Welsh);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                WelshenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(WelshenglishGermanTranslator, Welsh);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("cy"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Danish")) {
                Danish =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.DANISH)
                                .build();
                DanishenglishGermanTranslator =
                        Translation.getClient(Danish);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                DanishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(DanishenglishGermanTranslator, Danish);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("da"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("German")) {
                German =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.GERMAN)
                                .build();
                GermanenglishGermanTranslator =
                        Translation.getClient(German);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                GermanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(GermanenglishGermanTranslator, German);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("de"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Greek")) {
                Greek =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.GREEK)
                                .build();
                GreekenglishGermanTranslator =
                        Translation.getClient(Greek);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                GreekenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(GreekenglishGermanTranslator, Greek);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale("el"));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Esperanto")) {
                Esperanto =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ESPERANTO)
                                .build();
                EsperantoenglishGermanTranslator =
                        Translation.getClient(Esperanto);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                EsperantoenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(EsperantoenglishGermanTranslator, Esperanto);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Spanish")) {
                Spanish =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.SPANISH)
                                .build();
                SpanishenglishGermanTranslator =
                        Translation.getClient(Spanish);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                SpanishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(SpanishenglishGermanTranslator, Spanish);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Finnish")) {
                Finnish =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.FINNISH)
                                .build();
                FinnishenglishGermanTranslator =
                        Translation.getClient(Finnish);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                FinnishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(FinnishenglishGermanTranslator, Finnish);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("French")) {
                French =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.FRENCH)
                                .build();
                FrenchenglishGermanTranslator =
                        Translation.getClient(French);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                FrenchenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(FrenchenglishGermanTranslator, French);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Irish")) {
                Irish =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.IRISH)
                                .build();
                IrishenglishGermanTranslator =
                        Translation.getClient(Irish);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                IrishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(IrishenglishGermanTranslator, Irish);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Galician")) {
                Galician =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.GALICIAN)
                                .build();
                GalicianenglishGermanTranslator =
                        Translation.getClient(Galician);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                GalicianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(GalicianenglishGermanTranslator, Galician);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Gujarati")) {
                Gujarati =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.GUJARATI)
                                .build();
                GujaratienglishGermanTranslator =
                        Translation.getClient(Gujarati);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                GujaratienglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(GujaratienglishGermanTranslator, Gujarati);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Hebrew")) {
                Hebrew =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.HEBREW)
                                .build();
                HebrewenglishGermanTranslator =
                        Translation.getClient(Hebrew);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                HebrewenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(HebrewenglishGermanTranslator, Hebrew);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Hindi")) {
                Hindi =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.HINDI)
                                .build();
                HindienglishGermanTranslator =
                        Translation.getClient(Hindi);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                HindienglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(HindienglishGermanTranslator, Hindi);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Croatian")) {
                Croatian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.CROATIAN)
                                .build();
                CroatianenglishGermanTranslator =
                        Translation.getClient(Croatian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                CroatianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(CroatianenglishGermanTranslator, Croatian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Haitian")) {
                Haitian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.HAITIAN_CREOLE)
                                .build();
                HaitianenglishGermanTranslator =
                        Translation.getClient(Haitian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                HaitianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(HaitianenglishGermanTranslator, Haitian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Hungarian")) {
                Hungarian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.HUNGARIAN)
                                .build();
                HungarianenglishGermanTranslator =
                        Translation.getClient(Hungarian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                HungarianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(HungarianenglishGermanTranslator, Hungarian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Indonesian")) {
                Indonesian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.INDONESIAN)
                                .build();
                IndonesianenglishGermanTranslator =
                        Translation.getClient(Indonesian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                IndonesianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(IndonesianenglishGermanTranslator, Indonesian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Icelandic")) {
                Icelandic =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ICELANDIC)
                                .build();
                IcelandicenglishGermanTranslator =
                        Translation.getClient(Icelandic);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                IcelandicenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(KannadaenglishGermanTranslator, Icelandic);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Italian")) {
                Italian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ITALIAN)
                                .build();
                ItalianenglishGermanTranslator =
                        Translation.getClient(Italian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                ItalianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(ItalianenglishGermanTranslator, Italian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Japanese")) {
                Japanese =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.JAPANESE)
                                .build();
                JapaneseenglishGermanTranslator =
                        Translation.getClient(Japanese);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                JapaneseenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(JapaneseenglishGermanTranslator, Japanese);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Georgian")) {
                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.GEORGIAN)
                                .build();
                englishGermanTranslator =
                        Translation.getClient(options);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                englishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Kannada")) {
                Kannada =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.KANNADA)
                                .build();
                KannadaenglishGermanTranslator =
                        Translation.getClient(Kannada);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                KannadaenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(englishTurkishTranslator, Kannada);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Korean")) {
                Korean =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.KOREAN)
                                .build();
                KoreanenglishGermanTranslator =
                        Translation.getClient(Korean);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                KoreanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(KoreanenglishGermanTranslator, Korean);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            }
//       else if (text.contains("Lithuanian")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.LITHUANIAN)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Latvian")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.LATVIAN)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
            else if (text.contains("Macedonian")) {
                Macedonian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.MACEDONIAN)
                                .build();
                MacedonianenglishGermanTranslator =
                        Translation.getClient(Macedonian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                MacedonianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(MacedonianenglishGermanTranslator, Macedonian);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Marathi")) {
                Marathi =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.MARATHI)
                                .build();
                MarathienglishGermanTranslator =
                        Translation.getClient(Marathi);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                MarathienglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(MarathienglishGermanTranslator, Marathi);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Malay")) {
                Malay =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.MALAY)
                                .build();
                MalayenglishGermanTranslator =
                        Translation.getClient(Malay);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                MalayenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(MalayenglishGermanTranslator, Malay);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            }
//       else if (text.contains("Maltese")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.MALTESE)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Dutch")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.DUTCH)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded()
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Norwegian")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.NORWEGIAN)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Polish")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.POLISH)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Portuguese")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.PORTUGUESE)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
            else if (text.contains("Romanian")) {
                Romanian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ROMANIAN)
                                .build();
                RomanianenglishGermanTranslator =
                        Translation.getClient(Romanian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                RomanianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(RomanianenglishGermanTranslator, Romanian);

                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            }

            //       else if (text.contains("Slovak")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.SLOVAK)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
//       else if (text.contains("Slovenian")) {
//                options =
//                        new TranslatorOptions.Builder()
//                                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                                .setTargetLanguage(TranslateLanguage.SLOVENIAN)
//                                .build();
//                englishGermanTranslator =
//                        Translation.getClient(options);
//                DownloadConditions conditions = new DownloadConditions.Builder()
//                        .requireWifi()
//                        .build();
//                englishGermanTranslator.downloadModelIfNeeded(conditions)
//                        .addOnSuccessListener(
//                                new OnSuccessListener() {
//                                    @Override
//                                    public void onSuccess(Object o) {
//                                        Tranas(englishTurkishTranslator, EngtoRussianoptions);
//
//                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                                            @Override
//                                            public void onInit(int status) {
//                                                if (status == TextToSpeech.SUCCESS) {
//
//                                                    result = t1.setLanguage(new Locale(s));
//
//
//                                                    if (result == TextToSpeech.LANG_MISSING_DATA
//                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                                                        Log.d("textllflfl", "This Language is not supported");
//                                                    }
//                                                } else {
//                                                    Log.d("textdddfdsf", "Initilization Failed!");
//                                                }
//
//                                            }
//                                        });
//                                    }
//
//
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                        // Model couldn’t be downloaded or other internal error.
//                                        // ...
//                                    }
//                                });
//            }
            else if (text.contains("Ukrainian")) {
                Ukrainian =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.UKRAINIAN)
                                .build();
                UkrainianenglishGermanTranslator =
                        Translation.getClient(Ukrainian);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                UkrainianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(UkrainianenglishGermanTranslator, Ukrainian);

                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Thai")) {
                Thai =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.THAI)
                                .build();
                ThaienglishGermanTranslator =
                        Translation.getClient(Thai);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                ThaienglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(ThaienglishGermanTranslator, Thai);

                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Telugu")) {
                Telugu =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.TELUGU)
                                .build();
                TeluguenglishGermanTranslator =
                        Translation.getClient(Telugu);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                TeluguenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(TeluguenglishGermanTranslator, Telugu);

                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            } else if (text.contains("Tamil")) {
                Tamil =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.TAMIL)
                                .build();
                TamilenglishGermanTranslator =
                        Translation.getClient(Tamil);
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();
                TamilenglishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(
                                new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Tranas(TamilenglishGermanTranslator, Tamil);
                                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                            @Override
                                            public void onInit(int status) {
                                                if (status == TextToSpeech.SUCCESS) {

                                                    result = t1.setLanguage(new Locale(s));


                                                    if (result == TextToSpeech.LANG_MISSING_DATA
                                                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                                        Log.d("textllflfl", "This Language is not supported");
                                                    }
                                                } else {
                                                    Log.d("textdddfdsf", "Initilization Failed!");
                                                }

                                            }
                                        });
                                    }


                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                        // Model couldn’t be downloaded or other internal error.
                                        // ...
                                    }
                                });
            }


        } else {
            language.setClickable(true);
            language.setEnabled(true);
            progress.setVisibility(View.GONE);
            tvtxt.setText(t2);
        }


    }

    private void DownlaodModels() {
        Spanish =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.SPANISH)
                        .build();
        SpanishenglishGermanTranslator =
                Translation.getClient(Spanish);
        DownloadConditions conditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        SpanishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        Hebrew =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.HEBREW)
                        .build();
        HebrewenglishGermanTranslator =
                Translation.getClient(Hebrew);

        HebrewenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Hindi =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.HINDI)
                        .build();
        HindienglishGermanTranslator =
                Translation.getClient(Hindi);

        HindienglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Croatian =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.CROATIAN)
                        .build();
        CroatianenglishGermanTranslator =
                Translation.getClient(Croatian);

        CroatianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Haitian =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.HAITIAN_CREOLE)
                        .build();
        HaitianenglishGermanTranslator =
                Translation.getClient(Haitian);

        HaitianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Hungarian =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.HUNGARIAN)
                        .build();
        HungarianenglishGermanTranslator =
                Translation.getClient(Hungarian);

        HungarianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Indonesian =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.INDONESIAN)
                        .build();
        IndonesianenglishGermanTranslator =
                Translation.getClient(Indonesian);

        IndonesianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Icelandic =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.ICELANDIC)
                        .build();
        IcelandicenglishGermanTranslator =
                Translation.getClient(Icelandic);

        IcelandicenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Italian =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.ITALIAN)
                        .build();
        ItalianenglishGermanTranslator =
                Translation.getClient(Italian);

        ItalianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Japanese =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.JAPANESE)
                        .build();
        JapaneseenglishGermanTranslator =
                Translation.getClient(Japanese);

        JapaneseenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GEORGIAN)
                        .build();
        englishGermanTranslator =
                Translation.getClient(options);

        englishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Kannada =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.KANNADA)
                        .build();
        KannadaenglishGermanTranslator =
                Translation.getClient(Kannada);

        KannadaenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Korean =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.KOREAN)
                        .build();
        KoreanenglishGermanTranslator =
                Translation.getClient(Korean);

        KoreanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        Finnish =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.FINNISH)
                        .build();
        FinnishenglishGermanTranslator =
                Translation.getClient(Finnish);

        FinnishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        French =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.FRENCH)
                        .build();
        FrenchenglishGermanTranslator =
                Translation.getClient(French);

        FrenchenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Irish =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.IRISH)
                        .build();
        IrishenglishGermanTranslator =
                Translation.getClient(Irish);

        IrishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Galician =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GALICIAN)
                        .build();
        GalicianenglishGermanTranslator =
                Translation.getClient(Galician);

        GalicianenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Gujarati =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GUJARATI)
                        .build();
        GujaratienglishGermanTranslator =
                Translation.getClient(Gujarati);

        GujaratienglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        EngtoRussianoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.RUSSIAN)
                        .build();
        englishRussianTranslator =
                Translation.getClient(EngtoRussianoptions);

        englishRussianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        EngtoAfrikaansptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.AFRIKAANS)
                        .build();
        englishAfrikaansTranslator =
                Translation.getClient(EngtoAfrikaansptions);

        englishAfrikaansTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();


                            }
                        });

        Arabicoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.ARABIC)
                        .build();
        englishArabicTranslator =
                Translation.getClient(Arabicoptions);

        englishArabicTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        Belarusianoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.BELARUSIAN)
                        .build();
        BelarusianTranslator =
                Translation.getClient(Belarusianoptions);

        BelarusianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Bulgarianoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.BULGARIAN)
                        .build();
        BulgarianTranslator =
                Translation.getClient(Bulgarianoptions);

        BulgarianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Catalan =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.CATALAN)
                        .build();
        CatalanenglishGermanTranslator =
                Translation.getClient(Catalan);

        CatalanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Czech =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.CZECH)
                        .build();
        CzechenglishGermanTranslator =
                Translation.getClient(Czech);

        CzechenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Welsh =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.WELSH)
                        .build();
        WelshenglishGermanTranslator =
                Translation.getClient(Welsh);

        WelshenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Danish =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.DANISH)
                        .build();
        DanishenglishGermanTranslator =
                Translation.getClient(Danish);

        DanishenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        German =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GERMAN)
                        .build();
        GermanenglishGermanTranslator =
                Translation.getClient(German);

        GermanenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Greek =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GREEK)
                        .build();
        GreekenglishGermanTranslator =
                Translation.getClient(Greek);

        GreekenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        Esperanto =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.ESPERANTO)
                        .build();
        EsperantoenglishGermanTranslator =
                Translation.getClient(Esperanto);

        EsperantoenglishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ScanResult.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


    }

    public void Tranas(Translator englishTurkishTranslator, TranslatorOptions engtoRussianoptions) {
        if (englishTurkishTranslator != null) {
            filterText.setText(t);
            englishTurkishTranslator.translate(txt)
                    .addOnSuccessListener(
                            new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    tvtxt.setText(o.toString());
                                    progress.setVisibility(View.GONE);
                                    englishTurkishTranslator.close();

                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    progress.setVisibility(View.GONE);
                                    englishTurkishTranslator.close();

                                    // Error.
                                    // ...
                                }
                            });
//            if (options != null) {
//                Translator translator = Translation.getClient(options);
//                getLifecycle().addObserver(translator);
//
//            }
        } else {
            progress.setVisibility(View.GONE);

            Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void TranasPer() {
        if (englishPersianTranslator != null) {
            filterText.setText(t);
            englishPersianTranslator.translate(txt)
                    .addOnSuccessListener(
                            new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    tvtxt.setText(o.toString());
                                    progress.setVisibility(View.GONE);

                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    progress.setVisibility(View.GONE);
                                    englishGermanTranslator.close();

                                    // Error.
                                    // ...
                                }
                            });
//            if (options != null) {
//                Translator translator = Translation.getClient(options);
//                getLifecycle().addObserver(translator);
//
//            }
        } else {
            progress.setVisibility(View.GONE);

            Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void TranasUrdu() {
        if (englishUrduTranslator != null) {
            filterText.setText(t);
            englishUrduTranslator.translate(txt)
                    .addOnSuccessListener(
                            new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    tvtxt.setText(o.toString());
                                    progress.setVisibility(View.GONE);

                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    language.setClickable(true);
                                    language.setEnabled(true);
                                    progress.setVisibility(View.GONE);

                                    // Error.
                                    // ...
                                }
                            });
//            if (options != null) {
//                Translator translator = Translation.getClient(options);
//                getLifecycle().addObserver(translator);
//
//            }
        } else {
            progress.setVisibility(View.GONE);

            Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
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
                    generatePDf(ScanResult.this, System.currentTimeMillis() + "PDF", txt);

                }


            }
        } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE2) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                // Set text view with string

                if (returnString != null && returnString.contains("ok")) {
                    txt = getIntent().getStringExtra("txt");
                    generateNoteOnSD(ScanResult.this, System.currentTimeMillis() + "Notes", txt);

                }


            }
        }

    }

    public void AvailOffer(String text, String s) {
        String url = "https://translate-plus.p.rapidapi.com/translate";

        language.setEnabled(false);
        language.setClickable(false);
        progress.setVisibility(View.VISIBLE);

        if (dialogLan.isShowing()) {
            dialogLan.dismiss();
        }

        JSONObject notifications = new JSONObject();

        try {
            notifications.put("text", tvtxt.getText().toString().trim());
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
                        try {
                            language.setClickable(true);
                            language.setEnabled(true);
                            progress.setVisibility(View.GONE);
                            progress.setVisibility(View.GONE);
                            detectLanCode = s;
                            filterText.setText(text);
                            JSONObject obj = response.getJSONObject("translations");
                            String text = obj.getString("translation");
                            tvtxt.setText(text);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        language.setClickable(true);
                        language.setEnabled(true);
                        progress.setVisibility(View.GONE);
                        progress.setVisibility(View.GONE);
                        if (error != null) {
                            Log.d("Error", error.toString());
                        }
                        try {
                            Log.d("Error", error.getLocalizedMessage());
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }

                        Toast.makeText(ScanResult.this, "Try again later!", Toast.LENGTH_SHORT).show();
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

    private void showRatingDialog() {
        com.google.android.play.core.tasks.Task<ReviewInfo> reviewInfoTask = reviewManager.requestReviewFlow();

        reviewInfoTask.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ReviewInfo reviewInfo = task.getResult();
                com.google.android.play.core.tasks.Task<Void> flow = reviewManager.launchReviewFlow(this, reviewInfo);
                flow.addOnCompleteListener(reviewFlowTask -> {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                    Toast.makeText(getApplicationContext(), "Rating Dialog Opened", Toast.LENGTH_LONG).show();
                });
            } else {
                // Error handling
                Toast.makeText(getApplicationContext(), "Rating Dialog Not Opened", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

       AdsManager.showInterstitialWithInterval(this, new AdsCallBack() {
           @Override
           public void onClosed() {

           }
       });
    }
}
