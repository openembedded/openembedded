DESCRIPTION = "flickcurl is a C libarry for the Flick API"
SECTION = "libs"
HOMEPAGE = "http://librdf.org/flickcurl/"
LICENSE = "LGPL 2.1/GPL 2/Apache 2.0"
PR = "r0"
SRC_URI = "http://download.dajobe.org/${PN}/${PN}-${PV}.tar.gz"

DEPENDS = "curl libxml2 raptor"

EXTRA_OECONF = "ac_cv_func_vsnprintf=no"

inherit autotools

LEAD_SONAME = "libflickcurl.so.1"

FILES_${PN} += "${libdir}/libflickcurl.so.*"

SRC_URI[md5sum] = "1fa16fcca03bc214715a654e6dd73b1f"
SRC_URI[sha256sum] = "818dbad0760e905c4ea14c3c09589e2e3be92c2077c9e339f1ae79397a037587"
