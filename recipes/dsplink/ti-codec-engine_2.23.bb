DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

INSANE_SKIP_ti-codec-engine-apps = True
INSANE_SKIP_ti-dsplink-apps = True
INSANE_SKIP_${PN} = True

inherit module

# disable this package for now, while we're in test mode
DEFAULT_PREFERENCE = "-1"

# tconf from xdctools dislikes '.' in pwd :/
PV = "223"

# Get CE tarball from TI website, place in sources and calculate md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_23.tar.gz \
           file://loadmodules-ti-dsplink-apps.sh \
           file://unloadmodules-ti-dsplink-apps.sh \
           file://loadmodules-ti-codec-engine-apps.sh \
           file://unloadmodules-ti-codec-engine-apps.sh \
"

S = "${WORKDIR}/codec_engine_2_23"

###########

# To build the DSP applications you need to have DSP/BIOS, xdctools and codegen installed. Get these from:
# TODO - update to bios 5.33.04.... (which is what CE was validated against)
# https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/bios_5_33_02/exports/bios_setuplinux_5_33_02.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10_03/exports/xdctools_setuplinux_3_10_03.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/LinuxDspTools/download.html
# Back link for above:
# https://www-a.ti.com/downloads/sds_support/targetcontent/index.html

# Path to the dir where the TI tools are unpacked
TITOOLSDIR ?= "/OE/TI"
TIBIOSDIR ?= "${TITOOLSDIR}/bios_5_33_02"
TIXDCTOOLSDIR ?= "${TITOOLSDIR}/xdctools_3_10_03"
TICGTOOLSDIR ?= "${TITOOLSDIR}/cg6x_6_0_16"

# CODEC ENGINE - This tells codec engine which targets to build
CEEXAMPLESDEVICES ?= "DM6446"
CEEXAMPLESDEVICES_omap5912osk = "fixme-ti-paths.inc"
CEEXAMPLESDEVICES_armv7a = "OMAP3530"
CEEXAMPLESDEVICES_omap3evm = "OMAP3530"
CEEXAMPLESDEVICES_beagleboard = "OMAP3530"
CEEXAMPLESDEVICES_davinci-sffsdr = "DM6446"
CEEXAMPLESDEVICES_davinci-dvevm = "DM6446"

# DSPLINK - Config Variable for different platform
DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_omap5912osk = "OMAP"
DSPLINKPLATFORM_armv7a = "OMAP3530"
DSPLINKPLATFORM_beagleboard = "OMAP3530"
DSPLINKPLATFORM_omap3evm = "OMAP3530"
DSPLINKPLATFORM_davinci-sffsdr = "DAVINCI"
DSPLINKPLATFORM_davinci-dvevm = "DAVINCI"

DSPLINKDSPCFG ?= "DM6446GEMSHMEM"
DSPLINKDSPCFG_armv7a ?= "OMAP3530SHMEM"
DSPLINKDSPCFG_beagleboard ?= "OMAP3530SHMEM"
DSPLINKDSPCFG_omap3evm ?= "OMAP3530SHMEM"

DSPLINKGPPOS ?= "MVL5G"
DSPLINKGPPOS_armv7a = "OMAPLSP"
DSPLINKGPPOS_beagleboard = "OMAPLSP"
DSPLINKGPPOS_omap3evm = "OMAPLSP"

# LPM
LPMDSPPOWERSOC ?= "dm6446"
LPMDSPPOWERSOC_armv7a = "omap3530"
LPMDSPPOWERSOC_beagleboard = "omap3530"
LPMDSPPOWERSOC_omap3evm = "omap3530"

############

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""

do_configure () {
    # Clean up stale binaries
    find ${S} -name "*.ko" -exec rm {} \; || true
    find ${S} -name "*.o" -exec rm {} \; || true

    # Run perl script to create appropriate makefiles (v1.60 and up)
    (
    cd ${DSPLINK}
    perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=${DSPLINKDSPCFG} --dspos_0=DSPBIOS5XX  --gppos=${DSPLINKGPPOS} --comps=ponslrm
    )
}

