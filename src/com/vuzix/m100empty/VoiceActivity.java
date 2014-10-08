package com.vuzix.m100empty;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.vuzix.m100empty.VoiceClass;
import com.vuzix.speech.VoiceControl;
import com.vuzix.speech.MainActivity;
import com.vuzix.speech.Constants;

public class VoiceActivity extends Activity {
	
	// create object of custom class extended from VoiceControl
	VoiceClass voice;
	
	// The VoiceControl object that enables/disables voice within an 
	// application and provides speech recognition.
	VoiceControl vc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voice);
		
		//voice = new VoiceClass(this);
		//voice.addGrammar(Constants.GRAMMAR_BASIC);
		
		// Create the VoiceControl object and pass it the context.
		vc = new VoiceControl(this)
		{
			@Override
			protected void onRecognition(String word) 
			{
				// Set the TextView to contain whatever word the recognition 
				// service picks up. It is important that the View is cast to
				// a TextView via parentheses before setText is called.
				((TextView)findViewById(R.id.voice_text)).setText(word);
			}
		};
		// Basic grammar is included by default.
	}

	
	public void onResume(){
		super.onResume();
		
		// Turn the VoiceControl on when the application resumes.
		//voice.on();
		vc.on();
	}
	public void onPause(){
		super.onPause();
		
		// Turn the VoiceControl off when the application pauses.
		//voice.off();
		vc.off();
	}
	public void onDestroy(){
		super.onDestroy();
		
		// Destroy the VoiceControl object when the application is done so that
		// it can be properly torn down.
		//voice.destroy();
		vc.destroy();
	}
}


/* Basic Grammar Words. 
 * 
 *  move left/right/up/down 			next 		previous 	forward 	halt 			select <#> 	
	go back/home/left/right/up/down 	cancel 		stop 		exit 		<show> menu 	volume up/down 
 	scroll left/right/up/down 			call 		dial 		hang up 	answer 			ignore 			
	call back 							contacts 	favorites 	pair 		unpair 			sleep 			
	set clock/time 						cut 		copy 		paste 		delete 			voice on/off 	
	complete							launch <#>	mute		confirm		end				redial			
	shut down							<#>			show help
 * 
*/

/* com.vuzix.speech.Constants.GRAMMAR_MEDIA
 * 
 *	play						stop				pause		fast forward			rewind			
	scan forward/back			step forward/back	record		next track/song/video	slow
	previous track/song/video	audio				subtitle	seek forward/back
*/

/* com.vuzix.speech.Constants.GRAMMAR_CAMERA
 * 
 *	focus	zoom in/out		take picture/video		start recording		stop recording
 */

/* com.vuzix.speech.Constants.NAVIGATION
 * 
 *	left				right				up		down	north		south			east
	west				turn left/right		drive	walk	map			satellite		street
	points of interest	address				city	state	zip code	post code		street view

 */

/* com.vuzix.speech.Constants.GRAMMAR_MEDICAL
 * 
 *	allergy		anatomy			arm			back		body			bone
	chest		chemist			disease		doctor		finger			foot
	hand		insurance		leg			medicine	muscle			nurse
	patient		pharmacist		pharmacy	physician	prescription	sick
	sickness	sprain			surgeon		surgery		toe
 */
