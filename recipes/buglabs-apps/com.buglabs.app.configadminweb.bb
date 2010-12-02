require bug-app.inc

DESCRIPTION = "h3. Summary: \
Developing web applications with the new Bug framework, 'SEWING(sewing)':http://buglabs.net/applications/com.buglabs.osgi.sewing, is pretty easy   (maybe not, if you are used to JQuery, JSF, Rails, etc, but sewing is still pretty sweet)\
This app is a  web version  of 'ConfigAdminGUI(ConfigurationAdminGUI)':http://buglabs.net/applications/ConfigurationAdminGUI.  I tried to use as many SEWING features as I could. I hope this works as a sample what YOU can do with this new framework.\
To access the service go to :\
    \
* *http://localhost:8082/configadmin* on the Virtual Bug \
* *http://10.10.10.10/configadmin* on the Real Bug\
"
HOMEPAGE = "http://buglabs.net/applications/ConfigAdminWeb"

DEPENDS += "service-tracker com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.osgi.cm com.sun.javax.servlet com.buglabs.common com.buglabs.osgi "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/822"

APIVERSION = ""
