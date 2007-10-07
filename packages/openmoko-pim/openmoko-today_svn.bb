DESCRIPTION = "OpenMoko Today application."
SECTION = "openmoko/pim"
LICENSE = "GPL"
DEPENDS = "openmoko-libs eds-dbus startup-notification"
PV = "0.1+svnr${SRCREV}"

inherit autotools pkgconfig gtk-icon-cache openmoko

