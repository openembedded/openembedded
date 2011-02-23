DESCRIPTION = "Firmware files for use with Linux kernel"

PR_append = "+gitr${SRCREV}"
SRCREV = "1fbf358d5d039eab184963a9999e19aa5188cf60"

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


