DESCRIPTION = "The OpenMoko Application Launcher"
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 startup-notification dbus-glib libice libsm"
PV = "0.1.0+svnr${SRCREV}"

inherit openmoko2 gtk-icon-cache 
