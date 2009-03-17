DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
HOMEPAGE = "http://dekorte.homeip.net/download/gnome-mplayer/"
LICENSE = "GPL"
DEPENDS = "gtk+ gconf dbus-glib"
RDEPENDS = "mplayer"
SRCDATE = "20080101"
PV = "0.5.3+cvs${SRCDATE}"
PR = "r5"

inherit autotools pkgconfig gconf

S = "${WORKDIR}/${PN}"

SRC_URI = "cvs://anonymous@dekorte.homeip.net/data/cvs;module=${PN} \
    file://ac-gthread.patch;patch=1 \
    file://1.patch;patch=1 \
    file://uchar-for-utf8-check.patch;patch=1 \
    file://non-utf8-id3-fallback.patch;patch=1"

do_install_append() {
	sed -i "s/OnlyShowIn=GNOME;//" ${D}${datadir}/applications/gnome-mplayer.desktop
}