do_compile () {
    unset DISPLAY

# DSPLINK
    # TODO :: KERNEL_CC, etc need replacing with user CC
    # TODO :: Need to understand why OBJDUMP is required for kernel module

    # Unset these since LDFLAGS gets picked up and used incorrectly.... need investigation
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    # Build the gpp user space library
    cd ${DSPLINK}/gpp/src/api
    make \
      CROSS_COMPILE="${TARGET_PREFIX}" \
      CC="${KERNEL_CC}" \
      AR="${KERNEL_AR}" \
      LD="${KERNEL_LD}" \
      COMPILER="${KERNEL_CC}" \
      ARCHIVER="${KERNEL_AR}" \
      KERNEL_DIR="${STAGING_KERNEL_DIR}" \
      clean all

    # Build the gpp kernel space (debug and release)
    cd ${DSPLINK}/gpp/src
    make \
      OBJDUMP="${TARGET_PREFIX}objdump" \
      CROSS_COMPILE="${TARGET_PREFIX}" \
      CC="${KERNEL_CC}" \
      AR="${KERNEL_AR}" \
      LD="${KERNEL_LD}" \
      COMPILER="${KERNEL_CC}" \
      ARCHIVER="${KERNEL_AR}" \
      KERNEL_DIR="${STAGING_KERNEL_DIR}" \
      clean all

    # Build the gpp samples
    cd ${DSPLINK}/gpp/src/samples
    make \
      BASE_TOOLCHAIN="${CROSS_DIR}" \
      BASE_CGTOOLS="${BASE_TOOLCHAIN}/bin" \
      OSINC_PLATFORM="${CROSS_DIR}/lib/gcc/${TARGET_SYS}/$(${TARGET_PREFIX}gcc -dumpversion)/include" \
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
    cd ${DSPLINK}/dsp/src
    make \
      BASE_CGTOOLS="${TICGTOOLSDIR}" \
      BASE_SABIOS="${TIBIOSDIR}" \
      clean all

    # Build the dsp samples (debug and release)
    cd ${DSPLINK}/dsp/src/samples
    make \
      BASE_CGTOOLS="${TICGTOOLSDIR}" \
      BASE_SABIOS="${TIBIOSDIR}" \
      clean all

    # LPM - Build the DSP power manager kernel module
    cd ${S}/cetools/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm
    make \
      DSPLINK_REPO="${DSPLINK}/.." \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      .clean default

    # CMEM - Build the cmem kernel module and associated test apps
    # TODO - Still need to clean up UCTOOLs - don't really want to build UC here - it's not good to just build with MVTOOLS (GLIBC) 
    # - note target default, doesn't get passed through to underlying makefiles
    cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      UCTOOL_PREFIX="${TARGET_PREFIX}" \
      clean debug release

    # SDMA - Build the sdma module
    cd ${S}/cetools/packages/ti/sdo/linuxutils/sdma
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}" \
      UCTOOL_PREFIX="${TARGET_PREFIX}" \
      clean debug release

    # TODO - add other modules here, like IRQ, etc for DM6446/DM355/etc

    # CE - EXAMPLES
    # Now build the CE examples
    cd ${S}/examples

    # Fix paths to arm crosstools, c6x codegen and x86 gcc
    # Also disable uclibc and x86 builds
    # Nasty replacement of 674x build - hard to sed this, since 2 entries similar, hence uses leading spaces...
    sed -i \
      -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3:${CROSS_DIR}:g \
      -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TICGTOOLSDIR}:g \
      -e s:/db/toolsrc/library/tools/vendors/opensource/gcc/4.1.0/Linux/gcc-4.1.0-glibc-2.3.6/i686-unknown-linux-gnu:/usr:g \
      -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
      -e 's:true, // build for uC Linux:false,:g' \
      -e 's:true,  // build for PC Linux:false,:g' \
      -e 's:              {doBuild\: true, // DSP builds:              {doBuild\: false, // DSP builds:g' \
      ${S}/examples/user.bld

    # For now, remove all targets, except omap3530 - nasty way to configure targets...
    sed -i \
      -e '/evmDM357/d' \
      -e '/evmDM6446/d' \
      -e '/evmDM6467/d' \
      -e '/evmDM355/d' \
      -e '/evmDM6437/d' \
      -e '/evmDM648/d' \
      -e '/evmDM365/d' \
      -e '/evmOMAPL137/d' \
      -e '/sdp3430/d' \
      -e '/evm2530/d' \
      ${S}/examples/user.bld

    # Start building the CE examples: codecs, extensions, servers (codec bundles) and ARM side apps 
    # TODO : Make clean doesn't do what you'd expect, it only cleans stuff you've enabled, so some cruft remains
    # TODO : Figure out how to pass PRODUCTS=... or alternative method, so that we don't build the 'local' versions   
    for i in codecs extensions servers apps ; do
        make \
          DEVICES="${CEEXAMPLESDEVICES}" \
          CE_INSTALL_DIR="${S}" \
          XDC_INSTALL_DIR="${TIXDCTOOLSDIR}" \
          BIOS_INSTALL_DIR="${TIBIOSDIR}" \
          CC_V5T="bin/${TARGET_PREFIX}gcc" \
          CGTOOLS_V5T="${CROSS_DIR}" \
          CGTOOLS_C64P="${TICGTOOLSDIR}" \ 
          -C ${S}/examples/ti/sdo/ce/examples/$i \
         clean 
#all
    done    
}

