DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENCE = "TI-BSD"

DEPENDS = "libnl"

PR ="r2"
PV ="0.0"
PR_append = "+gitr${SRCPV}"

SRCREV = "268dbf03091b632c2697eb8028e90fe40513a9d8"
SRC_URI = "git://github.com/gxk/ti-utils.git;protocol=git"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 calibrator ${D}${bindir}/	
}
