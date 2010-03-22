SECTION = "kernel"
DESCRIPTION = "Liux As Bootloader kernelm"
LICENSE = "GPLv2"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h2200"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-pxa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
	   file://labrun.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/kernel26"

inherit kernel

K_MAJOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[0]}"
K_MINOR = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[1]}"
K_MICRO = "${@bb.data.getVar('PV',d,1).split('-')[0].split('.')[2]}"
HHV     = "${@bb.data.getVar('PV',d,1).split('-')[1].split('hh')[-1]}"

KERNEL_PRIORITY = "${@'%d' % (int(bb.data.getVar('K_MAJOR',d,1)) * 100000000 + int(bb.data.getVar('K_MINOR',d,1)) * 1000000 + int(bb.data.getVar('K_MICRO',d,1)) * 10000 + float(bb.data.getVar('HHV',d,1)))}"
do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}

KERNEL_IMAGE_BASE__NAME = "LAB-image-${MACHINE}-${DATETIME}.bin"
KERNEL_IMAGE_SYMLINK_NAME = "LAB-image-${MACHINE}"
