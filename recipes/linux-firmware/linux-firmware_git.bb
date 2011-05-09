DESCRIPTION = "Firmware files for use with Linux kernel"

PR = "r2"
PR_append = "+gitr${SRCREV}"
SRCREV = "dbb6a54ba8c8d6e6673a3b86ea4c4aac78c808f0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/dwmw2/linux-firmware.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/
	cp -RpP * ${D}/lib/firmware/

	# fixup wl12xx location
	( cd ${D}/lib/firmware
	ln -sf ti-connectivity/* . )
}

PACKAGES =+ "${PN}-wl12xx"
FILES_${PN}-wl12xx = "/lib/firmware/wl12* /lib/firmware/TI* /lib/firmware/ti-connectivity"

FILES_${PN} += "/lib/firmware/*"
PACKAGE_ARCH = "all"


