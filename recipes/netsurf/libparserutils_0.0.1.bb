DESCRIPTION = "LibParserUtils is a library for building efficient parsers"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libparserutils/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

SRC_URI = "http://www.netsurf-browser.org/projects/releases/libparserutils-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libparserutils is only used by Netsurf
# at the moment

do_stage () {
        oe_libinstall -a -C build-OE/ libparserutils ${STAGING_LIBDIR}

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

SRC_URI[md5sum] = "5999c2d52f8c07eeef2a8808fee4f858"
SRC_URI[sha256sum] = "5aed4edfd2023ed3ccd566fe76131d10faf43c8c3efa2e90978eed37c5503165"
