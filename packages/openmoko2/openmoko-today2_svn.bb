DESCRIPTION = "The OpenMoko Application Launcher"
SECTION = "openmoko/pim"
DEPENDS = "startup-notification dbus-glib libice libsm"

PV = "0.1.0+srvn${SRCDATE}"

inherit openmoko2 gtk-icon-cache 
