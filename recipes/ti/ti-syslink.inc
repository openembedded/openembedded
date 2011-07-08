DESCRIPTION = "SYSLINK Inter-Processor Communications (IPC) for TI ARM/DSP processors"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/syslink/index.html"
SECTION = "devel"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://docs/bsd.pdf;md5=9f2edd962cd129f8c24e9ef1bd641029"

# TODO :: multi-machine, add m3 build as well?
# TODO :: proper staging?
# TODO :: kernel module examples?
# TODO :: smarter handling of config.bld
# TODO :: review XDC parallel make - why not happening automatically?
# TODO :: smarter suffix management

require ti-paths.inc
require ti-staging.inc

PROVIDES = "ti-syslink-module"
PROVIDES += "ti-syslink-examples"

# This package builds a kernel module, use kernel PR as base and append a local version
PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"
PVExtra = ""

inherit module pkgconfig

S = "${WORKDIR}/syslink_${PV}${PVExtra}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/syslink/${PV}${PVExtra}/exports/syslink_${PV}${PVExtra}.tar.gz;name=syslinktarball \
           file://syslink.pc \
          "

DEPENDS = "ti-sysbios ti-xdctools ti-cgt6x ti-ipc"
DEPENDS += "virtual/kernel" 

#common frameq gateMP heapBufMP heapMemMP knlNotify listMP messageQ notify ringIO ringIO_gpp sharedRegion slaveLoader tilerDaemon
SYSLINKHLOSSAMPLES = "knlnotify slaveLoader frameq notify"
#SYSLINKRTOSSAMPLES = "frameq gateMP heapBufMP heapMemMP listMP messageQ notify ringIO ringIO_gpp sharedRegion"

# SOC_FAMILY configuration

SYSLINKPLATFORM_omap3     = "OMAP3530"
SYSLINKPLATFORM_omapl137  = "OMAPL1XX"
SYSLINKPLATFORM_omapl138  = "OMAPL1XX"
SYSLINKPLATFORM_ti816x    = "TI81XX"
SYSLINKPLATFORM_ti814x    = "TI81XX"
SYSLINKPLATFORM          ?= "<UNDEFINED_SYSLINKPLATFORM>"

SYSLINKVARIANT_omap3     = "OMAP3530"
SYSLINKVARIANT_omapl137  = "OMAPL1XX"
SYSLINKVARIANT_omapl138  = "OMAPL1XX"
SYSLINKVARIANT_ti816x    = "TI816X"
SYSLINKVARIANT_ti814x    = "TI814X"
SYSLINKVARIANT          ?= "<UNDEFINED_SYSLINKVARIANT>"

# COFF/ELF config - omap3 can be coff/elf, omapl only coff, ti816x and ti814x only elf

# this really needs to be a list... in the case of ELF/COFF (and this could use DSPSUFFIX?)
SYSLINKSUFFIX_omap3       = "x64P"
SYSLINKSUFFIX_omapl137    = "x674"
SYSLINKSUFFIX_omapl138    = "x674"
SYSLINKSUFFIX_ti816x      = "xe674"
SYSLINKSUFFIX_ti814x      = "xe674"
SYSLINKSUFFIX            ?= "<UNDEFINED_SYSLINKSUFFIX>"

SYSLINKLOADER_omap3       = "COFF"
SYSLINKLOADER_omapl137    = "COFF"
SYSLINKLOADER_omapl138    = "COFF"
SYSLINKLOADER_ti816x      = "ELF"
SYSLINKLOADER_ti814x      = "ELF"
SYSLINKLOADER            ?= "<UNDEFINED_SYSLINKLOADER>"

# Do we really need to configure this? - configured already in config.bld
XDCTARGETS_omap3          = "ti.targets.C64P"
XDCTARGETS_omapl137       = "ti.targets.C674"
XDCTARGETS_omapl138       = "ti.targets.C674"
# for ti816x and ti814x, we should later also build for ti.targets.arm.elf.M3
XDCTARGETS_ti816x         = "ti.targets.elf.C674 ti.targets.arm.elf.M3"
XDCTARGETS_ti814x         = "ti.targets.elf.C674 ti.targets.arm.elf.M3"
XDCTARGETS               ?= "<UNDEFINED_XDCTARGETS>"
export XDCTARGETS

