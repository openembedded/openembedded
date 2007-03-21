DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libmpd gtk+ libglade gnome-vfs gob2 curl"
SRCDATE = "20070120"
PV = "0.13.0+svn${SRCDATE}"

SRC_URI = "svn://svn.musicpd.org/gmpc;module=trunk;proto=https"
S = "${WORKDIR}/trunk"

LDFLAGS += "-export-dynamic"

inherit autotools
