DESCRIPTION = "cx3110x wifi support as found in the Nokia 800/810"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

PACKAGES = "${PN}"

FILES_${PN} += "/lib/modules/cx3110x.ko"

COMPATIBLE_MACHINE = "(nokia800|nokia810)"

S = "${WORKDIR}/cx3110x-module-src-${PV}"

SRC_URI = " \
 http://repository.maemo.org/pool/maemo4.1/free/c/cx3110x-module-src/cx3110x-module-src_2.0.15-1.tar.gz \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2 \
 http://repository.maemo.org/pool/maemo4.1/free/k/kernel-source-diablo/kernel-source-diablo_2.6.21-200823maemo6.tar.gz \
 file://cx3110x.patch;patch=1 \
 file://create_sysfs_link_for_wlan0.patch;patch=1 \
 file://fix_old_include.patch;patch=1 \
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
    export KERNEL_SRC_DIR=${WORKDIR}/kernel-source-diablo-2.6.21/kernel-source/
    PATH=${WORKDIR}/bin/:$PATH make -C ${KERNEL_SRC_DIR} CROSS_COMPILE=arm-none-eabi- nokia_2420_defconfig prepare scripts
    KERNEL_SRC_DIR=${WORKDIR}/kernel-source-diablo-2.6.21/kernel-source/ PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}

do_install() {
    install -d ${D}/lib/modules/
    install -m 0644 ${S}/src/cx3110x.ko ${D}/lib/modules/
}
