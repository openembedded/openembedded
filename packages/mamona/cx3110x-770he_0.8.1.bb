PR = "r2"

KERVER = "2.6.16"

COMPATIBLE_MACHINE = "(nokia770)"

S = "${WORKDIR}/cx3110x-0.8.1"
SKERNEL = "${WORKDIR}/kernel-source-${KERVER}"

# The following require must be after S{S}, ${SKERNEL}, ${KERVER}
require cx3110x.inc

SRC_URI += "https://garage.maemo.org/frs/download.php/2443/cx3110x-0.8.1.tar.gz \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2 \
 http://dev.openbossa.org/mamona/sources/kernel-source-${KERVER}.tar.gz \
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

do_compile() {
    cp ${WORKDIR}/defconfig ${SKERNEL}/.config
    KERNEL_SRC_DIR=${SKERNEL} PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}
