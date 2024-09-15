package android.print;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class PdfPrint {

    public static final String TAG = "PdfPrint";
    public PrintAttributes printAttributes;
    private Context context;
    public int retry;

    public PdfPrint(PrintAttributes printAttributes, Context context) {
        this.printAttributes = printAttributes;
        this.context = context;
        retry = 0;
    }

    public void print(final PrintDocumentAdapter printAdapter, final File path, final String fileName) {
        printAdapter.onLayout(printAttributes, printAttributes, new CancellationSignal(), new PrintDocumentAdapter.LayoutResultCallback() {
            @Override
            public void onLayoutFailed(CharSequence error) {
                super.onLayoutFailed(error);
//                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent("PDF-STATUS");
                myIntent.putExtra("pdf_status", "fail");
                myIntent.putExtra("msg", "onLayoutFailed");
                context.sendBroadcast(myIntent);
            }

            @Override
            public void onLayoutCancelled() {
                super.onLayoutCancelled();
//                Toast.makeText(context, "onLayoutCancelled", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent("PDF-STATUS");
                myIntent.putExtra("pdf_status", "cancel");
                myIntent.putExtra("msg", "Process interrupted.");
                context.sendBroadcast(myIntent);
            }

            @Override
            public void onLayoutFinished(PrintDocumentInfo info, boolean changed) {
                writePdf(printAdapter, path, fileName);
//                printAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, getOutputFile(path, fileName), new CancellationSignal(), new PrintDocumentAdapter.WriteResultCallback() {
//                            @Override
//                            public void onWriteFinished(PageRange[] pages) {
//                                super.onWriteFinished(pages);
////                                Toast.makeText(context, "onWriteFinished", Toast.LENGTH_SHORT).show();
//                                Intent myIntent = new Intent("PDF-STATUS");
//                                myIntent.putExtra("pdf_status", "success");
//                                myIntent.putExtra("pdf_file_path", path.getAbsolutePath() + "/");
//                                myIntent.putExtra("pdf_file_name", fileName);
//                                context.sendBroadcast(myIntent);
//                            }
//
//                            @Override
//                            public void onWriteFailed(CharSequence error) {
//                                super.onWriteFailed(error);
//                                Toast.makeText(context, "onWriteFailed", Toast.LENGTH_SHORT).show();
//                                if (retry == 5) {
//                                    Intent myIntent = new Intent("PDF-STATUS");
//                                    myIntent.putExtra("pdf_status", "fail");
//                                    myIntent.putExtra("msg", "onWriteFailed");
//                                    context.sendBroadcast(myIntent);
//                                } else {
//                                    retry += 1;
//                                    print(printAdapter, path, fileName);
//                                }
//                            }
//
//                            @Override
//                            public void onWriteCancelled() {
//                                super.onWriteCancelled();
////                                Toast.makeText(context, "onWriteCancelled", Toast.LENGTH_SHORT).show();
//                                Intent myIntent = new Intent("PDF-STATUS");
//                                myIntent.putExtra("pdf_status", "cancel");
//                                myIntent.putExtra("msg", "Process interrupted.");
//                                context.sendBroadcast(myIntent);
//                            }
//                        }
//                );
            }
        }, null);
    }

    private void writePdf(final PrintDocumentAdapter printAdapter, final File path, final String fileName) {
        printAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, getOutputFile(path, fileName), new CancellationSignal(), new PrintDocumentAdapter.WriteResultCallback() {
                    @Override
                    public void onWriteFinished(PageRange[] pages) {
                        super.onWriteFinished(pages);
//                                Toast.makeText(context, "onWriteFinished", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent("PDF-STATUS");
                        myIntent.putExtra("pdf_status", "success");
                        myIntent.putExtra("pdf_file_path", path.getAbsolutePath() + "/");
                        myIntent.putExtra("pdf_file_name", fileName);
                        context.sendBroadcast(myIntent);
                    }

                    @Override
                    public void onWriteFailed(CharSequence error) {
                        super.onWriteFailed(error);
//                        Toast.makeText(context, "onWriteFailed", Toast.LENGTH_SHORT).show();
                        if (retry == 5) {
                            Intent myIntent = new Intent("PDF-STATUS");
                            myIntent.putExtra("pdf_status", "fail");
                            myIntent.putExtra("msg", "onWriteFailed");
                            context.sendBroadcast(myIntent);
                        } else {
                            retry += 1;
                            writePdf(printAdapter, path, fileName);
                        }
                    }

                    @Override
                    public void onWriteCancelled() {
                        super.onWriteCancelled();
//                                Toast.makeText(context, "onWriteCancelled", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent("PDF-STATUS");
                        myIntent.putExtra("pdf_status", "cancel");
                        myIntent.putExtra("msg", "Process interrupted.");
                        context.sendBroadcast(myIntent);
                    }
                }
        );
    }

    private ParcelFileDescriptor getOutputFile(File path, String fileName) {
        if (!path.exists()) {
            path.mkdirs();
        }
        File file = new File(path, fileName);
        try {
            file.createNewFile();
            return ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_WRITE);
        } catch (Exception e) {
            Log.e(TAG, "Failed to open ParcelFileDescriptor", e);
            Toast.makeText(context, "Failed to open ParcelFileDescriptor", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
