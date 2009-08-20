require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap3evm"

SRCREV = "9abb6eb717acbca192ab251a056e3a66b2b47884"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=int_030000_build3 \
	   file://defconfig"

S = "${WORKDIR}/git"

SRC_URI_append = " \
	file://fix-twl-merge-damage.diff;patch=1 \
	file://fix-section-mismatch.diff;patch=1 \
	file://no-3517-hack.diff;patch=1 \
"

do_install_append() {
	install -d ${D}/boot
	install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot/
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


