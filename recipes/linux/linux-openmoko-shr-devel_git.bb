require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_VERSION} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "2.6.29-rc3"

SRCREV = "a15608f241a40b41fed5bffe511355c2067c4e88"
OMV = "oe11"
PV = "${KERNEL_RELEASE}-${OMV}+gitr${SRCREV}"
PR = "r8"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  file://fix-install.patch;patch=1 \
  file://0007-Enable-UBI-UBIFS.patch;patch=1 \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
