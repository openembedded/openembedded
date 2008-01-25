DESCRIPTION = "The OpenMoko Application Launcher (simple)"
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 startup-notification libice libsm"
PV = "0.0.0+svnr${SRCREV}"
PR = "r0"

inherit openmoko2 gtk-icon-cache 
