DESCRIPTION = "Builds eDMA module used by eDMA libraries for PRU sw example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "omapl138"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;proto=https;user=anonymous;pswd=''"

SRCREV = "24"
S = "${WORKDIR}/trunk/peripheral_lib/edma_driver/module"

PACKAGE_STRIP = "no"

inherit module
PR = "${MACHINE_KERNEL_PR}+svnr${SRCPV}"

# Fix silly hardcodes, module.bbclass puts in the *correct* values
do_compile_prepend() {
       sed -i 's:ARCH=arm CROSS_COMPILE=$(CSTOOL_PREFIX)::g' Makefile
}

do_install () {
        install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/pru
        install -m 0755 ${S}/edmautils.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/pru/
}

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/pru/edmautils.ko"
