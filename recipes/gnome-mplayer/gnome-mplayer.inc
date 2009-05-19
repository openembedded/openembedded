DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
AUTHOR = "Kevin DeKorte <kdekorte@gmail.com>"
HOMEPAGE = "http://code.google.com/p/gnome-mplayer/"
SECTION = "x11/multimedia"
LICENSE = "GPL"
DEPENDS = "gtk+ gconf dbus-glib"
RDEPENDS = "mplayer"

inherit autotools pkgconfig gconf

SRC_URI = "http://gnome-mplayer.googlecode.com/files/${P}.tar.gz"
