require linux.inc
require linux-openmoko.inc

DESCRIPTION_${PN} = "Linux ${KERNEL_RELEASE} kernel for the Openmoko Neo GSM Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.28"
KERNEL_VERSION = "2.6.29-rc2"

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

	echo "CONFIG_MTD_BLOCK2MTD=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_MTD_UBI=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_MTD_UBI_WL_THRESHOLD=4096" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_MTD_UBI_BEB_RESERVE=1" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_UBIFS_FS=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_UBIFS_FS_LZO=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_UBIFS_FS_ZLIB=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_CRYPTO_DEFLATE=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_CRYPTO_LZO=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_LZO_COMPRESS=y" >> ${WORKDIR}/defconfig-oe
	echo "CONFIG_LZO_DECOMPRESS=y" >> ${WORKDIR}/defconfig-oe
}
