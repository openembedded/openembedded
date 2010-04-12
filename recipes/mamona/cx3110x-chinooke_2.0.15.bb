PR = "r1"

KERVER = "2.6.21"

COMPATIBLE_MACHINE = "(nokia800|nokia810)"

S = "${WORKDIR}/cx3110x-module-src-2.0.15"
SKERNEL = "${WORKDIR}/kernel-source-rx-34-2.6.21.0"

# The following require must be after S{S}, ${SKERNEL}, ${KERVER}
require cx3110x.inc

SRC_URI += "\
 http://repository.maemo.org/pool/maemo4.1/free/c/cx3110x-module-src/cx3110x-module-src_2.0.15-1.tar.gz;name=archive \
 http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2;name=arm \
 http://repository.maemo.org/pool/chinook/free/k/kernel-source-rx-34/kernel-source-rx-34_2.6.21.0.orig.tar.gz;name=kernel \
 http://repository.maemo.org/pool/chinook/free/k/kernel-source-rx-34/kernel-source-rx-34_2.6.21.0-osso71.diff.gz;name=kernelpatch \
 file://cx3110x.patch;patch=1 \
 file://create_sysfs_link_for_wlan0.patch;patch=1 \
 file://fix_old_include.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "6ac5db5e602ef205200428a6612b4036"
SRC_URI[archive.sha256sum] = "20416248378cb42cb294584d9c5e4359d3d309ab8e104d62b09848f88bc7fe10"
SRC_URI[arm.md5sum] = "1709df05ed8572c6d2457af0076b867c"
SRC_URI[arm.sha256sum] = "dd754383ae40bbdc9917f26deae6d6aaff4060d7be79b5d6c3f7f5c6f98cfadc"
SRC_URI[kernel.md5sum] = "5f486ccc78c3f4c378a831a6b791961c"
SRC_URI[kernel.sha256sum] = "e445c3ad44d5b3c934a877c8d24d0e674d9bae914f08151caf9882af9cd3e62d"
SRC_URI[kernelpatch.md5sum] = "f2a893efdc2712b70ee8fbb65da2a70e"
SRC_URI[kernelpatch.sha256sum] = "f219303e60f81b3cf6206b6c1851bd42069bd018ed18482ab04dded0b4339f8a"

do_compile() {
    cd ${SKERNEL}
    patch -p1 < ${WORKDIR}/kernel-source-rx-34_2.6.21.0-osso71.diff
    cd ${S}
    PATH=${WORKDIR}/bin/:$PATH make -C ${SKERNEL} CROSS_COMPILE=arm-none-eabi- nokia_2420_defconfig prepare scripts
    KERNEL_SRC_DIR=${SKERNEL} PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}


