PR = "r2"

KERVER = "2.6.16"

COMPATIBLE_MACHINE = "(nokia770)"

S = "${WORKDIR}/cx3110x-0.8.1"
SKERNEL = "${WORKDIR}/kernel-source-${KERVER}"

# The following require must be after S{S}, ${SKERNEL}, ${KERVER}
require cx3110x.inc

SRC_URI += "https://garage.maemo.org/frs/download.php/2443/cx3110x-0.8.1.tar.gz;name=archive \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2;name=arm \
 http://dev.openbossa.org/mamona/sources/kernel-source-${KERVER}.tar.gz;name=kernel \
 file://defconfig \
 file://fix_mem_corruption.patch;patch=1 \
 file://fix_mem_allign.patch;patch=1 \
 file://cx3110x.patch;patch=1 \
 file://fix_cross_makefile.patch;patch=1 \
 file://fix_ssid_data_length.patch;patch=1 \
 file://770_performance_improvements.patch;patch=1 \
 file://create_sysfs_link_for_wlan0.patch;patch=1 \
 file://fix_opps_while_connecting_with_nm.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "85c115a81fa4429bee2cd16bfe961d44"
SRC_URI[archive.sha256sum] = "8fcdeb785c94a7f2408c0a0dd365db6b1a01347e386bb68ffa1886c1f62239db"
SRC_URI[arm.md5sum] = "1709df05ed8572c6d2457af0076b867c"
SRC_URI[arm.sha256sum] = "dd754383ae40bbdc9917f26deae6d6aaff4060d7be79b5d6c3f7f5c6f98cfadc"
SRC_URI[kernel.md5sum] = "23845bce13640ea14183e29e4dc968cc"
SRC_URI[kernel.sha256sum] = "d3985217367845f3b7725e522d24d109d00c087037f1512e17b4c6c815656fd4"

do_compile() {
    cp ${WORKDIR}/defconfig ${SKERNEL}/.config
    KERNEL_SRC_DIR=${SKERNEL} PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}
