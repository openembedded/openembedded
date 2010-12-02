require bug-app.inc

DESCRIPTION = "This is a simple app that shows how to communicate with an Arduino through BUG's VonHippel module.\
The application reads data from three analog sensors (photo-resistors, in my case).  The sensor data affects the background color of an AWT panel displayed in the LCD module.  Each sensor corresponds to a different channel of the panel background color, red, green, and blue.  The affect is so that waving your hand over the sensors or shining a light on them changes the color displayed on the LCD.\
This example is mostly for demo purposes and the Arduino code is included in the application bundle.  In shows one technique for talking to the Arduino.  If you dive into the code, you'll see that the Java application sends a character (an 'a') to the Arduino and the Arduino responds with a line containing the sensor data.\
Lastly, this blog post shows how to wire up the Arduino to the VonHippel in a general way -- ' http://community.buglabs.net/bballantine/posts/46-Wiring-up-the-Von-Hippel-and-Arduino(http://community.buglabs.net/bballantine/posts/46-Wiring-up-the-Von-Hippel-and-Arduino)':http://community.buglabs.net/bballantine/posts/46-Wiring-up-the-Von-Hippel-and-Arduino -- The same method was used for this application."
HOMEPAGE = "http://buglabs.net/applications/arduinoreader666"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.module.vonhippel com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/669"

APIVERSION = ""
