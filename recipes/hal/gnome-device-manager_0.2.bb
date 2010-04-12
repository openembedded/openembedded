DESCRIPTION = "Device viewer with a GTK+ UI"
LICENSE = "GPL/LGPL"
DEPENDS = "libgnomeui hal gtk+"

inherit gnome

SRC_URI = "http://hal.freedesktop.org/releases/gnome-device-manager-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/icons"



SRC_URI[md5sum] = "b833a90c940dd6cc992c42ad05ca6831"
SRC_URI[sha256sum] = "fecb3bf79c3f10bebf0601c044344b0105738c1533f5da62f27dc84d0a3b30d3"
