DESCRIPTION = "Calculator"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "calculator"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libcalculator.so* bin/calculator apps/Applications/calculator.desktop etc/unit_conversion.dat pics/calc
do_install() {
        install -d ${D}${palmtopdir}/pics/calc/
        install -m 0644 ${WORKDIR}/pics/calc/*.png ${D}${palmtopdir}/pics/calc/
        install -d ${D}${palmtopdir}/etc/
        install -m 0644 ${WORKDIR}/etc/unit_conversion.dat ${D}${palmtopdir}/etc/
}

