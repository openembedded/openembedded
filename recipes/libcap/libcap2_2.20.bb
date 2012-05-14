DESCRIPTION = "Libcap is a library for getting and setting POSIX.1e (formerly POSIX 6) draft 15 capabilities."
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "BSD | GPLv2"
DEPENDS = "bison-native flex-native attr ${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"
PR = "r1"

BUILD_CFLAGS += "-I${S}/libcap/include"
CFLAGS += "-I${S}/libcap/include"
LDFLAGS =+ "-L../libcap"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/security/linux-privs/libcap2/libcap-${PV}.tar.bz2 \
	   file://make.patch \
	"

SRC_URI[md5sum] = "10e47ed32ca2214eb0e58780282d27b4"
SRC_URI[sha256sum] = "20e7c1ea4d3d5c410efb3a6ff138dc417912fae316d883460dcd58d9803a9220"

S = "${WORKDIR}/libcap-${PV}"

EXTRA_OEMAKE = "SYSTEM_HEADERS=${STAGING_INCDIR}"

do_install() {
	install -d ${D}${includedir}/sys
	install -m 0644 libcap/include/sys/capability.h ${D}${includedir}/sys/
	install -d ${D}${libdir}
	oe_libinstall -s -C libcap libcap ${D}${libdir}
}
