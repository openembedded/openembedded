DESCRIPTION = "SDMA module for TI OMAP3 processors"

inherit module
# compile and run time dependencies
DEPENDS 	= "virtual/kernel perl-native"

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

PV = "2231"

# Download codec_engine_2_23_01.tar.gz from https://www-a.ti.com/downloads/sds_support/targetcontent/CE/ce_2_23/index.html and copy in Arago (or OE) download directory.

SRC_URI = "http://install.source.dir.local/codec_engine_2_23_01.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_2_23_01"

do_compile() {
    # SDMA - Build the sdma module
    # TODO :: KERNEL_CC, etc need replacing with user CC
    # TODO :: Need to understand why OBJDUMP is required for kernel module
    # Unset these since LDFLAGS gets picked up and used incorrectly.... need 
    # investigation

    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    cd ${S}/cetools/packages/ti/sdo/linuxutils/sdma
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      UCTOOL_PREFIX="${TARGET_PREFIX}" \
      clean debug release
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${S}/cetools/packages/ti/sdo/linuxutils/sdma/src/module/sdmak.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

pkg_postinst () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm () {
        update-modules || true
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/sdmak.ko"

