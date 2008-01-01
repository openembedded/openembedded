DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
HOMEPAGE = "http://dekorte.homeip.net/download/gnome-mplayer/"
LICENSE = "GPL"
DEPENDS = "gtk+ gconf dbus-glib"
SRCDATE = "20080101"
PV = "0.5.3+cvs${SRCDATE}"
PR = "r1"

inherit autotools pkgconfig gconf

S = "${WORKDIR}/${PN}"

SRC_URI = "cvs://anonymous@dekorte.homeip.net/data/cvs;module=${PN} \
    file://ac-gthread.patch;patch=1 \
    file://1.patch;patch=1"
