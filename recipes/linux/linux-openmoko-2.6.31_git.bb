require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.31"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-2.6.31 \
  file://0001-wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
  file://0004-gta02_defconfig-Enable-UBI-support.patch;patch=1 \
"
#  file://0005-gta02_defconfig-Enable-UBI-debug.patch;patch=1 \

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_defconfig"
CONFIG_NAME_om-gta02 = "gta02_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
