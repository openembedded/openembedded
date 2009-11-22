DESCRIPTION = "The Openmoko Application Manager"
SECTION = "openmoko/applications"
DEPENDS = "libmokoui2 libmokojournal2 startup-notification dbus-glib libice libsm opkg"
PV = "0.1.0+svnr${SRCPV}"
PR = "r2"

inherit openmoko2 

FILES_${PN} += "/usr/share/openmoko-appmanager"
