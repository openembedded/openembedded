SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager common files"
LICENSE = "GPL"
DEPENDS = "libmatchbox"
PR = "r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://no-utilities-category.patch;patch=1 \
           file://add-media-category.patch;patch=1"

inherit autotools  pkgconfig

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox/vfolders \
	       ${datadir}/pixmaps"
