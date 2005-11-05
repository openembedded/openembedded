SECTION = "libs"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/OpenSP-${PV}.tar.gz \
	   file://m4.patch;patch=1 \
	   file://attributevalue.patch;patch=1"
S = "${WORKDIR}/OpenSP-${PV}"
LICENSE = "MIT"
inherit autotools native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/opensp-${PV}"
PACKAGES = ""

do_configure () {
	gnu-configize
	oe_runconf
}

do_stage () {
	oe_libinstall -a -so -C lib libosp ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/OpenSP
	install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/OpenSP/
	install -m 0644 ${S}/include/*.cxx ${STAGING_INCDIR}/OpenSP/
	install -m 0644 config.h ${STAGING_INCDIR}/OpenSP/config.h
}
