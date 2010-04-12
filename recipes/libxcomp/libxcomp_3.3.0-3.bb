DESCRIPTION = "Compression library for x-protocol from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "virtual/libx11 zlib jpeg libpng"

SRC_URI = "http://64.34.161.181/download/3.3.0/sources/nxcomp-${PV}.tar.gz \
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

SRC_URI[md5sum] = "2327cca8e6116fd6a96345566336d81d"
SRC_URI[sha256sum] = "069b3baa000b4a6125b86bddaf67c1b7fcd082eaf14b64113558fc30d6c71dd7"
