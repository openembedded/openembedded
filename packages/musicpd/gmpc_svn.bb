DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
LICENSE = "GPLv2"
SECTION = "gnome/multimedia"
DEPENDS = "libmpd gtk+ libglade gnome-vfs gob2"
SRCDATE = "20070120"
PV = "0.13.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://svn.musicpd.org/gmpc;module=trunk;proto=https"
S = "${WORKDIR}/trunk"

LDFLAGS += "-export-dynamic"

inherit autotools
