package hu.messaging.client;

import java.awt.TextArea;
import java.io.UnsupportedEncodingException;

import com.ericsson.icp.ISessionListener;
import com.ericsson.icp.util.ErrorReason;
import com.ericsson.icp.util.IMSContentContainer;
import com.ericsson.icp.util.ISessionDescription;

public class SessionAdapter extends BaseAdapter implements ISessionListener
{
    public SessionAdapter(TextArea logArea) {
    	super(logArea);
    }

    public void processSessionStarted(ISessionDescription aSdpBody)
    {
        log("processSessionStarted");
    }

    public void processSessionEnded()
    {
        log("processSessionEnded");
    }

    public void processSessionCancelled()
    {
        log("processSessionCancelled");
    }

    public void processSessionStartFailed(ErrorReason aReasonCode, long retryAfter)
    {
        log("processSessionStartFailed");
    }

    public void processSessionUpdateSuccessful(ISessionDescription aSdpBody)
    {
        log("processSessionUpdateSuccessful");
    }

    public void processSessionUpdateFailed(ErrorReason aReasonCode, long retryAfter)
    {
        log("processSessionUpdateFailed");
    }

    public void processSessionAlerting()
    {
        log("processSessionAlerting");
    }

    public void processSessionInformation(String aContentType, byte[] aBody, int aLength)
    {
        log("processSessionInformation");
    }

    public void processSessionInformationSuccessful(String aContentType, byte[] aBody, int aLength)
    {
        log("processSessionInformationSuccessful");
    }

    public void processSessionInformationFailed(ErrorReason aReasonCode, long retryAfter)
    {
        log("processSessionInformationFailed");
    }

    public void processSessionMessage(String aContentType, byte[] aMessage, int aLength)
    {
        String message;
        try
        {
            message = "Remote: " + new String(aMessage, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            message = "Cannot decode message!";
        }
        System.out.println("SessionAdapter.processMessage: " + message);
    }

    public void processSessionMessageSuccessful(String aContentType, byte[] aBody, int aLength)
    {
        log("processSessionMessageSuccessful");
    }

    public void processSessionMessageFailed(ErrorReason aReason, long retryAfter)
    {
        log("processSessionMessageFailed");
    }

    public void processSessionInvitation(String aFrom, boolean aProvisionalRequired, ISessionDescription aSdpBody, IMSContentContainer aContainer)
    {
        log("processSessionInvitation");
    }

    public void processSessionUpdate(ISessionDescription aSdpBody)
    {
        log("processSessionUpdate");
    }

    public void processSessionSubscribeSuccessful(String aEvent, String aContentType, byte[] aContent, int aLength)
    {
        log("processSessionSubscribeSuccessful");
    }

    public void processSessionSubscribeFailed(String aEvent, String aContentType, byte[] aContent, int aLength, ErrorReason aReason, long retryAfter)
    {
        log("processSessionSubscribeFailed");
    }

    public void processSessionSubscribeDeactived(String aEvent, String aContentType, byte[] aContent, int aLength)
    {
        log("processSessionSubscribeDeactived");
    }

    public void processSessionSubscribeNotification(String aEvent, String aContentType, byte[] aContent, int aLength)
    {
        log("processSessionSubscribeNotification");
    }

    public void processSessionMediaNegotiation(ISessionDescription aSdpBody)
    {
        log("processSessionMediaNegotiation");
    }

    public void processSessionOptionsSuccessful(String aContentType, ISessionDescription aSdpBody)
    {
        log("processSessionOptionsSuccessful");
    }

    public void processSessionOptionsFailed(ErrorReason aReason, long retryAfter)
    {
        log("processSessionOptionsFailed");
    }

    public void processSessionOptions(String aContentType, ISessionDescription aSdpBody)
    {
        log("processSessionOptions");
    }

    public void processSessionRefer(String aReferTo, String aContentType, byte[] aBody, int aLength)
    {
        log("processSessionRefer");
    }

    public void processSessionReferSuccessful(String aReferTo)
    {
        log("processSessionReferSuccessful");
    }

    public void processSessionReferFailed(String aReferTo, ErrorReason aReasonCode, long retryAfter)
    {
        log("processSessionReferFailed");
    }

    public void processSessionReferNotify(String aReferTo, int aReferenceState, String aSubscriptionState)
    {
        log("processSessionReferNotify");
    }

    public void processSessionReferNotifySuccessful(String aReferTo)
    {
        log("processSessionReferNotifySuccessful");
    }

    public void processSessionReferNotifyFailed(String aReferTo, ErrorReason aReasonCode, long retryAfter)
    {
        log("processSessionReferNotifyFailed");
    }

    public void processSessionReferEnded(String aReferTo)
    {
        log("processSessionReferEnded");
    }

    public void processSessionPublishFailed(String aEvent, byte[] aState, int aLength, ErrorReason aReason, long retryAfter)
    {
        log("processSessionPublishFailed");
    }

    public void processSessionPublishSuccessful(String aEvent, int aReturnedExpires, byte[] aState, int aLength)
    {
        log("processSessionPublishSuccessful");
    }

    public void processSessionReceivedPRACK(ISessionDescription aSdpBody)
    {
        log("processSessionReceivedPRACK");
    }

    public void processSessionReceivedPRACKResponse(ISessionDescription aSdpBody)
    {
        log("processSessionReceivedPRACKResponse");
    }
}
