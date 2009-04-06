DESCRIPTION = "MNG Library"
SECTION = "libs"
DEPENDS = "zlib jpeg lcms"
LICENSE = "libmng"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libmng/libmng-${PV}.tar.gz \
           file://ldflags.patch;patch=1"

inherit pkgconfig

EXTRA_OEMAKE_append = " ZLIBINC=${STAGING_INCDIR} ZLIBLIB=${STAGING_LIBDIR} \
			JPEGINC= JPEGLIB= LCMSINC= LCMSLIB="

do_compile() {
	oe_runmake -f makefiles/makefile.linux
}

do_stage() {
	oe_libinstall -so libmng ${STAGING_LIBDIR}
	install -m 0644 ${S}/libmng.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/libmng_conf.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/libmng_types.h ${STAGING_INCDIR}/
}

do_install() {
	install -d ${D}${bindir} ${D}${mandir} \
		   ${D}${libdir} ${D}${includedir}
	oe_runmake -f makefiles/makefile.linux install \
	INCPATH="${D}${includedir}" LIBPATH="${D}${libdir}" prefix=${prefix}
}
