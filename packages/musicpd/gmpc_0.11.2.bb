DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "gnome/multimedia"
DEPENDS = "gtk+ libglade"
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools
