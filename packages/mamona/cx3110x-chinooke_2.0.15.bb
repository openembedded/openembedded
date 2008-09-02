PR = "r1"

KERVER = "2.6.21"

COMPATIBLE_MACHINE = "(nokia800|nokia810)"

S = "${WORKDIR}/cx3110x-module-src-2.0.15"
SKERNEL = "${WORKDIR}/kernel-source-rx-34-2.6.21.0"

# The following require must be after S{S}, ${SKERNEL}, ${KERVER}
require cx3110x.inc

SRC_URI += "\
 http://repository.maemo.org/pool/maemo4.1/free/c/cx3110x-module-src/cx3110x-module-src_2.0.15-1.tar.gz \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2 \
 http://repository.maemo.org/pool/chinook/free/k/kernel-source-rx-34/kernel-source-rx-34_2.6.21.0.orig.tar.gz \
 http://repository.maemo.org/pool/chinook/free/k/kernel-source-rx-34/kernel-source-rx-34_2.6.21.0-osso71.diff.gz \
 file://cx3110x.patch;patch=1 \
 file://create_sysfs_link_for_wlan0.patch;patch=1 \
 file://fix_old_include.patch;patch=1 \
"

do_compile() {
    cd ${SKERNEL}
    patch -p1 < ${WORKDIR}/kernel-source-rx-34_2.6.21.0-osso71.diff
    cd ${S}
    PATH=${WORKDIR}/bin/:$PATH make -C ${SKERNEL} CROSS_COMPILE=arm-none-eabi- nokia_2420_defconfig prepare scripts
    KERNEL_SRC_DIR=${SKERNEL} PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}


