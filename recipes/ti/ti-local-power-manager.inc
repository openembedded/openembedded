DESCRIPTION = "TI Local Power Manager (LPM)"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/lpm"

require ti-paths.inc
require ti-staging.inc

PROVIDES = "ti-lpm-module"

inherit module

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

S = "${WORKDIR}/local_power_manager_linux_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/lpm/${PV}/exports/local_power_manager_linux_${PV}.tar.gz;name=lpmtarball"

DEPENDS = "ti-dsplink-module"

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
# TODO install the apps and the scripts

    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${S}/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

do_stage() {
    install -d ${LPM_INSTALL_DIR}
    cp -pPrf ${S}/* ${LPM_INSTALL_DIR}
}

PACKAGES += " ti-lpm-module"
FILES_ti-lpm-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"
RDEPENDS_ti-lpm-module += " ti-dsplink-module"

# TODO add " ti-lpm-apps/scripts" package as appropriate
