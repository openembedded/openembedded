DESCRIPTION = "Device viewer with a GTK+ UI"
LICENSE = "GPL/LGPL"
DEPENDS = "libgnomeui hal gtk+"

inherit gnome

SRC_URI = "http://hal.freedesktop.org/releases/gnome-device-manager-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/icons"


