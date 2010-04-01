DESCRIPTION = "Tmut is a really small E-Mail client based on Tinymail"
SECTION = "x11/utils"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 gnome-vfs gconf libtinymail"
SRCREV = "60"
PV = "0.0.0+svnr${SRCPV}"
PR = "r3"

DEFAULT_PREFERENCE = "-1"


SRC_URI = "svn://svn.tinymail.org/svn/tmut/;module=trunk;proto=http"

inherit pkgconfig autotools
S = "${WORKDIR}/trunk"
