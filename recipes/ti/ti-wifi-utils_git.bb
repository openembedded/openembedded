DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENCE = "TI-BSD"

DEPENDS = "libnl"

PR ="r1"
PV ="0.0"
PR_append = "+gitr${SRCPV}"

SRCREV = "7f63af54eb66e5b2515f92c59fcc19a8065ce481"
SRC_URI = "git://github.com/gxk/ti-utils.git;protocol=git"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 calibrator ${D}${bindir}/	
}
