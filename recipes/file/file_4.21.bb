require file.inc

DEPENDS_virtclass-native += "zlib-native"

PR = "${INCPR}.0"

SRC_URI = "ftp://ftp.fi.debian.org/pub/gentoo/distfiles/file-${PV}.tar.gz"

SRC_URI_append_virtclass-native = " file://native-fix.diff;patch=1"

do_configure_prepend() {
	sed -i -e 's,$(top_builddir)/src/file,file,' ${S}/magic/Makefile.am
}
