DESCRIPTION = "ARM Kernel Shim"
SECTION = ""
PRIORITY = "optional"
HOMEPAGE = "http://wiki.buici.com/twiki/bin/view/Main/ApexBootloader"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.buici.com/pub/apex/apex-${PV}.tar.gz \
	   file://disable-commandline.patch;patch=1 \
	   file://config-nslu2.h \
	   file://config-nas100d.h"
S = ${WORKDIR}/apex-${PV}/arm-kernel-shim

EXTRA_OEMAKE_append = " CROSS_COMPILE=${CROSS_DIR}/bin/${HOST_PREFIX}"

oe_runmake() {
	# NSLU2
	cp ${WORKDIR}/config-nslu2.h ${S}/config.h
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} TOOLS=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nslu2
	make ${PARALLEL_MAKE} TOOLS=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nslu2 || die "oe_runmake failed"
	# NAS100d
	cp ${WORKDIR}/config-nas100d.h ${S}/config.h
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} TOOLS=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nas100d
	make ${PARALLEL_MAKE} TOOLS=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nas100d || die "oe_runmake failed"
}

do_populate_staging() {
	install -d ${STAGING_LOADER_DIR}
	. ${CONFIG_SITE}
	cp ${S}/arm-kernel-shim-nslu2.bin ${STAGING_LOADER_DIR}/
	cp ${S}/arm-kernel-shim-nas100d.bin ${STAGING_LOADER_DIR}/
}
