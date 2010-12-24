DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "curl libsexy gob2-native gob2 libmpd gtk+ libglade gnome-vfs"
PR = "r1"

inherit gnome autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

do_configure_prepend() {
     MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
      for i in ${MACROS}; do
         rm -f m4/$i
      done
}

FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "902fd69b0b6bb40abb647604080dd7ef"
SRC_URI[sha256sum] = "d9b8bd23e86acc74049d2ceb5e06db8c62b43e7e5bd166ac8348eae133b9de81"
