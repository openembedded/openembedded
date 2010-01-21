DESCRIPTION = "LPM module for TI OMAP3 processors"

DEPENDS = "ti-linuxutils"

# tconf breaks with '.' in PWD
PV = "2_24_01"

SRC_URI = "http://install.source.dir.local/local_power_manager_1_24.tar.gz"

# Set the source directory
S = "${WORKDIR}/local_power_manager_1_24"

require ti-paths.inc

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

inherit module

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    cd ${S}/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm
    make \
      DSPLINK_REPO="${DSPLINK}/.." \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      clean default
}

do_install () {
    # LPM/CMEM/SDMA drivers - kernel modules
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
          install -m 0755 ${S}/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

RDEPENDS_${PN} += " ti-dsplink-module"

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"

INHIBIT_PACKAGE_STRIP = "1"
