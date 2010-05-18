require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

KERNEL_RELEASE="2.6.34"

SRCREV = "e23313fc76e2724fe56354526275458a0bdc10c3"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=om-gta02-2.6.34 \
# build fix
  file://wm8753-fix-build-with-gcc-4.4.2-which-works-ok-with-.patch;patch=1 \
# defconfig updates
  file://gta02-defconfig-update-for-2.6.34.patch;patch=1 \
"

S = "${WORKDIR}/git"

CONFIG_NAME_om-gta02 = "gta02_defconfig"

do_configure_prepend() {
        install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
}
