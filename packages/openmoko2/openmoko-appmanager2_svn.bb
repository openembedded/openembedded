DESCRIPTION = "The OpenMoko Application Manager"
SECTION = "openmoko/applications"
DEPENDS = "libmokoui2 libmokojournal2 startup-notification dbus-glib libice libsm ipkg"
PV = "0.1.0+svnr${SRCREV}"
PR = "r1"

inherit openmoko2 

FILES_${PN} += "/usr/share/openmoko-appmanager"

