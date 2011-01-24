DESCRIPTION = "OpenSP is a library and a set of tools \
for validating, parsing, and manipulating SGML and \
XML documents."
HOMEPAGE = "http://openjade.sourceforge.net/"
SECTION = "libs"
LICENSE = "MIT"
PR = "r3"

# At Os it encounters calls to some inline functions which are them not found
# in anyother objects with gcc 4.5

FULL_OPTIMIZATION += "-O2"

SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/OpenSP-${PV}.tar.gz \
           file://m4.patch \
           file://attributevalue.patch \
           file://rangmap-fix.patch \
           file://fix-docdir.patch"

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

SRC_URI[md5sum] = "87f56e79ae0c20397f4207d61d154303"
SRC_URI[sha256sum] = "987eeb9460185950e066e5db3b5fa531e53e213742b545288405552a5a7bb704"
