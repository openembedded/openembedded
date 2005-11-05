SECTION = "unknown"
SRC_URI = "http://openembedded.org/dl/matrixssl-1-0-beta2-r2.tar.gz \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/matrixssl/src"
LICENSE = "GPL"
def define_os (d):
	import bb
	if bb.data.getVar('TARGET_OS', d).startswith('linux'):
		return "-DLINUX"
	return ""

CFLAGS += " ${@define_os(d)}"

do_install () {
	install -d ${D}${includedir}
	install -m 0644 ${S}/../matrixSsl.h ${D}${includedir}/
	oe_libinstall -so libmatrixssl ${D}${libdir}/
}
