DESCRIPTION = "MFP Linux utils for TI ARM/DSP processors"

BASE_SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/linuxutils/${PV}/exports"
SRC_URI = "${BASE_SRC_URI}/linuxutils_${PV}.tar.gz "

S = "${WORKDIR}/linuxutils_${PV}"

require ti-multimedia-common.inc

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

inherit module

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    case ${SOC_FAMILY} in 
    dm365)
            modules="cmem edma";;
    omap3)
            modules="cmem sdma";;
    *)
            modules="cmem"
    esac

    for module in $modules ; do
    cd ${S}/packages/ti/sdo/linuxutils/$module
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      UCTOOL_PREFIX="${TARGET_PREFIX}" \
      clean debug release
    done
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    # Install CMEM
    for module in $(find ${S}/packages/ti/sdo/linuxutils/ -name "*.ko") ; do
        install -m 0755 $module ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    done
    cd ${S}/packages/ti/sdo/linuxutils/cmem/apps
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      UCTOOL_PREFIX="${TARGET_PREFIX}" \
      EXEC_DIR="${D}${installdir}/ti-linuxutils-app/cmem-app" \
      install
    # Install EDMA
    if [ ${SOC_FAMILY} == "dm365" ] ; then
        cd ${S}/packages/ti/sdo/linuxutils/edma/apps
        make \
         LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
         MVTOOL_PREFIX="${TARGET_PREFIX}" \
         UCTOOL_PREFIX="${TARGET_PREFIX}" \
         EXEC_DIR="${D}${installdir}/ti-linuxutils-app/edma-app" \
         install
    fi
}

# stage tree - other packages may need this
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/
}

PACKAGES =+ " ti-cmem-module \
              ti-sdma-module \
              ti-edma-module \
              ti-irq-module \
              ti-linuxutils-app"

FILES_ti-cmem-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/cmem*.ko"
FILES_ti-sdma-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/sdma*.ko"
FILES_ti-edma-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/edma*.ko"
FILES_ti-irq-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/irq*.ko"

FILES_ti-linuxutils-app = "${installdir}/ti-linuxutils-app/*/*"

INSANE_SKIP_ti-linuxutils-app = "True"
INHIBIT_PACKAGE_STRIP = "1"
