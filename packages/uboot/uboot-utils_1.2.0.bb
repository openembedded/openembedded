DESCRIPTION = "U-boot bootloader OS env. access tools for PPC"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "${SOURCEFORGE_MIRROR}/u-boot/u-boot-${PV}.tar.bz2" 

S = "${WORKDIR}/u-boot-${PV}"

do_configure() {
	:
}

do_compile () {
	oe_runmake Sandpoint8240_config
	oe_runmake tools
}

# install mkimage for the kernel makefile
do_stage() {
	install -d ${STAGING_BINDIR_NATIVE}
	install -m 755 ${S}/tools/mkimage ${STAGING_BINDIR_NATIVE}/
}

