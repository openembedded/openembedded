DESCRIPTION = "LibParserUtils is a library for building efficient parsers"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libparserutils/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/libparserutils-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libparserutils is only used by Netsurf
# at the moment

do_stage () {
        oe_libinstall -a -C build-OE/ libparserutils ${STAGING_LIBDIR}
	install -m 0644 build-OE/libparserutils.pc ${STAGING_LIBDIR}/pkgconfig
	install -d ${STAGING_INCDIR}/parserutils
	install -d ${STAGING_INCDIR}/parserutils/charset
	install -d ${STAGING_INCDIR}/parserutils/input
	install -d ${STAGING_INCDIR}/parserutils/utils
	install -m 0644 include/parserutils/*.h ${STAGING_INCDIR}/parserutils
	install -m 0644 include/parserutils/charset/*.h \
		${STAGING_INCDIR}/parserutils/charset
	install -m 0644 include/parserutils/input/*.h \
		${STAGING_INCDIR}/parserutils/input
	install -m 0644 include/parserutils/utils/*.h \
		${STAGING_INCDIR}/parserutils/utils
}


do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "5b2e4ddeebe451cc801ccd6e7da06f87"
SRC_URI[sha256sum] = "769be8da5c9a012d2d968fc814567c1067febf3d3df5e18f1ae2521324dcd923"
