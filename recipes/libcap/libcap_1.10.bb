DESCRIPTION = "Libcap is a library for getting and setting POSIX.1e (formerly POSIX 6) draft 15 capabilities."
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "bison-native flex-native"
PR = "r2"

CFLAGS_append = " -I${S}/libcap/include -fPIC"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/security/linux-privs/kernel-2.4/${PN}-${PV}.tar.bz2 \
	   file://makenames.patch;patch=1 \
	   file://make.patch;patch=1 \
	   file://syscall.patch;patch=1"

FILES_${PN} = "${libdir}"
FILES_${PN}-dev = "${includedir}"

do_install() {
	install -d ${D}${includedir}/sys
	install -m 0644 libcap/include/sys/capability.h ${D}${includedir}/sys/
	install -d ${D}${libdir}
	oe_libinstall -s -C libcap libcap ${D}${libdir}
}

do_stage() {
	install -d ${STAGING_INCDIR}/sys
	install -m 0644 libcap/include/sys/capability.h ${STAGING_INCDIR}/sys/
	oe_libinstall -s -C libcap libcap ${STAGING_LIBDIR}
}
