require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.31"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-2.6.31 \
  file://gta02_defconfig \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "./arch/arm/configs/gta02_defconfig"
CONFIG_NAME_om-gta02 = "${WORKDIR}/gta02_defconfig"

do_configure_prepend() { 
	install -m 644 ${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
