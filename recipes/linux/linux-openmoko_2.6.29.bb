require linux.inc
require linux-openmoko.inc

SRCREV = "973a41fce60e5f6edfcf0eaf94056a57eee65e16"
PR = "r9"
PR_append = "+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  file://fix-install.patch \
  file://0007-Enable-UBI-UBIFS.patch \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"

do_configure_prepend() { 
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
