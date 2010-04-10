DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "curl libsexy gob2-native gob2 libmpd gtk+ libglade gnome-vfs"
PR = "r0"

inherit gnome

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

do_configure() {
	sed -i -e s:'head -1':'head -n1':g configure
    gnu-configize
	oe_runconf
}

FILES_${PN} += "${datadir}/icons"



SRC_URI[md5sum] = "8876ca25ae70a379b62b6b407dc4f5ba"
SRC_URI[sha256sum] = "c04149c5ea4325bf63a847649d9ae5e0ed9b3b6b1804856753b756782e02329c"
