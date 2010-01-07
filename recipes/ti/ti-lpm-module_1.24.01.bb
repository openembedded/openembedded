DESCRIPTION = "LPM module for TI OMAP3 processors"

DEPENDS = "ti-linuxutils ti-dsplink-module"

# tconf breaks with '.' in PWD
PV = "1_24_01"
PE = "1"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/lpm/${PV}/exports/local_power_manager_linux_${PV}.tar.gz;name=lpmtarball"

SRC_URI[lpmtarball.md5sum] = "6699861c8d0195654c539798ec428124"
SRC_URI[lpmtarball.sha256sum] = "052b31b09e6d85bc1e980f5e3d2350019c2d8d7430d24db60854dc926df9a1f2"

# Set the source directory
S = "${WORKDIR}/local_power_manager_linux_${PV}"

require ti-paths.inc

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

inherit module

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    cd ${S}/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm
    make \
      DSPLINK_REPO="${LINK_INSTALL_DIR}" \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      clean default
}

do_install () {
    # LPM/CMEM/SDMA drivers - kernel modules
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
          install -m 0755 ${S}/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

# stage tree - other packages may need this
do_stage() {
    install -d ${LPM_INSTALL_DIR}
    cp -pPrf ${S}/* ${LPM_INSTALL_DIR}
}

RDEPENDS_${PN} += " ti-dsplink-module"

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"

INHIBIT_PACKAGE_STRIP = "1"
