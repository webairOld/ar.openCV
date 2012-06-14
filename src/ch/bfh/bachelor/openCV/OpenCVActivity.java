package ch.bfh.bachelor.openCV;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class OpenCVActivity extends Activity {
    private static final String TAG = "OpenCVActivity";
    private OpenCVView mView;

    public OpenCVActivity() {
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    @Override
	protected void onPause() {
        Log.i(TAG, "onPause");
		super.onPause();
		mView.releaseCamera();
	}

	@Override
	protected void onResume() {
        Log.i(TAG, "onResume");
        if( !mView.openCamera() ) {
        	Log.e(TAG,"Could not open camera");
        }
		super.onResume();

	}

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mView = new OpenCVView(this);
        setContentView(mView);
    }
}
