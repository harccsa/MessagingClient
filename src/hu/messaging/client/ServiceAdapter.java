package hu.messaging.client;

import java.awt.TextArea;

import com.ericsson.icp.IServiceListener;
import com.ericsson.icp.ISession;
import com.ericsson.icp.util.ErrorReason;

public class ServiceAdapter extends BaseAdapter implements IServiceListener {

	public ServiceAdapter(TextArea logArea) {
		super(logArea);
	}

	@Override
	public void processIncomingSession(ISession session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMessage(String remote, String msgType, byte[] message, int length) {
		log("ServiceAdapter.processMessage: " + new String(message));

	}

	@Override
	public void processOptions(String preferedContact, String remote,
			String type, byte[] content, int length) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processPublishResult(boolean status, String remote,
			String event, long retryAfter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processRefer(String referID, String remote, String thirdParty,
			String contentType, byte[] content, int length) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processReferEnded(String referID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processReferNotification(String referId, int state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processReferNotifyResult(boolean status, String referID,
			long retryAfter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processReferResult(boolean status, String referId,
			long retryAfter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSendMessageResult(boolean status, long retryAfter) {
		// TODO Auto-generated method stub
		log("processSendMessageResult: " + status);
	}

	@Override
	public void processSendOptionsResult(boolean status,
			String preferedContact, String remote, String type, byte[] content,
			int length, long retryAfter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSubscribeEnded(String preferedContact, String remote,
			String event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSubscribeNotification(String remote, String contact,
			String event, String type, byte[] content, int length) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processSubscribeResult(boolean status, String remote,
			String event, long retryAfter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processUnsubscribeResult(boolean status, String remote,
			String event, long retryAfter) {

	}

	@Override
	public void processError(ErrorReason error) {
		// TODO Auto-generated method stub

	}

}
