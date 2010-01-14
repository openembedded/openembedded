DESCRIPTION = "DSPLINK module for TI ARM/DSP processors"

require ti-paths.inc

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

inherit module

# compile and run time dependencies
DEPENDS 	+= "virtual/kernel perl-native ti-dspbios ti-cgt6x update-modules ti-xdctools"

SRC_URI = "http://install.source.dir.local/dsplink_${PV}.tar.gz \
		   file://loadmodules-ti-dsplink-apps.sh \
		   file://unloadmodules-ti-dsplink-apps.sh"

# Set the source directory
S = "${WORKDIR}/dsplink_${PV}"
	
# DSPLINK - Config Variable for different platform
DSPLINKPLATFORM_dm6446    = "DAVINCI"
DSPLINKPLATFORM_omapl137  = "OMAPL1XX"
DSPLINKPLATFORM_omapl138  = "OMAPL138"
DSPLINKPLATFORM          ?= "DAVINCI"


DSPLINKDSPCFG_dm6446    = "DM6446GEMSHMEM"
DSPLINKDSPCFG_omapl137  = "OMAPL1XXGEMSHMEM"
DSPLINKDSPCFG_omapl138  = "OMAPL138GEMSHMEM"
DSPLINKDSPCFG          ?= "DM6446GEMSHMEM"

DSPLINKGPPOS_dm355      = "LINUX_GCC"
DSPLINKGPPOS_dm365      = "LINUX_GCC"
DSPLINKGPPOS_dm6446     = "MVL5G"
DSPLINKGPPOS_omapl137   = "ARM"
DSPLINKGPPOS_omapl138   = "ARM"
DSPLINKGPPOS_omap3      = "OMAPLSP"
DSPLINKGPPOS           ?= "ARM" 

DSPLINK = "${S}/dsplink"
export DSPLINK

STAGING_TI_DSPBIOS_DIR="${BIOS_INSTALL_DIR}"
STAGING_TI_CGT6x_DIR="${CODEGEN_INSTALL_DIR}"
STAGING_TI_XDCTOOL_INSTALL_DIR="${XDC_INSTALL_DIR}"

do_configure() {

    # asm/page.h is gone with linux-libc-headers 2.6.31.
    # We can safely sed it out since it has been empty for the past 2 years
    sed -i /page.h/d ${S}/dsplink/gpp/src/api/Linux/drv_api.c || true 

    # Run perl script to create appropriate makefiles (v1.60 and up)
    (
    cd ${DSPLINK}
    perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 \
	--dspcfg_0=${DSPLINKDSPCFG} --dspos_0=DSPBIOS5XX \
	--gppos=${DSPLINKGPPOS} --comps=ponslrmc

    for i in ${DSPLINK}/gpp ${DSPLINK}/dsp ; do
        cd $i
        ${XDC_INSTALL_DIR}/xdc clean
        ${XDC_INSTALL_DIR}/xdc .interfaces 
    done
    )

}

do_compile() {
    # TODO :: KERNEL_CC, etc need replacing with user CC
    # TODO :: Need to understand why OBJDUMP is required for kernel module
    # Unset these since LDFLAGS gets picked up and used incorrectly.... need 
    # investigation

    unset CFLAGS CPPFLAGS CXXFLAGS  LDFLAGS

    # Build the gpp user space library
    cd ${DSPLINK}/gpp/src/api && make \
      CROSS_COMPILE="${TARGET_PREFIX}" \
      CC="${KERNEL_CC}" \
      AR="${KERNEL_AR}" \
      LD="${KERNEL_LD}" \
      COMPILER="${KERNEL_CC}" \
      ARCHIVER="${KERNEL_AR}" \
      KERNEL_DIR="${STAGING_KERNEL_DIR}" \
      all

    # Build the gpp kernel space (debug and release)
    cd ${DSPLINK}/gpp/src && make \
      OBJDUMP="${TARGET_PREFIX}objdump" \
      CROSS_COMPILE="${TARGET_PREFIX}" \
      CC="${KERNEL_CC}" \
      AR="${KERNEL_AR}" \
      LD="${KERNEL_LD}" \
      COMPILER="${KERNEL_CC}" \
      ARCHIVER="${KERNEL_AR}" \
      KERNEL_DIR="${STAGING_KERNEL_DIR}" \
      BASE_BUILDOS="${STAGING_KERNEL_DIR}" \
      all

    # Build the gpp samples
    cd ${DSPLINK}/gpp/src/samples
    cd ${DSPLINK}/gpp/src/samples && make \
      BASE_TOOLCHAIN="${TOOLCHAIN_PATH}" \
      BASE_CGTOOLS="${BASE_TOOLCHAIN}/bin" \
      OSINC_PLATFORM="${TOOLCHAIN_PATH}/lib/gcc/${TARGET_SYS}/$(${TARGET_PREFIX}gcc -dumpversion)/include" \
      OSINC_TARGET="${BASE_TOOLCHAIN}/target/usr/include" \
      CROSS_COMPILE="${TARGET_PREFIX}" \
      CC="${KERNEL_CC}" \
      AR="${KERNEL_AR}" \
      LD="${KERNEL_LD}" \
      COMPILER="${KERNEL_CC}" \
      LINKER="${KERNEL_CC}" \
      ARCHIVER="${KERNEL_AR}" \
      KERNEL_DIR="${STAGING_KERNEL_DIR}" \
      clean all

    # Build the dsp library (debug and release)
     cd ${DSPLINK}/dsp/src && make \
      BASE_CGTOOLS="${STAGING_TI_CGT6x_DIR}" \
      BASE_SABIOS="${STAGING_TI_DSPBIOS_DIR}" \
      clean all

    # Build the dsp samples (debug and release)
    cd ${DSPLINK}/dsp/src/samples && make \
      BASE_CGTOOLS="${STAGING_TI_CGT6x_DIR}" \
      BASE_SABIOS="${STAGING_TI_DSPBIOS_DIR}" \
      clean all
}

do_install () {
    # DSPLINK driver - kernel module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/ 

    # DSPLINK library
    install -d ${D}/${installdir}/dsplink/libs
    install -m 0755 ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/dsplink.lib  ${D}/${installdir}/dsplink/libs

    # DSPLINK sample apps
    install -d ${D}/${installdir}/dsplink/apps
    
    cp ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/*gpp ${D}/${installdir}/dsplink/apps
    
    for i in $(find ${DSPLINK}/dsp/BUILD/ -name "*.out") ; do
        cp ${i} ${D}/${installdir}/dsplink/apps
    done

    # DSPLINK test app module un/load scripts
    install ${WORKDIR}/loadmodules-ti-dsplink-apps.sh ${D}/${installdir}/dsplink/apps
    install ${WORKDIR}/unloadmodules-ti-dsplink-apps.sh ${D}/${installdir}/dsplink/apps
}

do_stage () {
    install -d ${LINK_INSTALL_DIR}
    cp -pPrf ${S}/* ${LINK_INSTALL_DIR}
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGES += " ti-dsplink-apps" 
FILES_ti-dsplink-apps = "${installdir}/dsplink/*"

# Disable QA check untils we figure out how to pass LDFLAGS in build
INSANE_SKIP_${PN} = True
INSANE_SKIP_ti-dsplink-apps = True

