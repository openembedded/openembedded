DESCRIPTION = "Firmware files for use with Linux kernel"

PR_append = "+gitr${SRCREV}"
SRCREV = "80a203275fc368db0a5f166c42dd35a4a22f2453"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/dwmw2/linux-firmware.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/
	cp -rpP * ${D}/lib/firmware/
}

FILES_${PN} += "/lib/firmware/*"
PACKAGE_ARCH = "all"


