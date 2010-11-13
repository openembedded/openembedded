require linux.inc
require linux-openmoko.inc

KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "2.6.29-rc3"

SRCREV = "973a41fce60e5f6edfcf0eaf94056a57eee65e16"
OMV = "oe11"
PV = "${KERNEL_RELEASE}-${OMV}+gitr${SRCPV}"
PR = "r9"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  file://fix-install.patch \
  file://0007-Enable-UBI-UBIFS.patch \
  file://touchscreen_ignoreunexpectedintr29.patch \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig
}
