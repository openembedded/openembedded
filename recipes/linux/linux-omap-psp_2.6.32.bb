require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap3evm|am3517-evm"

SRCREV = "c08d6b523f37d246440c6371e6fe26bc9f7b8674"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}/boot
	install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot/
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"


