DESCRIPTION = "A Type1 Font Rastering Library"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r2"
LICENSE = "LGPL GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/t/t1lib/t1lib_${PV}.orig.tar.gz \
           file://configure.patch;patch=1 \
           file://install.patch;patch=1 \
	   file://libtool.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--without-x --without-athena"
EXTRA_OEMAKE = "without_doc"

do_configure() {
	rm -f ${S}/ac-tools/aclocal.m4
	autotools_do_configure
}

do_stage() {
	oe_libinstall -so -C lib libt1 ${STAGING_LIBDIR}
	install lib/t1lib/t1lib.h ${STAGING_INCDIR}/
	install lib/t1lib/t1libx.h ${STAGING_INCDIR}/
}

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}/t1lib/t1lib.config"
FILES_${PN}-doc = "${datadir}/t1lib/doc/t1lib_doc.pdf"
