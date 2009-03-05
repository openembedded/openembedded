require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.28"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OMV = "stable"
PV = "${KERNEL_RELEASE}-${OMV}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable \
#  file://defconfig-oe.patch \
"
S = "${WORKDIR}/git"

do_configure_prepend() {
	if [ ${MACHINE} = "om-gta01" ] ; then
		install -m 644 ./arch/arm/configs/gta01_moredrivers_defconfig ${WORKDIR}/defconfig-oe
	fi
	if [ ${MACHINE} = "om-gta02" ] ; then
		install -m 644 ./arch/arm/configs/gta02_packaging_defconfig ${WORKDIR}/defconfig-oe
	fi
	if [ ${MACHINE} = "om-3d7k" ] ; then
		install -m 644 ./arch/arm/configs/om_3d7k_defconfig ${WORKDIR}/defconfig-oe
	fi
#	cat ${WORKDIR}/defconfig-oe.patch | patch -p0 -d ${WORKDIR}
}

