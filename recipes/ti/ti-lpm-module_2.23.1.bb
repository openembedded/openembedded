DESCRIPTION = "LPM module for TI OMAP3 processors"

require ti-paths.inc
inherit module
# compile and run time dependencies
DEPENDS 	= " virtual/kernel perl-native ti-dsplink-module"

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

PV = "2231"

# Download codec_engine_2_23_01.tar.gz from https://www-a.ti.com/downloads/sds_support/targetcontent/CE/ce_2_23/index.html and copy in Arago (or OE) download directory.

SRC_URI = "http://install.source.dir.local/codec_engine_2_23_01.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_2_23_01"

export DSPLINK="${S}/cetools/packages/dsplink"

LPMDSPPOWERSOC 				 ?= "omap3530"
LPMDSPPOWERSOC_omap3evm 	 ?= "omap3530"

do_compile () {
    # TODO :: KERNEL_CC, etc need replacing with user CC
    # TODO :: Need to understand why OBJDUMP is required for kernel module
    # Unset these since LDFLAGS gets picked up and used incorrectly.... need 
    # investigation

    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    cd ${S}/cetools/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm
    make \
      DSPLINK_REPO="${DSPLINK}/.." \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      clean default
}

do_install () {

    # LPM/CMEM/SDMA drivers - kernel modules
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	  install -m 0755 ${S}/cetools/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
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

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"
RDEPENDS += " ti-dsplink-module"

