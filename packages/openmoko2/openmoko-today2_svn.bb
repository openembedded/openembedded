DESCRIPTION = "The OpenMoko Application Launcher"
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 libmokojournal2 startup-notification dbus-glib libice libsm"
# for libjana (which should be a seperate bbfile soon)
DEPENDS += "openmoko-dates2"
RDEPENDS = "libedata-cal openmoko-today2-folders"
PV = "0.1.0+svnr${SRCREV}"
PR = "r2"

inherit openmoko2 gtk-icon-cache 