# Exported Variable needed by build
export SYSLINK_ROOT = "${S}/packages/"

export XDCPATH = "${IPC_INSTALL_DIR}/packages;${SYSBIOS_INSTALL_DIR}/packages" 

do_configure() {
    sed -i -e s:@VERSION@:${PV}:g ${WORKDIR}/syslink.pc
    
    cp ${WORKDIR}/syslink.pc ${S}
}

do_prepsources () {
	
    # Prepare the tree for rebuiling - clean and generate interfaces
    cd ${SYSLINK_ROOT}/ti/syslink    
    ${XDC_INSTALL_DIR}/xdc --jobs=${BB_NUMBER_THREADS} .make -PR .
    ${XDC_INSTALL_DIR}/xdc --jobs=${BB_NUMBER_THREADS} clean -PR .
    ${XDC_INSTALL_DIR}/xdc --jobs=${BB_NUMBER_THREADS} .interfaces -PR .
}

addtask prepsources after do_configure before do_compile

do_compile() {
    # TODO :: KERNEL_CC, should use for kernel module build?
    # TODO :: Check the 'unset's

    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

#    do_make_scripts

    # Build the gpp (hlos) kernel space
    cd ${SYSLINK_ROOT}/ti/syslink/utils/hlos/knl/Linux && make \
        ARCH="${TARGET_ARCH}" \
        CROSS_COMPILE="${TARGET_PREFIX}" \
        SYSLINK_PLATFORM="${SYSLINKPLATFORM}" \
        SYSLINK_VARIANT="${SYSLINKVARIANT}" \
        SYSLINK_LOADER="${SYSLINKLOADER}" \
        SYSLINK_PKGPATH="${IPC_INSTALL_DIR}/packages" \
        KDIR="${STAGING_KERNEL_DIR}"

#    # Build the gpp (hlos) kernel space samples. 
#    for sample in ${SYSLINKHLOSSAMPLES}; do
#        cd ${SYSLINK_ROOT}/ti/syslink/samples/hlos/$sample/knl/Linux && make \
#            ARCH="${TARGET_ARCH}" \
#            CROSS_COMPILE="${TARGET_PREFIX}" \
#            SYSLINK_PLATFORM="${SYSLINKPLATFORM}" \
#            SYSLINK_VARIANT="${SYSLINKVARIANT}" \
#            SYSLINK_LOADER="${SYSLINKLOADER}" \
#            SYSLINK_PKGPATH="${IPC_INSTALL_DIR}/packages" \
#            SYSLINK_SDK=EZSDK \
#            KDIR="${STAGING_KERNEL_DIR}"
#    done

    # Build the gpp (hlos) user space
    cd ${SYSLINK_ROOT}/ti/syslink/utils/hlos/usr/Linux && make \
        ARCH="${TARGET_ARCH}" \
        CROSS_COMPILE="${TARGET_PREFIX}" \
        TOOLCHAIN_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
        SYSLINK_PLATFORM="${SYSLINKPLATFORM}" \
        SYSLINK_VARIANT="${SYSLINKVARIANT}" \
        SYSLINK_LOADER="${SYSLINKLOADER}" \
        SYSLINK_PKGPATH="${IPC_INSTALL_DIR}/packages"

    # Build the gpp (hlos) user space samples 
    # First build the common lib for samples.
    cd ${SYSLINK_ROOT}/ti/syslink/samples/hlos/common/usr/Linux && make \
        ARCH="${TARGET_ARCH}" \
        CROSS_COMPILE="${TARGET_PREFIX}" \
        TOOLCHAIN_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
        SYSLINK_PLATFORM="${SYSLINKPLATFORM}" \
        SYSLINK_VARIANT="${SYSLINKVARIANT}" \
        SYSLINK_LOADER="${SYSLINKLOADER}" \
        SYSLINK_SDK=EZSDK \
        SYSLINK_PKGPATH="${IPC_INSTALL_DIR}/packages"

    for sample in ${SYSLINKHLOSSAMPLES}; do
        cd ${SYSLINK_ROOT}/ti/syslink/samples/hlos/$sample/usr/Linux && make \
            ARCH="${TARGET_ARCH}" \
            CROSS_COMPILE="${TARGET_PREFIX}" \
            TOOLCHAIN_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
            SYSLINK_PLATFORM="${SYSLINKPLATFORM}" \
            SYSLINK_VARIANT="${SYSLINKVARIANT}" \
            SYSLINK_LOADER="${SYSLINKLOADER}" \
            SYSLINK_SDK=EZSDK \
            SYSLINK_PKGPATH="${IPC_INSTALL_DIR}/packages"
    done

    # Build the dsp/arm (rtos) code (system and samples)
    # cd ${SYSLINK_ROOT}/ti/syslink && \
    #     ${XDC_INSTALL_DIR}/xdc --jobs=${BB_NUMBER_THREADS} -PR .
    export XDCOPTIONS=v
    cd ${SYSLINK_ROOT}/ti/syslink && \
        ${XDC_INSTALL_DIR}/xdc -P \
	 `${XDC_INSTALL_DIR}/bin/xdcpkg ${SYSLINK_ROOT}/ti/syslink | grep -v samples`
    export XDCARGS="profile=debug"
    cd ${SYSLINK_ROOT}/ti/syslink && \
        ${XDC_INSTALL_DIR}/xdc --jobs=${BB_NUMBER_THREADS} -P \
	 `${XDC_INSTALL_DIR}/bin/xdcpkg ${SYSLINK_ROOT}/ti/syslink | grep samples`
}

