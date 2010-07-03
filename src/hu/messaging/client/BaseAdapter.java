
package hu.messaging.client;

import java.awt.TextArea;

import com.ericsson.icp.util.ErrorReason;

public class BaseAdapter {
	
    private TextArea logArea;

    protected BaseAdapter(TextArea logArea){
    	this.logArea = logArea;
    }

    public void processError(ErrorReason aError){
        logArea.setText("processError: " + aError.getReasonString());
    }
    
    public void log(String message)  {
    	logArea.append(message + "\r\n");
    }
    
}
