DESCRIPTION = "cx3110x wifi support as found in the Nokia 770/800"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

PACKAGES = "${PN}"

FILES_${PN} += "/lib/modules/cx3110x.ko"

COMPATIBLE_MACHINE = "(nokia770|nokia800)"

SRC_URI = "https://garage.maemo.org/frs/download.php/2443/cx3110x-0.8.1.tar.gz \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2 \
 http://dev.openbossa.org/mamona/sources/kernel-source-2.6.16.tar.gz \
 file://defconfig \
 file://fix_mem_corruption.patch;patch=1 \
 file://fix_mem_allign.patch;patch=1 \
 file://cx3110x.patch;patch=1 \
 file://fix_cross_makefile.patch;patch=1 \
 file://fix_ssid_data_length.patch;patch=1 \
 file://770_performance_improvements.patch;patch=1 \
 file://create_sysfs_link_for_wlan0.patch;patch=1 \
"
# add service file

LDFLAGS=""
BUILD_LDFLAGS=""
CFLAGS=""
BUILD_CFLAGS=""
TARGET_LDFLAGS=""

do_configure() {
}

do_compile() {
    export KERNEL_SRC_DIR=${WORKDIR}/kernel-source-2.6.16
    cp ${WORKDIR}/defconfig ${KERNEL_SRC_DIR}/.config
    KERNEL_SRC_DIR=${WORKDIR}/kernel-source-2.6.16 PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}

do_install() {
    install -d ${D}/lib/modules/
    install -m 0644 ${S}/src/cx3110x.ko ${D}/lib/modules/
}