KERNEL_VERSION = "${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')}"

do_install () {

    # Install the hlos kernel module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${SYSLINK_ROOT}/ti/syslink/bin/${SYSLINKVARIANT}/syslink.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/

    # Install the hlos example kernel modules and apps
    install -d ${D}/${installdir}/ti-syslink-examples
    install -m 0755 ${SYSLINK_ROOT}/ti/syslink/bin/${SYSLINKVARIANT}/samples/* ${D}/${installdir}/ti-syslink-examples/

    # Install the rtos example apps 
    install -d ${D}/${installdir}/ti-syslink-examples/dsp
    cd ${SYSLINK_ROOT}/ti/syslink/samples/rtos
    for i in $(find . -name "*.${SYSLINKSUFFIX}" | grep ${SOC_FAMILY}); do
        install ${i} ${D}/${installdir}/ti-syslink-examples/dsp/
    done

    # TODO :: Fixup - library/headers installation - this shouldn't go into the examples directory....
    # Needs proper staging
    # Install the library in the filesystem
    # install -d ${D}/${installdir}/ti-syslink-examples
    # install -m 0755 ${SYSLINK_ROOT}/ti/syslink/lib/syslink.a ${D}/${installdir}/ti-syslink-examples/
    
    # Install/Stage the Source Tree
    install -d ${D}${SYSLINK_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${SYSLINK_INSTALL_DIR_RECIPE}
   
    install -d ${D}/${libdir}/pkgconfig
    install ${S}/syslink.pc ${D}/${libdir}/pkgconfig/
}

PACKAGES =+ "ti-syslink-module"
FILES_ti-syslink-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/syslink.ko" 
RDEPENDS_ti-syslink-module += "update-modules"

pkg_postinst_ti-syslink-module () {
#!/bin/sh
if [ -n "$D" ]; then
	exit 1
fi

depmod -a
update-modules || true
}

pkg_postrm_ti-syslink-module () {
#!/bin/sh
update-modules || true
}

PACKAGES =+ "ti-syslink-examples"
RRECOMMENDS_ti-syslink-examples_append = " ti-syslink-module"
FILES_ti-syslink-examples = "${installdir}/ti-syslink-examples/*"
INSANE_SKIP_ti-syslink-examples = True

FILES_ti-syslink-dev = "${libdir}/*"
