require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for the Openmoko Neo Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.27"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe0"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
"
S = "${WORKDIR}/git"

do_configure_prepend() {
	install -m 644 ./arch/arm/configs/gta02-moredrivers-defconfig ${WORKDIR}/defconfig-oe 
}

