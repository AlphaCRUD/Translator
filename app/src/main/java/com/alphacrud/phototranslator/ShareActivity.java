package com.alphacrud.phototranslator;

import static android.content.ContentValues.TAG;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.alphacrud.phototranslator.Adapter.LanguageAdapter;
import com.alphacrud.phototranslator.Model.LanguageModel;
import com.alphacrud.phototranslator.ads.AdsCallBack;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ShareActivity extends AppCompatActivity {
    String txt;
    ArrayList<LanguageModel> list;
    String t2;
    private int result;
    private ProgressDialog progressDialog;
    private Dialog dialogLan;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 3;
    private static final int SECOND_ACTIVITY_REQUEST_CODE2 = 4;
    String detectLanCode = "en";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);


        AdsManager.loadNativeAd(this, findViewById(R.id.llNativeLarge), R.layout.ad_unified_medium);


        ViewGroup linearsahre = findViewById(R.id.linearsahre);
        ViewGroup linearDoc = findViewById(R.id.linearDoc);

// Custom animation speed or duration.
        // Declaring the animation view

        linearsahre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share2(txt);
            }
        });
        linearDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogsss();
            }
        });

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
//        Telugu = new TranslatorOptions.Builder()
//                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                .setTargetLanguage(TranslateLanguage.TELUGU)
//                .build();
//        TeluguenglishGermanTranslator =
//                Translation.getClient(Telugu);
//        DownloadConditions conditions = new DownloadConditions.Builder()
//                .requireWifi()
//                .build();
//        TeluguenglishGermanTranslator.downloadModelIfNeeded(conditions)
//                .addOnSuccessListener(
//                        new OnSuccessListener() {
//                            @Override
//                            public void onSuccess(Object o) {
//
//                            }
//
//
//                        })
//                .addOnFailureListener(
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(ShareActivity.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                // Model couldn’t be downloaded or other internal error.
//                                // ...
//                            }
//                        });
//
//        EngtoUrduoptions =
//                new TranslatorOptions.Builder()
//                        .setSourceLanguage(TranslateLanguage.ENGLISH)
//                        .setTargetLanguage(TranslateLanguage.URDU)
//                        .build();
//        englishUrduTranslator =
//                Translation.getClient(EngtoUrduoptions);
//
//        englishUrduTranslator.downloadModelIfNeeded(conditions)
//                .addOnSuccessListener(
//                        new OnSuccessListener() {
//                            @Override
//                            public void onSuccess(Object o) {
//
//                            }
//
//
//                        })
//                .addOnFailureListener(
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(ShareActivity.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                // Model couldn’t be downloaded or other internal error.
//                                // ...
//                            }
//                        });
//
//
//        EngtoPersianoptions =
//                new TranslatorOptions.Builder()
//                        .setSourceLanguage(TranslateLanguage.ENGLISH)
//                        .setTargetLanguage(TranslateLanguage.PERSIAN)
//                        .build();
//        englishPersianTranslator =
//                Translation.getClient(EngtoPersianoptions);
//
//        englishPersianTranslator.downloadModelIfNeeded(conditions)
//                .addOnSuccessListener(
//                        new OnSuccessListener() {
//                            @Override
//                            public void onSuccess(Object o) {
//
//
//                            }
//                        })
//                .addOnFailureListener(
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(ShareActivity.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                // Model couldn’t be downloaded or other internal error.
//                                // ...
//                            }
//                        });
//
//
//        EngTurkoptions =
//                new TranslatorOptions.Builder()
//                        .setSourceLanguage(TranslateLanguage.ENGLISH)
//                        .setTargetLanguage(TranslateLanguage.TURKISH)
//                        .build();
//        englishTurkishTranslator =
//                Translation.getClient(EngTurkoptions);
//
//        englishTurkishTranslator.downloadModelIfNeeded(conditions)
//                .addOnSuccessListener(
//                        new OnSuccessListener() {
//                            @Override
//                            public void onSuccess(Object o) {
//
//
//                            }
//
//
//                        })
//                .addOnFailureListener(
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(ShareActivity.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                // Model couldn’t be downloaded or other internal error.
//                                // ...
//                            }
//                        });
//
//        EngtoChineseoptions =
//                new TranslatorOptions.Builder()
//                        .setSourceLanguage(TranslateLanguage.ENGLISH)
//                        .setTargetLanguage(TranslateLanguage.CHINESE)
//                        .build();
//        englishChineseTranslator =
//                Translation.getClient(EngtoChineseoptions);
//
//        englishChineseTranslator.downloadModelIfNeeded(conditions)
//                .addOnSuccessListener(
//                        new OnSuccessListener() {
//                            @Override
//                            public void onSuccess(Object o) {
//                            }
//
//
//                        })
//                .addOnFailureListener(
//                        new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(ShareActivity.this, "" + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//
//                                // Model couldn’t be downloaded or other internal error.
//                                // ...
//                            }
//                        });


//        MyApplication.DownlaodModels();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        txt = getIntent().getStringExtra("txt");
        t2 = txt;
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


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

                                } else {
                                    Log.i(TAG, "Language: " + languageCode);
                                    detectLanCode = languageCode;
                                    if (list.size() > 0) {
                                        for (int i = 0; i < list.size(); i++) {
                                            if (detectLanCode.contains(list.get(i).getShortCode())) {
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


//        Trans.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


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
    }


    private void DialgLanguage() {
        dialogLan = new Dialog(ShareActivity.this);
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



    private void Dialogsss() {
        final Dialog dialog = new Dialog(ShareActivity.this);
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
                generateNoteOnSD(ShareActivity.this, System.currentTimeMillis() + "Notes", txt);
//                Intent in = new Intent(ShareActivity.this, Adds.class);
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
                generateDoc(ShareActivity.this, System.currentTimeMillis() + "Doc", txt);
            }
        });
        linearPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = getIntent().getStringExtra("txt");
                if (ContextCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ShareActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
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
//                    generatePDf(ShareActivity.this, System.currentTimeMillis() + "PDF", txt);

                }

//                Intent in = new Intent(ShareActivity.this, Adds.class);
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
//            openFile(ShareActivity.this,gpxfile);
            previewPdf(ShareActivity.this, gpxfile);
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
//            openFile(ShareActivity.this,gpxfile);
            previewPdf(ShareActivity.this, gpxfile);
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

//            openFile(ShareActivity.this,gpxfile);
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

                    previewPdf2(ShareActivity.this, gpxfile);

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
                    Toast.makeText(ShareActivity.this, "Error!", Toast.LENGTH_SHORT).show();
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

        WebView webView = new WebView(ShareActivity.this);
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
                "<p>" + txt + "" +
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
//            Toast.makeText(ShareActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
    private void Share(String link) {
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
            Toast.makeText(ShareActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

                                    PrintManager printManager = (PrintManager) ShareActivity.this.getSystemService(Context.PRINT_SERVICE);
                                    String jobName = "Photo Translator PDF" + System.currentTimeMillis();
                                    PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);
                                    if (printManager != null) {
                                        PrintAttributes.Builder builder = new PrintAttributes.Builder();
                                        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
                                        printManager.print(jobName, printAdapter, builder.build());
                                    } else {
                                        Toast.makeText(ShareActivity.this, "Error!", Toast.LENGTH_SHORT).show();
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
                                        PdfPrint pdfPrint = new PdfPrint(attributes, ShareActivity.this);
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
                                        Toast.makeText(ShareActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(ShareActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };






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
                    generatePDf(ShareActivity.this, System.currentTimeMillis() + "PDF", txt);

                }


            }
        } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE2) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                // Set text view with string

                if (returnString != null && returnString.contains("ok")) {
                    txt = getIntent().getStringExtra("txt");
                    generateNoteOnSD(ShareActivity.this, System.currentTimeMillis() + "Notes", txt);

                }


            }
        }

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
