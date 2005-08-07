SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA based devices."
MAINTAINER = "Greg Gilbert <greg@treke.net>"
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${CVSDATE}"
#
KERNEL_CCSUFFIX = "-3.4.4"
COMPATIBLE_HOST = "arm.*-linux"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://defconfig"

S = "${WORKDIR}/kernel26"

inherit kernel

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "12"
HHV     = "2"
#

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"
do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}
