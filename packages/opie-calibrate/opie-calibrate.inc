DESCRIPTION = "Opie Standalone Touchscreen Calibration Utility"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

S = "${WORKDIR}/calibrate"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 calibrate ${D}${palmtopdir}/bin/
}
