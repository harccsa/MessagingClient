package hu.messaging.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.ericsson.icp.ICPFactory;
import com.ericsson.icp.IPlatform;
import com.ericsson.icp.IProfile;
import com.ericsson.icp.IService;
import com.ericsson.icp.ISession;
import com.ericsson.icp.util.ISessionDescription;
import com.ericsson.icp.util.ITimeDescription;
import com.ericsson.icp.util.SdpFactory;

public class Client {
	
	private IPlatform platform = null;
	private IProfile profile = null;
	private IService service = null;
	private ISession session = null;
	
	private TextArea logArea = new TextArea();
	 
	private boolean done;

	private void initICP() {
		try {
			platform = ICPFactory.createPlatform();
			platform.registerClient("MessagingClient");
			platform.addListener(new PlatformAdapter(logArea));
			profile = platform.createProfile("IMSSetting");
			profile.addListener(new ProfileAdapter(logArea));
			
			service = profile.createService("+g.messagingclient", "messageClientApp");
			service.addListener(new ServiceAdapter(logArea));
			
			session = service.createSession();
			System.out.println(session.getState());
			System.out.println(session.isValid());
			session.addListener(new SessionAdapter(logArea));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disposeICP() {
		
		try {
			session.release();
			service.release();
			profile.release();
			platform.release();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private Frame createGui() {
		final Frame frame = new Frame();
       frame.setLayout(new GridBagLayout());
     
       Button messageButton = new Button("sendTestMessage");
       Button inviteButton = new Button("Invite");
       Button clearButton = new Button("Clear");
       
       messageButton.addActionListener(new ActionListener()   {
           public void actionPerformed(ActionEvent e) {
       			sendMessage();
           }
       });
       
       inviteButton.addActionListener(new ActionListener()   {
           public void actionPerformed(ActionEvent e) {
       			sendInvite();
           }
       });
       
       clearButton.addActionListener(new ActionListener()   {
           public void actionPerformed(ActionEvent e) {
        	   logArea.setText("");
           }
       });
       
       Panel mainPanel = new Panel();
       mainPanel.setLayout(new BorderLayout());
       Panel buttonPanel = new Panel();
       buttonPanel.add(messageButton);
       buttonPanel.add(inviteButton);
       buttonPanel.add(clearButton);
       mainPanel.add(buttonPanel, BorderLayout.NORTH);
       mainPanel.add(logArea, BorderLayout.CENTER);
       frame.add(mainPanel);
     
       frame.setSize(new Dimension(500, 500));
       frame.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent e)
           {
               done = true;
           }
       });
       
		return frame;
	}
	
	private ISessionDescription createLocalSdp()    {
       ISessionDescription localSdp = null;
       try
       {
           localSdp = SdpFactory.createSessionDescription("");
           localSdp.setField(ISessionDescription.FieldType.ProtocolVersion, "0");
           localSdp.setField(ISessionDescription.FieldType.Owner, "- 1111551202156 1111551202156 IN IP4");
           localSdp.setField(ISessionDescription.FieldType.SessionName, "TestAppSession");
           ITimeDescription timeDescription = SdpFactory.createTimeDescription();
           timeDescription.setSessionActiveTime("0 0");
           localSdp.addTimeDescription(timeDescription);
       }
       catch (Exception e)
       {
       	e.printStackTrace();
       }
       return localSdp;
   }
   
	public void sendInvite() {        
		try {
		
			ISessionDescription desc = createLocalSdp();
			logArea.append("send INVITE to: " + profile.getIdentity() + "\n");
			session.start("sip:alice@ericsson.com", desc, profile.getIdentity(), SdpFactory.createIMSContentContainer());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMessage() {
		String msg = new String("MSG FROM CLIENT");
		
		logArea.append("send MESSAGE to alice: " + msg + "\n");
		
		try {
			service.sendMessage("sip:alice@ericsson.com", "sip:alice@ericsson.com", "text/plain", msg.getBytes(), msg.length() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		initICP();
	//	sendMessage();
		Frame frame = createGui();
	    frame.setVisible(true);
	    
	    while (!done)
       {
           try
           {
               Thread.sleep(10);
           }
           catch (InterruptedException e1)
           {
           }
       }
	    
	    frame.setVisible(false);
	    frame.dispose();
		disposeICP();
	}

	public static void main(String[] args) throws Exception {
		Client messagingClient = new Client();
		messagingClient.run();
	}

}
