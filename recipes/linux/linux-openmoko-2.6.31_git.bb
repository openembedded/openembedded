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
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta02_defconfig"
CONFIG_NAME_om-gta02 = "gta02_defconfig"
CONFIG_NAME_om-gta03 = "gta03_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
