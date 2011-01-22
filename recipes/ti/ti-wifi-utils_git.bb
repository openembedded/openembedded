DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENCE = "TI-BSD"

DEPENDS = "libnl2"

PV ="0.0"
PR_append = "+gitr${SRCPV}"

SRCREV = "6de17deb67a1313b5cc8"
SRC_URI = "git://github.com/gxk/ti-utils.git;protocol=git"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += "-I${STAGING_INCDIR}/libnl2/ -DCONFIG_LIBNL20"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 calibrator ${D}${bindir}/	
}
