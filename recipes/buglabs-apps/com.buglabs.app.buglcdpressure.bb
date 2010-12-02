require bug-app.inc

DESCRIPTION = "Demonstrates how to obtain the pressure data of the LCD touch screen on slot 1. There are many parameters that affect the pressure reading. These include, location of the press, resistance of the film, placement, etc... Therefore, it is not an accurate reading. If users want the real raw value they should modify the bmi_lcd linux driver.\
To get this application to compile please create a repository in eclipse pointing to :pserver:anonymous@cvs.buglabs.net:/root . Download com.buglabs.bug.jni.common and com.buglabs.bug.jni.input. Modify the .classpath file and replace the PhoneME class path entry with: \
&lt;classpathentry kind='con' path='com.buglabs.phoneme.personal.PhoneMEClasspathContainer'/&gt;\
"
HOMEPAGE = "http://buglabs.net/applications/BUGLCD_Pressure"

DEPENDS += "com.buglabs.bug.jni.input com.buglabs.bug.jni.common "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/231"

APIVERSION = ""
