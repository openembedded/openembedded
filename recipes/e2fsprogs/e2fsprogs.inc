DESCRIPTION = "EXT2 Filesystem Utilities"
HOMEPAGE = "http://e2fsprogs.sf.net"
LICENSE = "GPL"
SECTION = "base"

SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-${PV}.tar.gz"

S = "${WORKDIR}/e2fsprogs-${PV}"

inherit autotools

#if uclibc ntpl is merged into trunk we can enable tls for armv4 again
EXTRA_OECONF = "${@['','--disable-tls'][bb.data.getVar('ARM_ABI', d, 1) == 'oabi' and \
		bb.data.getVar('TARGET_OS', d, 1).find('uclibc') >= 0 ]} \
		--enable-dynamic-e2fsck --disable-nls --sbindir=${base_sbindir}"

PARALLEL_MAKE = ""
