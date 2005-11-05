DESCRIPTION = "Militaryalphabet"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"
LICENSE = "GPL"
APPNAME = "militaryalphabet"
APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://sickpeople.wmc-allstars.com/law/files/militaryalphabet/militaryalphabet_${PV}-r0_arm.tar.bz2"
S = "${WORKDIR}/militaryalphabet"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/militaryalphabet
	install -d ${D}${palmtopdir}/sounds/militaryalphabet
	install -m 0755 ${WORKDIR}/militaryalphabet/pics/militaryalphabet.png  ${D}${palmtopdir}/pics/
	install -m 0755 ${WORKDIR}/militaryalphabet/sounds/*.wav  ${D}${palmtopdir}/sounds/militaryalphabet/
}

