LICENSE = GPL

DESCRIPTION = "An audio Sample Rate Conversion library"
SECTION = "libs"
PRIORITY = "optional"

inherit autotools pkgconfig

SRC_URI = "http://www.mega-nerd.com/SRC/libsamplerate-${PV}.tar.gz"
S="${WORKDIR}/libsamplerate-${PV}"


PACKAGES = "${PN}"

FILES_${PN} = " ${libdir}/libsamplerate.so.0 ${libdir}/libsamplerate.so.0.1.1 " 

do_stage() {
	oe_libinstall -a -so -C src libsamplerate ${STAGING_LIBDIR}
	install -m 0644 ${S}/src/samplerate.h ${STAGING_INCDIR}/
}
