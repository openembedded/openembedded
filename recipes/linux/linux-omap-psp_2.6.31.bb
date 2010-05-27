require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap3evm|am3517-evm"

SRCREV = "9cf7a18fe227717dcc08163100dacd579de48e0c"

PV = "2.6.30+2.6.31rc7"
# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=staging \
           file://0001-implement-TIF_RESTORE_SIGMASK-support-and-enable-the.patch \
           file://defconfig"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}/boot
	install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot/
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"


