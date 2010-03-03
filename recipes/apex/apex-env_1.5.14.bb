DESCRIPTION = "APEX Boot Loader Environment User Modification Tool"
SECTION = "misc"
PRIORITY = "optional"
HOMEPAGE = "http://wiki.buici.com/twiki/bin/view/Main/ApexBootloader"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.buici.com/pub/apex/apex-${PV}.tar.gz \
	file://find-apex-partition.patch;patch=1 \
	"
S = ${WORKDIR}/apex-${PV}/usr

EXTRA_OEMAKE_append = " CROSS_COMPILE=${CROSS_DIR}/bin/${HOST_PREFIX}"

oe_runmake() {
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} "$@"
	make ${PARALLEL_MAKE} LDFLAGS= CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} "$@" || die "oe_runmake failed"
}

do_install() {
	${STRIP} ${S}/apex-env
	install -d ${D}/${sbindir}
	install -m 755 ${S}/apex-env ${D}/${sbindir}
}

# Adding proper LDFLAGS support takes too much of my time, so hack around it
INSANE_SKIP_${PN} = True

