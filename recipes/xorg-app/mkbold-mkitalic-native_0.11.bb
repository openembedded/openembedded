DESCRIPTION = "mkbold-mkitalic : make bold and italic fonts from normal fonts"
HOMEPAGE = "http://hp.vector.co.jp/authors/VA013651/freeSoftware/mkbold-mkitalic.html"
PRIORITY = "optional"
LICENSE = "MIT/X"
PR = "r2"

SRC_URI = "http://hp.vector.co.jp/authors/VA013651/lib/mkbold-mkitalic-${PV}.tar.bz2 \
           file://makebifonts"

S = "${WORKDIR}/mkbold-mkitalic-${PV}"

inherit native

do_stage() {
	install -d ${STAGING_BINDIR_NATIVE}
	install -m 755 mkbold ${STAGING_BINDIR_NATIVE}/
	install -m 755 mkitalic ${STAGING_BINDIR_NATIVE}/
	install -m 755 mkbolditalic ${STAGING_BINDIR_NATIVE}/
	install -m 755 ${WORKDIR}/makebifonts ${STAGING_BINDIR_NATIVE}/
}


SRC_URI[md5sum] = "2384f0eb2e0d2d8f70ee292b81522619"
SRC_URI[sha256sum] = "efddffd87681f0e8f3fc140c99ba6f4e15be4f144d2488886fb493cb3d85e990"
