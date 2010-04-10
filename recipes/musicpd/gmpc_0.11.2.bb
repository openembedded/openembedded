DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libglade gnome-vfs"
PR = "r1"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools

SRC_URI[md5sum] = "a7cc8c0734fef9e0b05be76cea3c0a20"
SRC_URI[sha256sum] = "cacf881ccdbc3fe5568636bf279392b5d339a481a5fb2c03d5c70a2de58f7407"
