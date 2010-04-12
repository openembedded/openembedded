require file.inc

DEPENDS_virtclass-native += "zlib-native"

PR = "${INCPR}.0"

SRC_URI = "ftp://ftp.fi.debian.org/pub/gentoo/distfiles/file-${PV}.tar.gz"

SRC_URI_append_virtclass-native = " file://native-fix.diff;patch=1"

do_configure_prepend() {
	sed -i -e 's,$(top_builddir)/src/file,file,' ${S}/magic/Makefile.am
}

SRC_URI[md5sum] = "9e3503116f4269a1be70220ee2234b0e"
SRC_URI[sha256sum] = "6f5644d56cc603138533158076a6cb41cd33c33d27e5310cb76cb6576151ca67"
