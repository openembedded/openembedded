DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
HOMEPAGE = "http://dekorte.homeip.net/download/gnome-mplayer/"
LICENSE = "GPL"
DEPENDS = "gtk+ gconf dbus-glib"
RDEPENDS = "mplayer"
PR = "r3"

inherit autotools pkgconfig gconf

SRC_URI = "http://dekorte.homeip.net/download/${PN}/${P}.tar.gz \
    file://ac-gthread.patch;patch=1 \
    file://1.patch;patch=1 \
    file://uchar-for-utf8-check.patch;patch=1 \
    file://non-utf8-id3-fallback.patch;patch=1"