do_install () {
    # DSPLINK driver - kernel module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    cp ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/ 

    # DSPLINK library
    install -d ${D}/${libdir}
    install -m 0755 ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/dsplink.lib  ${D}/${libdir}

    # DSPLINK sample apps
    install -d ${D}/${datadir}/ti-dsplink
    install ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE/*gpp ${D}/${datadir}/ti-dsplink || true
    for i in $(find ${DSPLINK}/dsp/BUILD/ -name "*.out") ; do
        install ${i} ${D}/${datadir}/ti-dsplink
    done

    # DSPLINK test app module un/load scripts
    install ${WORKDIR}/loadmodules-ti-dsplink-apps.sh ${D}/${datadir}/ti-dsplink
    install ${WORKDIR}/unloadmodules-ti-dsplink-apps.sh ${D}/${datadir}/ti-dsplink

    # LPM/CMEM/SDMA drivers - kernel modules
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
        cp ${S}/cetools/packages/ti/bios/power/modules/${LPMDSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
    cp ${S}/cetools/packages/ti/sdo/linuxutils/cmem/src/module/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
        cp ${S}/cetools/packages/ti/sdo/linuxutils/sdma/src/module/sdmak.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true

    # CE sample apps - this is very 64x / v5T specific at the moment - we really need CE to give us this list...
    install -d ${D}/${datadir}/ti-codec-engine

    # we change pwd so that find gives us relative path to the files, which we use to create the same structure on the target
    cd ${S}/examples/ti/sdo/ce

    # first find all the app files named '.out'
    for i in $(find . -name "*.out") ; do
        # first create the directory
        install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
        # now copy the file     
        install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
    done

    # next find all the app files named '.xv5T'
    for i in $(find . -name "*.xv5T") ; do
        # first create the directory
        install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
        # now copy the file     
        install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
    done

    # then find all the app/server files named '.x64P'
    for i in $(find . -name "*.x64P") ; do
        # first create the directory
        install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
        # now copy the file     
        install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
    done

    # finally find all the app files named '.dat'
    for i in $(find . -name "*.dat") ; do
        # first create the directory
        install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
        # now copy the file     
        install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
    done

    # CE test app module un/load scripts
    install ${WORKDIR}/loadmodules-ti-codec-engine-apps.sh ${D}/${datadir}/ti-codec-engine
    install ${WORKDIR}/unloadmodules-ti-codec-engine-apps.sh ${D}/${datadir}/ti-codec-engine

    # we should install the CMEM apps as well here
        # - TODO...

    # finally, strip targets that we're not supporting here
    # - TODO...
}

# Codec Engine and friends need a complete tree, so stage it all - possibly could use repoman for this later
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/ 
}

PACKAGES =+ "ti-dsplink-module ti-dsplink-apps"
PACKAGES =+ "ti-lpm-module ti-cmem-module ti-sdma-module ti-codec-engine-apps"

FILES_ti-dsplink-module  = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/dsplinkk.ko"
FILES_ti-dsplink-apps = "${datadir}/ti-dsplink/* ${libdir}/dsplink.lib"
FILES_ti-lpm-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"
FILES_ti-cmem-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/cmemk.ko"
FILES_ti-sdma-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/sdmak.ko"
FILES_ti-codec-engine-apps = "${datadir}/ti-codec-engine/*"

pkg_postinst_ti-dsplink-module () {
    if [ -n "$D" ]; then
        exit 1
    fi
    depmod -a
    update-modules || true
}

pkg_postrm_ti-dsplink-module () {
    update-modules || true
}

pkg_postinst_ti-lpm-module () {
    if [ -n "$D" ]; then
        exit 1
    fi
    depmod -a
    update-modules || true
}

pkg_postrm_ti-lpm-module () {
    update-modules || true
}

pkg_postinst_ti-cmem-module () {
    if [ -n "$D" ]; then        
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-cmem-module () {
        update-modules || true
}

pkg_postinst_ti-sdma-module () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-sdma-module () {
        update-modules || true
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#legacy upgrade helpers
RPROVIDES_ti-dsplink-module += "dsplink-module"
RREPLACES_ti-dsplink-module += "dsplink-module"
RPROVIDES_ti-dsplink-apps += "dsplink-apps"
RREPLACES_ti_dsplink-apps += "dsplink-apps"
RPROVIDES_ti-cmem-module += "ti-cmemk-module"
RREPLACES_ti-cmem-module += "ti-cmemk-module"

#run-time dependencies - note for kernel module we can only use RRECOMMENDS, since modules might be built into the kernel
#and dependence on recipe version, so that we ensure apps and modules stay syncd
RRECOMMENDS_ti-dsplink-apps += "ti-dsplink-module (>= ${PV}-${PR})"
RRECOMMENDS_ti-codec-engine-apps += "ti-dsplink-module (>= ${PV}-${PR}) ti-lpm-module (>= ${PV}-${PR}) ti-cmem-module (>= ${PV}-${PR}) ti-sdma-module (>= ${PV}-${PR})"


