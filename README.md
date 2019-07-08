# WannatalkAPI-Android
The official Wannatalk Messenger Android API
## To run sample example
1. Request **wannatalk-services.json** from wannatalk.co

2. Copy **wannatalk-services.json** file to sample application `assets` directory
<img src="Screenshots/Screenshot1.png" width="350">

3. That's it! Run the app

## Steps to integrate wannatalk library into your project

1. Download [wannatalk.aar](wannatalksdk/wannatalksdk.aar) and import into your application
2. Enable `multiDexEnabled` and add below `dependencies` in your application **build.gradle**
```
android {
	defaultConfig {
	    // Enabling multidex support.
	    multiDexEnabled true
	}
	...
}

dependencies 
{
	compile 'com.android.support:design:25.3.1'
	compile 'com.android.support:multidex:1.0.0'
	compile project(':wannatalksdk')  
	compile 'commons-io:commons-io:2.4'  
  
	compile 'com.github.bumptech.glide:glide:3.7.0'  
	compile 'jp.wasabeef:glide-transformations:2.0.1'  
  
	compile 'com.facebook.fresco:fresco:1.5.0'  
	compile 'com.facebook.fresco:animated-gif:1.5.0'  
	compile "com.android.support:support-core-utils:25.3.1"
    compile "com.android.support:customtabs:25.3.1"

  	compile 'com.google.guava:guava:23.0-android'  
	compile 'me.saket:better-link-movement-method:1.2'  
	compile 'com.arasthel:asyncjob-library:1.0.3'  
  
	compile 'com.squareup:otto:1.3.8'  
	compile 'com.squareup.retrofit2:retrofit:2.3.0'  
	compile 'com.squareup.retrofit2:converter-gson:2.0.2'  
	compile 'com.google.code.gson:gson:2.8.2'
}
``` 
3. Edit your manifest file to set android:name in the tag as follows:
```
<application		
		android:name="wannatalk.wannatalksdk.WTApplication">
		...
</application>
```
4. Copy  **wannatalk-services.json** file to your application assets directory
5. Add below line in **onCreate** function of your main activity
```
WTAppDataManager.InitializeSDK();
```
## To link Wannatalk account
    WTAppDataManager.StartLoginActivity(this);

## To link Wannatalk account without otp verification
    Bundle bundle = new Bundle();
    bundle.putString("key1", "value1");
    bundle.putString("key2", "value2");
    WTAppDataManager.SilentLoginActivity("your_phone_number", bundle, this);

## HelpDesk
### To load your organization profile
    // LoadOrganizationActivity(Activity activity, boolean autoOpenChat)
    // Recent chat page will be opened when click on channel if autoOpenChat is true, otherwise chat list page will be opened.
    
    WTAppDataManager.LoadOrganizationActivity(this, true);
    
## Collaboration
### To view all chats
    WTAppDataManager.LoadChatListActivity(this);
    
### To view all users
    WTAppDataManager.LoadUsersActivity(this);

## Push notifications
1. Create android app in Firebase console
2. Download google-services.json configuration file and move it into the same directory as your root-level build.gradle file. 
3. Share us your Firebase project server key. You will find it in Cloud messaging tab of your Firebase project settings.(Open project in Firebase > Project Settings > Cloud Messaging)

## Other
### Show or hide guide button
    WTAppDataManager.ShowGuideButton(false); // Default Value: true
    
### To show or hide Add Participants in chat item profile
    WTAppDataManager.AllowAddParticipants(false); // Default Value: true

### To show or hide microphone in chat page
    WTAppDataManager.AllowSendAudioMessage(false); // Default Value: true

### To show or hide welcome message
    WTAppDataManager.ShowWelcomeMessage(false); // Default Value: false
