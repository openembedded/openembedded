SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA based devices."
MAINTAINER = "Greg Gilbert <greg@treke.net>"
LICENSE = "GPL"
#
KERNEL_CCSUFFIX = "-3.3.4"
COMPATIBLE_HOST = "arm.*-linux"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "http://handhelds.org/~michaelo/ipaq/kernel/linux-2.6.6-hh0.tar.bz2  \
           file://defconfig-${MACHINE}"

S = "${WORKDIR}/linux-2.6.6-hh0"

inherit kernel

PACKAGE_ARCH = "ipaqpxa"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "6"
HHV     = "0"
#

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"
do_configure() {
	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."
        (echo N; echo m; echo N) | oe_runmake oldconfig
}
