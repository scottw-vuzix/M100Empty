package com.vuzix.m100empty;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.vuzix.m100empty.VoiceClass;
import com.vuzix.speech.VoiceControl;
import com.vuzix.speech.MainActivity;
import com.vuzix.speech.Constants;

public class VoiceActivity extends Activity {
	
	// create object of custom class extended from VoiceControl
	VoiceClass voice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voice);
		
		voice = new VoiceClass(this);
		voice.addGrammar(Constants.GRAMMAR_BASIC);
	}

	
	public void onResume(){
		super.onResume();
		voice.on();
		
	}
	public void onPause(){
		super.onPause();
		voice.off();
	}
	public void onDestroy(){
		super.onDestroy();
		voice.destroy();
	}
	

}


/*	Basic Grammar Words. 
 * 
 *  move left/right/up/down 	next 	previous 	forward 	halt 	select <#> 	complete 	launch <#>
	go back/home/left/right/up/down 	cancel 	stop 	exit 	<show> menu 	volume up/down 	mute 	confirm
 	scroll left/right/up/down 	call 	dial 	hang up 	answer 	ignore 	end 	redial
	call back 	contacts 	favorites 	pair 	unpair 	sleep 	shut down 	<#>
	set clock/time 	cut 	copy 	paste 	delete 	voice on/off 	show help 
 * 
*/

