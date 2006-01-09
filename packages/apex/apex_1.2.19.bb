DESCRIPTION = "APEX Boot Loader"
SECTION = ""
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://wiki.buici.com/twiki/bin/view/Main/ApexBootloader"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.buici.com/pub/apex/apex-${PV}.tar.gz \
	   file://defconfig"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${CROSS_DIR}/bin/${HOST_PREFIX}"

oe_runmake() {
	#FIXME: /home/slug/openslug/tmp/cross/bin/armeb-linux- is incorrect, but
	# the cross bin directory should be on the PATH
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=/home/slug/openslug/tmp/cross/bin/armeb-linux- "$@"
	make ${PARALLEL_MAKE} LDFLAGS= CROSS_COMPILE=/home/slug/openslug/tmp/cross/bin/armeb-linux- "$@" || die "oe_runmake failed"
}

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	oe_runmake oldconfig
}

do_populate_staging() {
	install -d ${STAGING_LOADER_DIR}
	install -m 0755 src/arch-arm/rom/apex.bin ${STAGING_LOADER_DIR}/apex.bin
}
