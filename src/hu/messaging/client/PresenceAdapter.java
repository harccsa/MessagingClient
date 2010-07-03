package hu.messaging.client;

import java.awt.TextArea;

import com.ericsson.icp.services.PGM.IPresenceListener;
import com.ericsson.icp.util.ErrorReason;
import com.ericsson.icp.util.IIterator;
import com.ericsson.icp.util.IPresentity;

public class PresenceAdapter extends BaseAdapter implements IPresenceListener {

	public PresenceAdapter(TextArea logArea) {
		super(logArea);
	}

	@Override
	public void processAllowWatcherResult(boolean success) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processBlockWatcherResult(boolean success) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSubscribeNotification(String remote,
			IPresentity presentity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSubscribeResult(boolean status, String remote,
			String event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processUnsubscribeResult(boolean status, String remote,
			String event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processUpdatePresentityResult(boolean success) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processWatcherInfo(String remote, IIterator watcherIterator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processError(ErrorReason error) {
		// TODO Auto-generated method stub

	}

}
