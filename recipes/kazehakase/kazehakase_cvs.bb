DESCRIPTION = "A gtk-webcore based browser"
HOMEPAGE = "http://kazehakase.sourceforge.jp/"
SECTION = "x11/network"
LICENSE = "GPLv2"
DEPENDS = "osb-nrcit glib-2.0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.jp/cvsroot/kazehakase;module=kazehakase"
S = "${WORKDIR}/kazehakase"


PV = "0.4.7+cvs${SRCDATE}"

inherit autotools pkgconfig

EXTRA_OECONF = " --disable-gtkmozembed "

DEFAULT_PREFERENCE = "-1"

