DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
LICENSE = "GPLv2"
SECTION = "gnome/multimedia"
DEPENDS = "libmpd gtk+ libglade gnome-vfs"
PR = "r0"

SRC_URI = "http://download.qballcow.nl/programs/gmpc-0.13/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools
