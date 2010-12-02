require bug-app.inc

DESCRIPTION = "*Description*\
Cammotion is an application that take photos from a v4l2 webcam when some movement is detected by the BUGmotion module.\
It works the following way:\
The java application launches mplayer,that displays the camera input fullscreen,and when a movement is detected,it takes a picture and put it in /home/root/.mplayer/screenshots. (the screenshot file names are like this: shot0001.png).That's all for now.\
while not having many features,it also has some limitations.\
As I used mplayer the pictures are the size of the screen,that is 320x240,and you need a screen.\
*Requirements:*\
* mplayer with v4l2 support (cross)compiled for the bug device\
* a kernel compiled with gspca or your v4l2 webcam driver.(kernel patching not needed,you only need a different kernel configuration(.config) and to recompile the kernel)\
Binaries for mplayer and the kernel will be avaliable soon\
* a standard v4l2 webcam such as a gspca one pluged into the von-hippel USB port\
*License:*\
The license is the GPLv3.\
If you need a special exception because you want to combine this software with a software that has an incompatible license(such as GPLv2 only(not GPLv2 or later))\
*TODO (not implemented yet,planning):*\
-* web serviece that display the pictures- basic implementation in another app named BugGallery\
* timestamps \
* download the pictures as zip file from the web service\
* investigate how to have a headless mplayer that works without a real display(could also be used to increase the resolution)\
Thanks to jconnolly and some people in #java for telling me how to handle the broken pipes:\
* the first time I didn't empty stdout and stderr comming from the process so I had a broken pipe\
* the second time I did 'sh', '-c', 'export','DISPLAY' etc... instead of 'sh' '-c' 'export DISPLAY etc...'\
"
HOMEPAGE = "http://buglabs.net/applications/Cammotion"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.common com.buglabs.bug.module.lcd com.buglabs.bug.module.vonhippel com.buglabs.osgi "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/687"

APIVERSION = ""
