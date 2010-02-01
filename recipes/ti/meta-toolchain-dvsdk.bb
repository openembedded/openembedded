PR = "r10"

TOOLCHAIN_HOST_TASK = "task-toolchain-dvsdk-host"
TOOLCHAIN_TARGET_TASK = "task-toolchain-dvsdk-target"

require ../meta/meta-toolchain-arago.bb
require ti-paths.inc

# If we start including kernels we should change SOC_FAMILY to MACHINE_ARCH
SDK_SUFFIX = "toolchain-dvsdk-${SOC_FAMILY}-${BUILD_ARCH}"

DVSDK_TARGET_EXCLUDE_dm355 = "\
    ti-linuxutils \
    ti-dm355mm-module \
    ti-codec-combo-dm355 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm365 = "\
    ti-linuxutils \
    ti-dm365mm-module \
    ti-codec-combo-dm365 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm6446 = "\
    ti-linuxutils \
    ti-dsplink-module \
    ti-codec-combo-dm6446 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm6467 = "\
    ti-dm355mm-module \
    ti-dmai-apps \
    "


DVSDK_TARGET_EXCLUDE_omap3 = "\
    ti-linuxutils \
    ti-dsplink-module \
    ti-lpm-module \
    ti-codec-combo-omap3530 \
    ti-dmai-apps \
    "

TOOLCHAIN_TARGET_EXCLUDE += "\
    ${DVSDK_TARGET_EXCLUDE} \
    "

# Need to sed s/staging/sdksysroot/g
do_populate_sdk_append() {
       script = "${SDK_OUTPUT}/${SDKPATH}/environment-setup"
       touch $script
       echo 'export CODEC_INSTALL_DIR=${CODEC_INSTALL_DIR}' >> $script
       echo 'export CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR}' >> $script
       echo 'export XDC_INSTALL_DIR=${XDC_INSTALL_DIR}' >> $script
       echo 'export XDAIS_INSTALL_DIR=${XDAIS_INSTALL_DIR}' >> $script
       echo 'export BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR}' >> $script
       echo 'export BIOSUTILS_INSTALL_DIR=${BIOSUTILS_INSTALL_DIR}' >> $script
       echo 'export FC_INSTALL_DIR=${FC_INSTALL_DIR}' >> $script
       echo 'export CE_INSTALL_DIR=${CE_INSTALL_DIR}' >> $script
       echo 'export EDMA3_LLD_INSTALL_DIR=${EDMA3_LLD_INSTALL_DIR}' >> $script
       echo 'export LINUXUTILS_INSTALL_DIR=${LINUXUTILS_INSTALL_DIR}' >> $script
       echo 'export CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR}' >> $script
       echo 'export LINK_INSTALL_DIR=${LINK_INSTALL_DIR}' >> $script
       echo 'export LPM_INSTALL_DIR=${LPM_INSTALL_DIR}' >> $script
       echo 'export DMAI_INSTALL_DIR=${DMAI_INSTALL_DIR}' >> $script

       # Repack SDK with new environment-setup
       cd ${SDK_OUTPUT}
       fakeroot tar cfj ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.tar.bz2 .
}

