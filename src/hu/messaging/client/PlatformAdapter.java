package hu.messaging.client;

import java.awt.TextArea;

import com.ericsson.icp.IPlatformListener;
import com.ericsson.icp.util.ErrorReason;

public class PlatformAdapter extends BaseAdapter implements IPlatformListener {
	
	public PlatformAdapter(TextArea logArea) {
		super(logArea);
	}

	@Override
	public void processApplicationData(String application, byte[] data,
			int length) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processIncomingProfile(String profileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processPlatformTerminated(ErrorReason reasonCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processError(ErrorReason error) {
		// TODO Auto-generated method stub

	}

}
