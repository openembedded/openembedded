require bug-app.inc

DESCRIPTION = "h3. Summary: \
The ConfigurationAdmin is the standard way that OSGi applications can store and retrieve state, as in dictionaries.  The BUG has a CM installed by default, namely the com.buglabs.osgi.cm bundle.  This app  allows users to view, edit, add to configurations on the BUG. using the LCD module.\
 *NOTES:*  The app is still in early stage. \
"
HOMEPAGE = "http://buglabs.net/applications/ConfigurationAdminGUI"

DEPENDS += "com.buglabs.osgi.cm com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "12"

SRC_LINK = "http://buglabs.net/program_version/download/804"

APIVERSION = ""
