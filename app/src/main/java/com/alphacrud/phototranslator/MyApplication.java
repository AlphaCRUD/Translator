package com.alphacrud.phototranslator;

import android.app.Application;

import androidx.annotation.NonNull;

import com.alphacrud.phototranslator.Database.DatabaseAssist;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MyApplication extends Application {
    public static DatabaseAssist DA;
    public static boolean one = false, two = false, three = false;

    public static Translator englishGermanTranslator = null;
    public static Translator CroatianenglishGermanTranslator = null;
    public static Translator HebrewenglishGermanTranslator = null;
    public static Translator IrishenglishGermanTranslator = null;
    public static Translator CatalanenglishGermanTranslator = null;
    public static Translator BengalienglishGermanTranslator = null;
    public static Translator englishUrduTranslator = null;
    public static Translator englishPersianTranslator = null;
    public static Translator englishTurkishTranslator = null;
    public static Translator englishChineseTranslator = null;
    public static Translator englishRussianTranslator = null;
    public static Translator englishAfrikaansTranslator = null;
    public static Translator englishArabicTranslator = null;
    public static Translator BelarusianTranslator = null;
    public static Translator BulgarianTranslator = null;
    public static TranslatorOptions options = null;
    public static TranslatorOptions EngTurkoptions = null;
    public static TranslatorOptions EngtoUrduoptions = null;
    public static TranslatorOptions EngtoPersianoptions = null;
    public static TranslatorOptions EngtoChineseoptions = null;
    public static TranslatorOptions EngtoRussianoptions = null;
    public static TranslatorOptions EngtoAfrikaansptions = null;
    public static TranslatorOptions Arabicoptions = null;
    public static TranslatorOptions Belarusianoptions = null;
    public static TranslatorOptions Bulgarianoptions = null;
    public static TranslatorOptions Bengali = null;
    public static TranslatorOptions Telugu = null;
    public static TranslatorOptions Catalan = null;
    public static TranslatorOptions Czech = null;
    public static TranslatorOptions Marathi = null;
    public static TranslatorOptions Romanian = null;
    public static Translator CzechenglishGermanTranslator = null;
    public static Translator TeluguenglishGermanTranslator = null;
    public static TranslatorOptions Welsh = null;
    public static Translator WelshenglishGermanTranslator = null;
    public static TranslatorOptions Danish = null;
    public static Translator DanishenglishGermanTranslator = null;
    public static TranslatorOptions German = null;
    public static Translator GermanenglishGermanTranslator = null;
    public static TranslatorOptions Greek = null;
    public static Translator GreekenglishGermanTranslator = null;
    public static TranslatorOptions Esperanto = null;
    public static Translator EsperantoenglishGermanTranslator = null;
    public static TranslatorOptions Spanish = null;
    public static Translator SpanishenglishGermanTranslator = null;
    public static TranslatorOptions Estonian = null;
    public static Translator EstonianenglishGermanTranslator = null;
    public static TranslatorOptions Finnish = null;
    public static Translator FinnishenglishGermanTranslator = null;
    public static Translator MarathienglishGermanTranslator = null;
    public static TranslatorOptions French = null;
    public static TranslatorOptions Irish = null;
    public static TranslatorOptions Galician = null;
    public static TranslatorOptions Gujarati = null;
    public static TranslatorOptions Hebrew = null;
    public static TranslatorOptions Hindi = null;
    public static TranslatorOptions Croatian = null;
    public static TranslatorOptions Haitian = null;
    public static TranslatorOptions Indonesian = null;
    public static TranslatorOptions Icelandic = null;
    public static TranslatorOptions Hungarian = null;
    public static TranslatorOptions Japanese = null;
    public static TranslatorOptions Italian = null;
    public static TranslatorOptions Georgian = null;
    public static TranslatorOptions Kannada = null;
    public static TranslatorOptions Korean = null;
    public static TranslatorOptions Malay = null;
    public static TranslatorOptions Thai = null;
    public static TranslatorOptions Ukrainian = null;
    public static TranslatorOptions Tamil = null;

    public static TranslatorOptions Macedonian = null;
    public static Translator FrenchenglishGermanTranslator = null;
    public static Translator GalicianenglishGermanTranslator = null;
    public static Translator GujaratienglishGermanTranslator = null;
    public static Translator HindienglishGermanTranslator = null;
    public static Translator HaitianenglishGermanTranslator = null;
    public static Translator HungarianenglishGermanTranslator = null;
    public static Translator IndonesianenglishGermanTranslator = null;
    public static Translator IcelandicenglishGermanTranslator = null;
    public static Translator KoreanenglishGermanTranslator = null;
    public static Translator ItalianenglishGermanTranslator = null;
    public static Translator KannadaenglishGermanTranslator = null;
    public static Translator JapaneseenglishGermanTranslator = null;
    public static Translator MacedonianenglishGermanTranslator = null;
    public static Translator MalayenglishGermanTranslator = null;
    public static Translator RomanianenglishGermanTranslator = null;
    public static Translator ThaienglishGermanTranslator = null;
    public static Translator UkrainianenglishGermanTranslator = null;
    public static Translator TamilenglishGermanTranslator = null;


    @Override
    public void onCreate() {
        super.onCreate();
        AppOpenManager appOpenManager = new AppOpenManager(this);
    }

    public static void DownlaodModels() {
        Telugu = new TranslatorOptions.Builder()
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

                            }


                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        EngtoUrduoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.URDU)
                        .build();
        englishUrduTranslator =
                Translation.getClient(EngtoUrduoptions);

        englishUrduTranslator.downloadModelIfNeeded(conditions)
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

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        EngtoPersianoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.PERSIAN)
                        .build();
        englishPersianTranslator =
                Translation.getClient(EngtoPersianoptions);

        englishPersianTranslator.downloadModelIfNeeded(conditions)
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

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        EngTurkoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.TURKISH)
                        .build();
        englishTurkishTranslator =
                Translation.getClient(EngTurkoptions);

        englishTurkishTranslator.downloadModelIfNeeded(conditions)
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

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });

        EngtoChineseoptions =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.CHINESE)
                        .build();
        englishChineseTranslator =
                Translation.getClient(EngtoChineseoptions);

        englishChineseTranslator.downloadModelIfNeeded(conditions)
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

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


        Spanish =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.SPANISH)
                        .build();
        SpanishenglishGermanTranslator =
                Translation.getClient(Spanish);

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

                                // Model couldn’t be downloaded or other internal error.
                                // ...
                            }
                        });


    }

}

