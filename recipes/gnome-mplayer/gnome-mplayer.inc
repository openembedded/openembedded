DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
AUTHOR = "Kevin DeKorte <kdekorte@gmail.com>"
HOMEPAGE = "http://code.google.com/p/gnome-mplayer/"
SECTION = "x11/multimedia"
LICENSE = "GPL"
DEPENDS = "gtk+ gconf dbus-glib"
RDEPENDS = "mplayer"

inherit autotools pkgconfig gconf

SRC_URI += "file://ac-gthread.patch;patch=1 \
    file://1.patch;patch=1 \
    file://uchar-for-utf8-check.patch;patch=1 \
    file://non-utf8-id3-fallback.patch;patch=1"
