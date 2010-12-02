require bug-app.inc

DESCRIPTION = "h3. Presentation\
EMF logger is the application on the bug device taking care of the following 'electronic circuit':http://bugcommunity.com/wiki/index.php/EMF_Detector\
EMF detector uses a wire,a potentiometer and can detect 'EMF':http://en.wikipedia.org/wiki/Electromagnetic_field\
Many thanks to the author of 'VonHippelAnalogDemo':http://www.buglabs.net/applications/vonHippelAnalogDemo for writing his application and releasing it under the GPL\
h3. How it works\
Note that this application depends on 'com.buglabs.emulator.rxtx':http://www.buglabs.net/applications/com.buglabs.emulator.rxtx ,so install com.buglabs.emulator.rxtx before sending this application to your bug device\
For now you can edit some global variable,which activate or disactivate functions such as:\
* logging to file,and to which file you want to log to\
* logging to serial\
* cleaning /var/log/message logs(small kernel issue pollutes the logs)\
h3. Details\
For more details refer to the 'electronic circuit page':http://bugcommunity.com/wiki/index.php/EMF_Detector\
h3. Note\
The image came from \
http://upload.wikimedia.org/wikipedia/commons/3/35/Photon_paquet_onde.png\
h3. TODO\
* do not hardcode slot number(hardcoded to slot0 for now)\
"
HOMEPAGE = "http://buglabs.net/applications/EMF_Logger"

DEPENDS += "com.buglabs.bug.module com.buglabs.bug.module.vonhippel com.buglabs.common com.buglabs.osgi service-tracker "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/1170"

APIVERSION = "1.4.3"
