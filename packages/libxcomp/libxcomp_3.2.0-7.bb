DESCRIPTION = "Compression library for x-protocol from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "virtual/libx11 zlib jpeg libpng"

SRC_URI = "http://64.34.161.181/download/3.2.0/sources/nxcomp-${PV}.tar.gz \
	   file://sa_restorer.patch;patch=1 \
	  "

          
inherit autotools

S = "${WORKDIR}/nxcomp"

do_install () {
       oe_libinstall -a -so libXcomp ${D}${libdir}
       install -d ${D}${includedir}/
       install -m 0644 NX.h ${D}${includedir}/
}


do_stage () {
       oe_libinstall -a -so libXcomp ${STAGING_LIBDIR}
       install -m 0644 NX.h ${STAGING_INCDIR}/ 
}
