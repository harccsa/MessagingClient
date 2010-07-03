package hu.messaging.client;

import java.awt.TextArea;

import com.ericsson.icp.IProfileListener;
import com.ericsson.icp.IProfile.State;
import com.ericsson.icp.util.ErrorReason;

public class ProfileAdapter extends BaseAdapter implements IProfileListener {

	public ProfileAdapter(TextArea logArea) {
		super(logArea);
	}

	@Override
	public void processEvent(String event, String source, ErrorReason reasonCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processStateChanged(State state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processError(ErrorReason error) {
		// TODO Auto-generated method stub

	}

}
