require bug-app.inc

DESCRIPTION = "Familiar with the AppStore?\
This app does what the AppStore does, but do not expect shiny graphics since\
we can only do so much with AWT.\
Any way . In order to have this app running on the bug, you will need to \
give it Internet access. if you don't know how, look here :\
http://buglabs.net/start \
The UI is self explanatory:\
this App will display up to 300 applications (available on bugnet) from the latest\
to the oldest. Use the navigation buttons to navigate back and forth  app \
listing. click on Install to get the app you are viewing into the bug and \
running given that all required modules are connected at the time of installation.\
Clicking the Menu button gives you acces to more control.\
You can view the apps from the most recently uploaded to the oldest,\
you can view them based o the download count, or make a search \
by clicking the text box.\
When making a search, the bottom panel will turn MAGENTA ( pink like color)\
to let you know that you are navigating the result of your search.\
clicking  the > button in the menu will allow you you to go back and forth between the \
result of your search and all the apps available.\
the app info include:\
Name\
Download Count\
Description\
Author\
                    *Virtual Bug*\
It is a very good idea to get theAppUI (http://www.buglabs.net/applications/AppUI)\
 app so that you can view the applications on your bug, stop , restart , or even un_install them at will.\
look at the AppUI app as being the application menu if you will.\
if you want to run this app on the virtual bug, make sure you have the \
/usr/share/java/apps directory and that the virtual bug can access it.\
mkdir /usr/share/java/apps\
chmod 777  /usr/share/java/apps \
The Keyboard will not work on the virtual bug as the real hardware \
is need to implement this functionality.\
\
Enjoy\
*** Your feedback is appreciated...\
"
HOMEPAGE = "http://buglabs.net/applications/AppSite"

DEPENDS += "com.buglabs.bug.module.lcd com.buglabs.bug.program com.buglabs.common com.buglabs.osgi.shell service-tracker "

PV = "23"

SRC_LINK = "http://buglabs.net/program_version/download/1087"

APIVERSION = ""
