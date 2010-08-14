DESCRIPTION = "flickcurl is a C libarry for the Flick API"
SECTION = "libs"
HOMEPAGE = "http://librdf.org/flickcurl/"
LICENSE = "LGPL 2.1/GPL 2/Apache 2.0"
PR = "r0"
SRC_URI = "http://download.dajobe.org/${PN}/${PN}-${PV}.tar.gz"

DEPENDS = "curl libxml2"

EXTRA_OECONF = "ac_cv_func_vsnprintf=no"

inherit autotools

do_stage() {
	 install -d ${STAGING_INCDIR}
         install -m 0644 ${D}/usr/include/*.h ${STAGING_INCDIR}
	 oe_libinstall -so libflickcurl ${STAGING_LIBDIR}
}

LEAD_SONAME = "libflickcurl.so.1"

FILES_${PN} += "${libdir}/libflickcurl.so.*"

SRC_URI[md5sum] = "d701fcc8d764e634ee979f18ff9db322"
SRC_URI[sha256sum] = "573ae52509289ed366a161facf390aa6ce530da143c760ca546868c8b0a0d034"
