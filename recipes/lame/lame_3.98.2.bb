SECTION = "console/utils"
DESCRIPTION = "Not an MP3 encoder"
LICENSE = "LGPL"
PR = "r0"

S = "${WORKDIR}/${PN}-398-2"
SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-398-2.tar.gz \
	file://no-gtk1.patch;patch=1 \
	file://ldflags-qa.patch;patch=1"

inherit autotools_stage

PACKAGES += "libmp3lame libmp3lame-dev"
FILES_${PN} = "${bindir}/lame"
FILES_libmp3lame = "${libdir}/libmp3lame.so.*"
FILES_libmp3lame-dev = "${includedir} ${libdir}/*"
FILES_${PN}-dev = ""

do_configure() {
	# no autoreconf please
	aclocal
	autoconf
	libtoolize --force
	gnu-configize --force
	oe_runconf
}
