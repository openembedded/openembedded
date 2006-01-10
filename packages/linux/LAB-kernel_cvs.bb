SECTION = "kernel"
DESCRIPTION = "Liux As Bootloader kernelm"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"
#
KERNEL_CCSUFFIX = "-3.4.4"
COMPATIBLE_HOST = "arm.*-linux"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://defconfig"

#SRC_URI += bootshim?

S = "${WORKDIR}/kernel26"

inherit kernel

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "13"
HHV     = "1"
#

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"
do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/LAB-image-${MACHINE}
#add the bootshim?
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

