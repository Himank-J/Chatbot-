import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;
import java.util.*;
import java.io.*;



class ChatBot extends JFrame implements KeyListener,ActionListener{

	JPanel p=new JPanel();
	JButton b = new JButton("SPEAK");
	JTextArea dialog=new JTextArea(30,50);
	JLabel label=new JLabel("Hello I am Cyrus the Chatbot !!");
	JTextArea input=new JTextArea(("Enter text here"),1,50);
        JTextArea output=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	String[][] chatBot={
		
		{"hi","hello","hey"},
		{"Hi","Hello","Hey"},
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		{"are you cyrus","will you answer my questions","will you help me"},
		{"yes","yes!!"},
		{"tell me about coronavirus","what is the current topic","what is happening around the world"},
		{"Coronavirus disease (COVID-19) is an infectious disease caused by a "+"\n"+"\t"+"newly discovered coronavirus."+"Most people infected with the COVID-19 virus will"+"\n"+"\t"+"experience mild to moderate respiratory illness and recover without requiring special"+"\n"+"\t"+"treatment.  Older people, and those with underlying medical problems like"+"\n"+"\t"+"cardiovascular disease, diabetes, chronic respiratory disease, and cancer are"+"\n"+"\t"+"more likely to develop serious illness."},
		{"can you give me stats of covid-19 around the world","how many cases of coronavirus","how many deaths because of coronavirus"},
		{"YES! sure:"+"\n"+"\t"+"World:"+"\n"+"\t"+"Total cases:1,203,428"+"\t"+"Total deaths:64,754"
			+"\n"+"\t"+"USA:"+"\n"+"\t"+"Total cases:311,637"+"\t"+"Total deaths:8,454"
			+"\n"+"\t"+"Spain:"+"\n"+"\t"+"Total cases:126,168"+"\t"+"Total deaths:11,947"
			+"\n"+"\t"+"Italy:"+"\n"+"\t"+"Total cases:124,632"+"\t"+"Total deaths:15,362"
			+"\n"+"\t"+"Germany:"+"\n"+"\t"+"Total cases:96,092"+"\t"+"Total deaths:1,444"
			+"\n"+"\t"+"China:"+"\n"+"\t"+"Total cases:81,669"+"\t"+"Total deaths:3,329"
			+"\n"+"\t"+"India:"+"\n"+"\t"+"Total cases:3,588"+"\t"+"Total deaths:99	"
			+"\n"+"\t"+"You can visit https://www.worldometers.info/coronavirus/ to know more"
		},
		{"tell me something about football","what is football"},
		{"Football is a sport played by 2 teams on a ground that is rectangular in shape"+"\n"+"\t"+"and each team comprises of 11 players playing on the field."},
		{"who is the best player in football"},
		{"Cristiano Ronaldo has often been called the best in the  sport by many news articles,"+"\n"+"\t"+"magazines but side by side messi is said to be the GOAT(greatest of all time)."},
		{"who is going to win uefa champions league this season"},
		{"Even I want to know that,unfortunately football has been cancelled due to COVID-19"},
		{"please give me the name of my college","where do I study"},
		{"Symbiosis Institute of Technology"},
		{"what can you tell me about my college"},
		{"Symbiosis Institute of Technology or SIT is a constituent part of the"+"\n"+"\t"+"SIU(symbiosis international university lavale) that is engaged in the field of"+"\n"+"\t"+"engineering courses of various backgrounds(CS,IT,EN&TC,MECH,CIVIL)"+"\n"+"\t"+
		"Also undergraduate and post graduate courses are available in this college."},
		{"what are some famous places in sit","what are the best places of sit"},
		{"Here is what I found:"+"\n"+"\t"+
			"Sports complex(comprises of football,volleyball,tennis and  basketball field)"+"\n"+"\t"+
			"Symbi Eat(a separate building dedicated to the food services available in the college"+"\n"+"\t"+"where the day scholars can buy food)"+"\n"+"\t"+
			"Rangoli(one stop shop for all the junk and delicacies that students crave after having"+"\n"+"\t"+"a filling lunch)"
		},
		{"tell me the second year courses of a cs student"},
		{"The courses are as follows:"+"\n"+"\t"+
			"1.Java programming (best subject)"+"\n"+"\t"+
			"2.Data structures"+"\n"+"\t"+
			"3.Microprocessor techniques"+"\n"+"\t"+
			"4.Operating systems"+"\n"+"\t"+
			"5.Language electives"
		},
                {"what should i watch on netflix"},
                {"I could recommend some top content for you on netflix:"+"\n"+"\t"+
                        "MOVIES:"+"\n"+"\t"+
                            "1.Accepted"+"\n"+"\t"+
                            "2.Hall pass"+"\n"+"\t"+
                            "3.Pineapple Express"+"\n"+"\t"+
                            "4.Shutter Island"+"\n"+"\t"+
                            "5.6 Underground"+"\n"+"\t"+
                        "TV series:"+"\n"+"\t"+
                            "1.Riverdale"+"\n"+"\t"+
                            "2.Money Heist"+"\n"+"\t"+
                            "3.Blacklist"+"\n"+"\t"+
                            "4.Suits"+"\n"+"\t"+
                            "5.Breaking bad"},
                {"recommend some nice songs"},
                {"1.Blinding Lights by The Weeknd"+"\n"+"\t"+
                 "2.Intentions by Justin Beiber"+"\n"+"\t"+
                 "3.The box by Roddy Rich"+"\n"+"\t"+
                 "4.In your eyes"+"\n"+"\t"+
                 "5.Falling by trevor Daniel"},
		{"tell me about java programming","what is java programming"},
		{"Java programming is an advanced oop language is highly used in"+"\n"+"\t"+"full stack development(web font end and back end)"+"\n"+"\t"+
		"Not only that it has been one of the most highly used languages across the"+"\n"+"\t"+"globe for the past 25 years."},
		{"who developed you"},
		{"I was developed by three students of SIT:"+"\n"+"\t"+
			"1.Himank Jain"+"\n"+"\t"+
			"2.Aaryan Srivastava"+"\n"+"\t"+
			"3.Ayush Tiwari"
		},
		{"how were you developed"},
		{"I cant tell you everything about it because I dont want you to clone me!"+"\n"+"\t"+
			"but i cant tell you one thing, I was developed using JAVA programming using"+"\n"+"\t"+"the concepts of swing"},
		{"tell me a joke","i need something funny","make me laugh"},
		{"okay,but dont blame me if it aint funny,"+"\n"+"\t"+
			"Doctor:I'm sorry but you suffer from a terminal illness and have only 10 to live."+"\n"+"\t"+
			"Patient:What do you mean, 10? 10 what? Months? Weeks?!"+"\n"+"\t"+
			"Doctor: Nine.","okay,but dont blame me if it aint funny,"+"\n"+"\t"+
			"Why should you never date a tennis player?"+"\n"+"\t"+
			"Love means nothing to them!!"+"\n"+"\t"+
			"get it?","okay,but dont blame me if it aint funny,"+"\n"+"\t"+
			"Mike: Someone stole the wheels off of all the police cars!"+"\n"+"\t"+
			"Spike: The cops are working on it—tirelessly.","okay,but dont blame me if it aint funny,"+"\n"+"\t"+
			"What is the difference between a  poorly dressed man on a unicycle"+"\n"+"\t"+"and a well-dressed man on a bicycle?"+"\n"+"\t"+
			"Attire."+"\n"+"\t"+"get it?"
		},
		{"tell me something i dont know","give me a fact"},
		{"The length of movie TITANIC minus the present-day scenes and credits is same as amount of time it took the actual titanic to sink: 2hours 40 min",
			"The average person wastes 21.8 hours every week","Surgeons who play video games makes less mistake during surgery",
			"42069 occurs at the 250302th position of PI","Rolex advertisements always photograph their watches at 10:10:31",
			"The man on Pringles can is named Julius","The domain name googlesucks.com is owned by Google"
		},
		{"open calculator","calc","calculator","start calculator","i want to calculate","notepad","i want to make a note","note","open notepad","start notepad","open command prompt","open cmd","cmd","i want to make a presentation"},
		{"OK, give me a second","Application Started!","Sure, anything else?"},
		{"Browse Chrome","open google chrome","open chrome","search the web","open browser","search the internet"},
		{"Chrome Started!","Happy Surfing!","Chrome is running"},
		{"watch videos online","i want to submit assignments","check my email","translate for me","upload files on drive","check instagram","check business profile","search online"
		,"search images online"},
		{"Launching Now!","Just a moment please","Opening Website!","Done! Continue with your work. Let me know if I can do anything else."},
			
		//default
		{"Sorry cant answer that","I need time to find answer to your question","Ask later while I pass the question to my developers"}
	};
	
	
	
	
	public ChatBot(){
		super("Chat Bot");
		setSize(600,595);
		add(p,BorderLayout.CENTER);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("F:\\Chatbot.jpg");   
		setIconImage(icon);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
                output.addKeyListener(this);
	
		p.add(label);
		label.setForeground (Color.white);
		
		p.add(scroll);
		p.add(b);
		p.add(input);
                p.add(output);
		p.setBackground(new Color(0,0,153));
		add(p);
		
		setVisible(true);
                b.addActionListener(this);
	}
        @Override
        public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b) {
            Voice voice;
            voice = VoiceManager.getInstance().getVoice("kevin");
            if (voice != null) {
                voice.allocate();
            }
            try {
                voice.setRate(130);
                voice.setPitch(120);
                voice.setVolume(9); 
                voice.speak(output.getText());
 
 
            } catch (Exception e1) {
                e1.printStackTrace();
            }
 
        }
        }
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote=quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote=quote.trim();
			byte response=0;
			int j=0;
			while(response==0){
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n-->Cyrus:\t"+chatBot[(j*2)+1][r]);
                                        output.setText(chatBot[(j*2)+1][r]);
					try{
					if(quote.toLowerCase().contains("calc")){
						Runtime.getRuntime().exec("calc");
					}
					if(quote.toLowerCase().contains("note")){
						Runtime.getRuntime().exec("notepad");
					}
					
					if(quote.toLowerCase().contains("chrome") || quote.toLowerCase().contains("google") || quote.toLowerCase().contains("browser") || 
					quote.toLowerCase().contains("web") || quote.toLowerCase().contains("internet")){
								
						Runtime rt = Runtime.getRuntime();
						rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
					}
					if(quote.toLowerCase().contains("command prompt") || quote.toLowerCase().contains("cmd")){
					Runtime.getRuntime().exec("cmd");
					}
					if(quote.toLowerCase().contains("presentation"))
					{
						Runtime.getRuntime().exec("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.exe");
					}
						String url;
						Runtime run = Runtime.getRuntime();
						if(quote.toLowerCase().contains("videos")){
							url="youtube.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("assignments")){
							
							url="classroom.google.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("email")){
							url="gmail.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("translate")){
							url="translate.google.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("upload")){
							url="drive.google.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("business")){
							url="linkedin.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("instagram")){
							url="instagram.com";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("search online")){
							url="http://google.com/";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
						if(quote.toLowerCase().contains("search images online")){
							url="http://google.com/images";
							run.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",url});
						}
					
					}
					catch(IOException l){
						System.out.println(l);
					}
						
						
				}
				j++;
				if(j*2==chatBot.length-1 && response==0){
					response=1;
				}
			}
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->Cyrus:\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
			addText("\n");
			
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}

class user
{
	public static void main(String[] args){
		new ChatBot();
	}
}