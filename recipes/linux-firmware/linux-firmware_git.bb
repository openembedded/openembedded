DESCRIPTION = "Firmware files for use with Linux kernel"

PR = "r1"
PR_append = "+gitr${SRCREV}"
SRCREV = "c2e530abf58116fbc4eb3baedeb5b3ed092b2c8a"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/dwmw2/linux-firmware.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/
	cp -RpP * ${D}/lib/firmware/

	# fixup wl12xx location
	mv ${D}/lib/firmware/ti-connectivity/* ${D}/lib/firmware 
}

PACKAGES =+ "${PN}-wl12xx"
FILES_${PN}-wl12xx = "/lib/firmware/wl12*"

FILES_${PN} += "/lib/firmware/*"
PACKAGE_ARCH = "all"


