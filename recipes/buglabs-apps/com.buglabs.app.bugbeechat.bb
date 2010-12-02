require bug-app.inc

DESCRIPTION = "BUG-to-BUG 'chat' sample application for the BUGbee module with some features for testing. Pressing hotkey 1 brings up the matchbox virtual keyboard. What you type will appear in the (sadly squished) upper text area, and when you press RETurn it will be sent to the other BUG.\
To use this app you need two BUG bases each with a BUGbee module. Create a file called '/home/root/chatboss' on one (and only one) of the BUGs, then deploy BUGBeeChat to them both. This file tells the app which instance should establish the PAN (there are better ways to do this but they aren't implemented yet).\
The latest version of BUGBeeChat on bugnet adds echo/ping functionality.\
As before, if BUGBeeChat finds a file called /home/root/chatboss when it starts, it will start as the coordinator, and if not it will start as an end device. So only one of the two bugs running BUGBeeChat should have that file.\
Now it also looks for /home/root/chatping and /home/root/chatecho when it starts up. If it finds chatecho, then every message it receives it will send a copy of back. If it finds chat ping then it will send out a message every 5 seconds (configurable by PING_DELAY at the top of BUGBeeChatApplication.java).\
To use this you would put the chatecho file on one of the bugs and the chatping file on the other - doesn't matter which is which. It comes in handy for doing range testing and stability testing. You can also put the chatping file on each BUG and not use the chatecho option.\
*NOTE:*\
The PA (Power Amplifier is enabled by default in the application). To avoid excessive rf power to the front end, the BUGbees should  be placed about 2 ft apart. In addition, to prevent data corruption, the units should be  operated with obstructions in between them if in a lab/office environment, or about 5-10 meters away from each other if in line of  sight.\
"
HOMEPAGE = "http://buglabs.net/applications/BUGBeeChat"

DEPENDS += "com.buglabs.bug.module.bugbee com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "15"

SRC_LINK = "http://buglabs.net/program_version/download/1002"

APIVERSION = ""
