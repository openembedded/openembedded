require bug-app.inc

DESCRIPTION = "h2. Description\
Why let the iPhone have all the tip-calculating fun? :-)\
h2. Versions\
v1.0.3 - 9/10/2008\
* Cleaned up spacing to make keypad a little larger.\
* Added javadoc to the code.\
v1.0.2 - 9/10/2008\
* Changed tips to 15%, 18%, 20%.\
v1.0.1 - 8/26/2008\
* Added @Insets@ to the @GridBagLayout@ so the components are a little more nicely laid out on a real Bug.\
v1.0.0 - 8/25/2008\
* Initial Version\
"
HOMEPAGE = "http://buglabs.net/applications/TipCalc"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/364"

APIVERSION = ""
