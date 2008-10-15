DESCRIPTION = "U-boot bootloader mkimage utility"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPL"
ALLOW_EMPTY = "1"
PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2"

S = "${WORKDIR}/u-boot-${PV}"

inherit native

do_configure() {
	:
}

do_compile () {
	oe_runmake Sandpoint8240_config
	oe_runmake tools
}

# install mkimage for the kernel makefile
do_stage() {
	install -m 0755 tools/mkimage ${STAGING_BINDIR_NATIVE}/
}

