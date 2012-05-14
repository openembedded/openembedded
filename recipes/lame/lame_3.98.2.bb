SECTION = "console/utils"
DESCRIPTION = "Not an MP3 encoder"
LICENSE = "LGPLv2+"
PR = "r1"

S = "${WORKDIR}/${PN}-398-2"
SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-398-2.tar.gz \
	file://no-gtk1.patch \
	file://ldflags-qa.patch"

inherit autotools

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

SRC_URI[md5sum] = "719dae0ee675d0c16e0e89952930ed35"
SRC_URI[sha256sum] = "a17a28569d8ed1e514915c1f12bdf4eedac506e5fbdf9a429ba97d5d42c9af32"
