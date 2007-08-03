DESCRIPTION = "The OpenMoko Application Launcher"
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 libmokojournal2 startup-notification dbus-glib libice libsm"
PV = "0.1.0+svn${SVNREV}"

inherit openmoko2 gtk-icon-cache 
