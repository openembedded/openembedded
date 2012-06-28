LICENSE = "GPL"
DESCRIPTION = "Transparent xcursor theme for handheld systems"
SECTION = "x11/base"
PR ="r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/utils/xcursor-transparent-theme-${PV}.tar.gz \
	   file://use-relative-symlinks.patch \
	   file://fix_watch_cursor.patch"
FILES_${PN} = "${datadir}/icons/xcursor-transparent/cursors/*"

inherit autotools

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "7b0c623049d4aab20600d6473f8aab23"
SRC_URI[sha256sum] = "b26adf2d503d01299718390ae39dab4691a67220de09423be0364e9a060bf7e4"
