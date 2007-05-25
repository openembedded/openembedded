DESCRIPTION = "Library and test program for decoding mpeg-2 and mpeg-1 video streams"
HOMEPAGE = "http://libmpeg2.sourceforge.net/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl"
PROVIDES += "libmpeg2"
RPROVIDES += "libmpeg2"
PR = "r3"

S = "${WORKDIR}/mpeg2dec-0.4.0"

SRC_URI = "http://libmpeg2.sourceforge.net/files/mpeg2dec-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-shared"

PACKAGES += "libmpeg2 libmpeg2-dev libmpeg2convert libmpeg2convert-dev"

FILES_${PN} += "${bindir}/*"
FILES_libmpeg2 = "${libdir}/libmpeg2.so.*"
FILES_libmpeg2convert = "${libdir}/libmpeg2convert.so.*"
FILES_libmpeg2-dev = "${libdir}/libmpeg2.so \
                      ${libdir}/libmpeg2.*a \
                      ${libdir}/pkgconfig/libmpeg2.pc \
                      ${includedir}/mpeg2dec/mpeg2.h"
FILES_libmpeg2convert-dev = "${libdir}/libmpeg2convert.so \
                             ${libdir}/libmpeg2convert.*a \
                             ${libdir}/pkgconfig/libmpeg2convert.pc \
                             ${includedir}/mpeg2dec/mpeg2convert.h"

mpeg2dec_include = "mpeg2.h mpeg2convert.h"

do_stage () {
	oe_libinstall -so -C libmpeg2/.libs libmpeg2 ${STAGING_LIBDIR}
	oe_libinstall -so -C libmpeg2/convert/.libs libmpeg2convert ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/mpeg2dec/
	for i in ${mpeg2dec_include}; do
		install -m 0644 include/$i ${STAGING_INCDIR}/mpeg2dec/
	done
}
