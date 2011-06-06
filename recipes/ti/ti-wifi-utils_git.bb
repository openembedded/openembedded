DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENCE = "TI-BSD"

DEPENDS = "libnl"

PR ="r3"
PV ="0.0"
PR_append = "+gitr${SRCPV}"

SRCREV = "268dbf03091b632c2697eb8028e90fe40513a9d8"
SRC_URI = "git://github.com/gxk/ti-utils.git;protocol=git"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/ti/wifi-utils/ini_files/127x
	install -d ${D}${datadir}/ti/wifi-utils/ini_files/128x

	install -m 0755 calibrator ${D}${bindir}/	
	install -m 0755 ${S}/ini_files/127x/* ${D}${datadir}/ti/wifi-utils/ini_files/127x
	install -m 0755 ${S}/ini_files/128x/* ${D}${datadir}/ti/wifi-utils/ini_files/128x
}

FILES_${PN} += " \
	${datadir}/ti/wifi-utils/ini_files/127x \
	${datadir}/ti/wifi-utils/ini_files/128x \
"
