DESCRIPTION = "Support library for dealing with zip files"
SECTION = "libs"
PRIORITY = "optional"

DEPENDS = "zlib python-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/zziplib/zziplib-${PV}.tar.bz2"
LICENSE = "LGPL MPL"

inherit autotools pkgconfig

do_configure_append() {
	# Fix some brokenness in the generated makefile.
	sed -i \
		-e "s|tail -1|tail -n 1|" \
		-e "s|dist dist-all dist-all:|dist dist-all:|" \
		Makefile

  mkdir ${S}/build
}
