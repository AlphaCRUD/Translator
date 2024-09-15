package com.alphacrud.phototranslator;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class privacy_policy extends AppCompatActivity {

    private boolean Minimize = true, Lock = false;
    TextView c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        c1 = findViewById(R.id.c1);

        String s = "<h1>Privacy Policy</h1>\n" +
                "This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service. If you want to use this photo translator app Services, then be consistent with the collection and use of information in relation to this policy. The Personal Information which is collected from you is used for providing and improving the Service for you. we will never disclose your personal information or nor share your information with anyone except as described in this Privacy Policy.\n" +
                "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions. \n" +
                "<h3>Information we Collect and Use</h3>\n" +
                "For a better experience, while using our app Services, we may require you to provide us with certain personal information, including but not limited to Internet, Camera, Storage Permission. The information that we request will be retained on your device and is not collected by us in any way.\n" +
                "<h3>This application does not use third party services that may collect information used to identify you. </h3>\n" +
                "Link to privacy policy of third-party service providers used by the app\n" +
                "- Google Play Services \n" +
                "<h3>Log Data</h3>\n" +
                "When you use our Services, in case of an error, we collect data and information (through third-party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics.\n" +
                "<h3>Cookies</h3>\n" +
                "A cookie is a text file containing a small amount of data that is commonly used to identify an anonymous user. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.\n" +
                "Our Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collect information to improve their services. Cookies can either be accepted or refused, and you will be notified when one is sent. If you choose to refuse cookies, you may not be able to use some portions of this app Service.\n" +
                "<h3>CHILDREN’S PRIVACY</h3>\n" +
                "Our application is not intended for children under the age of 13. Therefore, we do not knowingly collect or solicit any personal information from children under 13. No one under age 13 may provide any personal information to the App. If you are under 13, do not use or provide any information on this App or through any of its features. Do not provide any information about yourself, including your email address. If we learn that we have collected personal information from a child under age 13 without verification of parental consent, we will erase that information as quickly as possible. If you believe that we might have any information from or about a child under 13, please contact us.\n" +
                "<h3>HOW TO CONTACT US</h3>\n" +
                "If you have any questions about this Privacy Policy, please feel free to contact us via support......................\n" +
                "\n";
        c1.setText(Html.fromHtml(s));


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
