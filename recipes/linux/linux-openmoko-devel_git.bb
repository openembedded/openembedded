require linux.inc
require linux-openmoko.inc

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "a15608f241a40b41fed5bffe511355c2067c4e88"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"
CONFIG_NAME_om-3d7k  = "om_3d7k_defconfig"

do_configure_prepend() {
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
	cat ${WORKDIR}/defconfig-oe.patch | patch -p0 -d ${WORKDIR}
}
