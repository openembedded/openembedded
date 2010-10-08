# Builds the boot partition for a chumby Falconwing-based platform.
# Note that bootstream-chumby.bin is a binary-blob combination of
# chumby_stub, and the Freescale-provided bootlets that set up power,
# clocks, and RAM.  It is provided as a blob because Freescale provides
# elftosb2 as a blob.  If you would like to recreate these from scratch and
# are on an x86 Linux machine, you'll need the following files:
#   http://files.chumby.com/source/falconwing/bootloader/elftosb2;name=elftosb2
#   http://files.chumby.com/source/falconwing/bootloader/falconwing_chumby_sb.db;name=chumbyconfig
#   http://files.chumby.com/source/falconwing/bootloader/falconwing_factory_sb.db;name=factoryconfig
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel"
PROVIDES = "virtual/bootloader"
RPROVIDES_${PN} = "virtual/bootloader"
PR = "r6"

SRC_URI = "http://files.chumby.com/source/falconwing/build2913/bootstream-1.0.tgz;name=archive              \
           http://files.chumby.com/source/falconwing/build2913/bootstream-chumby.bin;name=bootstream        \
           file://fix-oe-build.patch                                                                        \
"
SRC_URI[archive.md5sum] = "de87fbc40f0466d5f3d3f083537f9559"
SRC_URI[archive.sha256sum] = "532101f5721eb9540fcac37bf6feb79449c4d5d66dbb7331dd1d3560c68abad9"
SRC_URI[bootstream.md5sum] = "8aa29fc431f349b22d147b5cec52927b"
SRC_URI[bootstream.sha256sum] = "8dcf12cb6f749de2e373a780b8bbcee099ec23aad212d58131750caa7360c0eb"

S = "${WORKDIR}/bootstream-1.0"

do_compile () {
    oe_runmake 'LINUX_DIR=${STAGING_KERNEL_DIR}'
}

FILES_${PN} = "/boot"

addtask deploy before do_build after do_compile

do_deploy () {
    ./config_util --cmd=create \
        --mbr=/dev/zero \
        --configname=falconwing \
        --build_ver=1000 --force --pad \
        --blockdef=${S}/output/chumby_boot.rom,215040,boot,1,0,0,0 \
        --blockdef=${S}/images/4_1.bin,153600,img1,1,0,0,0 \
        --blockdef=${S}/images/4_2.bin,153600,img2,1,0,0,0 \
        --blockdef=${S}/images/5_1.bin,153600,img3,1,0,0,0 \
        --blockdef=${S}/images/5_2.bin,153600,img4,1,0,0,0 \
        --blockdef=${S}/images/5_3.bin,153600,img5,1,0,0,0 \
        --blockdef=${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin,4194304,krnA,1,0,0,0 \
        --blockdef=${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin,4194304,krnB,1,0,0,0 \
        > ${S}/output/config_block.bin
    install -d ${DEPLOY_DIR_IMAGE}
    rm -f ${DEPLOY_DIR_IMAGE}/boot.bin
    touch ${DEPLOY_DIR_IMAGE}/boot.bin
    dd if=../bootstream-chumby.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=0 count=64
    dd if=${S}/output/config_block.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=96 count=32
    dd if=${S}/output/chumby_boot.rom of=${DEPLOY_DIR_IMAGE}/boot.bin seek=128 count=420
    dd if=${S}/images/4_1.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=548 count=300
    dd if=${S}/images/4_2.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=848 count=300
    dd if=${S}/images/5_1.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=1148 count=300
    dd if=${S}/images/5_2.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=1448 count=300
    dd if=${S}/images/5_3.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=1748 count=300
    dd if=${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=2048 count=8192
    dd if=${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin of=${DEPLOY_DIR_IMAGE}/boot.bin seek=10240 count=8192
    package_stagefile_shell ${DEPLOY_DIR_IMAGE}/boot.bin
}
