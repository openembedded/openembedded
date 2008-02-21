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

