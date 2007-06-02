DESCRIPTION = "OpenSP is a library and a set of tools \
for validating, parsing, and manipulating SGML and \
XML documents."
HOMEPAGE = "http://openjade.sourceforge.net/"
SECTION = "libs"
LICENSE = "MIT"
PR = "r2"

# sh4/gcc3.4.4 with -O2 triggers internal compiler errors
FULL_OPTIMIZATION_sh4 = "-O1"

SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/OpenSP-${PV}.tar.gz \
           file://m4.patch;patch=1 \
           file://attributevalue.patch;patch=1 \
           file://rangmap-fix.patch;patch=1 \
           file://fix-docdir.patch;patch=1"

S = "${WORKDIR}/OpenSP-${PV}"

inherit autotools

do_stage () {
        oe_libinstall -a -so -C lib libosp ${STAGING_LIBDIR}
        install -d ${STAGING_INCDIR}/OpenSP
        install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/OpenSP/
        install -m 0644 ${S}/include/*.cxx ${STAGING_INCDIR}/OpenSP/
        install -m 0644 ${S}/config.h ${STAGING_INCDIR}/OpenSP/config.h
}

FILES_${PN} += "${datadir}/OpenSP"
