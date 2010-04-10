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


SRC_URI[md5sum] = "17aeee76ca4c07887bbfea8a52d40884"
SRC_URI[sha256sum] = "62192ddf019c5d24f6538b33c9e69b6e5792bf5b0f464c0149061e2f0871108b"
