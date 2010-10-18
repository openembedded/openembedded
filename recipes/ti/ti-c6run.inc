DESCRIPTION = "TI C6Run - DSP Code Development for ARM/Linux Users"
HOMEPAGE = "https://gforge.ti.com/gf/project/dspeasy/"

SECTION = "devel"
LICENSE = "BSD"

require ti-paths.inc
require ti-staging.inc

PROVIDES += "ti-c6run-apps"

PR = "r1"

SRC_URI = "svn://gforge.ti.com/svn/dspeasy/;module=tags/${PV};proto=https;user=anonymous;pswd=''"

SRCREV="head"

S = "${WORKDIR}/tags/${PV}/"

DEPENDS = "ti-xdctools ti-linuxutils ti-dspbios ti-dsplink ti-cgt6x "
DEPENDS_append_omap3 = "ti-local-power-manager"

# PLATFORM Definitions
C6RUNPLATFORMS_omapl137      = "omapl137"
C6RUNPLATFORMS_omapl138      = "omapl138"
C6RUNPLATFORMS_omap3evm      = "omap3530"
C6RUNPLATFORMS_dm37x-evm     = "dm3730"
C6RUNPLATFORMS_hawkboard     = "hawkboard"
C6RUNPLATFORMS_beagleboard   = "beagleboard"
C6RUNPLATFORMS              ?= "<UNDEFINED_C6RUNPLATFORMS>"

C6RUNDSPREGIONBASEADDR_omapl137    = "0xC2000000"
C6RUNDSPREGIONBASEADDR_omapl138    = "0xC2000000"
C6RUNDSPREGIONBASEADDR_omap3       = "0x86300000"
C6RUNDSPREGIONBASEADDR_hawkboard   = "0xC6000000"
C6RUNDSPREGIONBASEADDR            ?= "<UNDEFINED_C6RUNDSPREGIONBASEADDR>"

C6RUNDSPREGIONCMEMSIZE_omapl137    = "0x01000000"
C6RUNDSPREGIONCMEMSIZE_omapl138    = "0x01000000"
C6RUNDSPREGIONCMEMSIZE_omap3       = "0x01000000"
C6RUNDSPREGIONCMEMSIZE_hawkboard   = "0x01000000"
C6RUNDSPREGIONCMEMSIZE            ?= "<UNDEFINED_C6RUNDSPREGIONCMEMSIZE>"

C6RUNDSPREGIONCODESIZE_omapl137    = "0x01000000"
C6RUNDSPREGIONCODESIZE_omapl138    = "0x01000000"
C6RUNDSPREGIONCODESIZE_omap3       = "0x00D00000"
C6RUNDSPREGIONCODESIZE_hawkboard   = "0x01000000"
C6RUNDSPREGIONCODESIZE            ?= "<UNDEFINED_C6RUNDSPREGIONCODESIZE>"


do_configure() {
    # Run config with correct platform
    cd ${S}
    make \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \  
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \  
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
    LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
    ARM_TOOLCHAIN_PATH="${TOOLCHAIN_PATH}" \
    ARM_TOOLCHAIN_PREFIX="${TARGET_PREFIX}" \
    DSP_REGION_BASE_ADDR="${C6RUNDSPREGIONBASEADDR}" \
    DSP_REGION_CMEM_SIZE="${C6RUNDSPREGIONCMEMSIZE}" \
    DSP_REGION_CODE_SIZE="${C6RUNDSPREGIONCODESIZE}" \
    ${C6RUNPLATFORMS}_config
}

do_prepsources() {

    # Clean the DSP/GPP backend libraries
    cd ${S}
    make \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
    LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
    ARM_TOOLCHAIN_PATH="${TOOLCHAIN_PATH}" \
    ARM_TOOLCHAIN_PREFIX="${TARGET_PREFIX}" \
    clean
}

addtask prepsources after do_configure before do_compile

do_compile() {
    # Build C6Run backend libraries (no kernel modules)
    cd ${S}
    make \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
    LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
    ARM_TOOLCHAIN_PATH="${TOOLCHAIN_PATH}" \
    ARM_TOOLCHAIN_PREFIX="${TARGET_PREFIX}" \
    oe_build

    # Build example apps and test cases
    make \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
    LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
    ARM_TOOLCHAIN_PATH="${TOOLCHAIN_PATH}" \
    ARM_TOOLCHAIN_PREFIX="${TARGET_PREFIX}" \
    C6RUN_TOOLCHAIN_PATH="${S}" \
    examples tests
}

do_install() {
    # Install the host package
    install -d ${D}${C6RUN_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${C6RUN_INSTALL_DIR_RECIPE}

    # Install the target package
    install -d ${D}/${installdir}/c6run-apps
    make INSTALL_DIR=${D}/${installdir}/c6run-apps  install_programs

    # remove prebuilt *.ko files
    rm -rf ${D}/${installdir}/c6run_apps/*.ko
}

PACKAGES += "ti-c6run-apps"

FILES_ti-c6run-apps = "${installdir}/c6run-apps/*"
INSANE_SKIP_ti-c6run-apps = "True"

RRECOMMENDS_ti-c6run-apps += "ti-cmem-module ti-dsplink-module"
