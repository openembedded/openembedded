require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r6"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://0001-implement-TIF_RESTORE_SIGMASK-support-and-enable-the.patch \
	   file://powerpc-fix-build-with-make-3.82.patch \
	  "
S = "${WORKDIR}/linux-${PV}"

do_configure() {
	oe_runmake allnoconfig ARCH=$ARCH
}

do_compile () {
}

do_install() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH
	rm -f ${D}${exec_prefix}/include/scsi/scsi.h
}

SRC_URI[md5sum] = "84c077a37684e4cbfa67b18154390d8a"
SRC_URI[sha256sum] = "0acd83f7b85db7ee18c2b0b7505e1ba6fd722c36f49a8870a831c851660e3512"
