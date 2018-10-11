# MicrosoftCodeFunDo
Project for Natural Disaster Management<br />
This project is basically divided into three stages:<br />
a) Predicting the occurrence of a natural disaster<br />
	Based on the dataset of previous calamities, we can draw similarities and try to predict the calamities which may occur in the near future. We use real time APIs like https://openweathermap.org/api for getting live data about weather. We are planning to get datasets regarding disasters from sites like https://bit.ly/2QIJ2VM, https://www.preventionweb.net/risk/datasets <br />
b) Helping the rescue teams to save more people <br />
	-> Detecting the occurrence of natural disasters through various sources like social media, news reports etc.<br />
	-> Sending the approximate location of all the mobile phones at the occurence of natural disasters to the Rescue     		Teams. This can be done using Android Location APIs. This step has to be done just before the occurrence of the 	   disaster as the network services may no longer be available post disaster and we will need the most recent location    	  of people. <br />
	-> Getting the exact location of the phone using bluetooth beacons. Beacons can be built using Android BLE packages( 		Bluetooth Low Energy). By implementing this and the previous step the rescue time will be able to determine the 	   exact location of the victim which is very crucial in the rescue efforts.<br />
c) Creating awareness towards conservation of our environment <br />
	-> Informing the users if their lifestyle is affecting the environment in a positive or negative manner and what 	    changes can be brought about by changing their lifestyle. For Example: If the person is using private vehicles when 	   there are easily available public transport options the app can give him a gentle reminder about how much resources 		  were wasted. This can create awareness.
	
Implementation: We are planning to build a android app as it is the most used mobile platform. Backend part will be done in Django.
