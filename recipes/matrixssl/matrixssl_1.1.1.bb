DESCRIPTION = "A secure sockets library"
SECTION = "libs"
LICENSE = "GPL"
PR = "r1"
SRC_URI = "http://wiki.openembedded.org/dl/matrixssl-1-1-1.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/matrixssl/src"

require matrixssl.inc

CFLAGS_append = " ${@define_os(d)}"

do_install () {
	install -d ${D}${includedir}
	install -m 0644 ${S}/../matrixSsl.h ${D}${includedir}/
	oe_libinstall -so libmatrixssl ${D}${libdir}/
}
