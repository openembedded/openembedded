
DESCRIPTION = "Library for reading some sort of media format."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "LGPL"
inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/faac/${PN}-${PV}.tar.gz"
S="${WORKDIR}/${PN}"

PACKAGES = "${PN} lib${PN} lib${PN}-dev"

FILES_${PN} = " ${bindir}/faac "
FILES_lib${PN} = " ${libdir}/libfaac.so.0 ${libdir}/libfaac.so.0.0.0 " 
FILES_lib${PN}-dev = " ${includedir}/faac.h ${includedir}/faaccfg.h ${libdir}/libfaac.so ${libdir}/libfaac.la ${libdir}/libfaac.a "

do_stage() {
	oe_libinstall -a -so -C libfaac libfaac ${STAGING_LIBDIR}
	install -m 0644 ${S}/include/faac.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/include/faaccfg.h ${STAGING_INCDIR}/
}
