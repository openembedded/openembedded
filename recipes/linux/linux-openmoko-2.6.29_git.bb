require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

# NOTE: This recipe is tied to an upstream git repo; the KERNEL_VERSION must match the
# the kernel version string as built, otherwise depmod will silently fail when building
# the image itself.  KERNEL_RELEASE should match the kernel version in the recipe name.
# This may have to be adjusted as the upstream git repository changes!
KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "2.6.29-rc3"

OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  file://fix-install.patch;patch=1 \
  file://defconfig-oe.patch \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"
CONFIG_NAME_om-gta03 = "gta03_defconfig"

do_configure_prepend() {
	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
	cat ${WORKDIR}/defconfig-oe.patch | patch -p0 -d ${WORKDIR}
}
