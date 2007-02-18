DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libglade gnome-vfs"
PR = "r1"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools
