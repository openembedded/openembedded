DESCRIPTION = "Militaryalphabet"
SECTION = "opie/applications"
PRIORITY = "optional"
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


SRC_URI[md5sum] = "7392786df07a2473f3c29b221f3dcbe5"
SRC_URI[sha256sum] = "e1edc43af77f5fef64dffc30551cd540b1d90eb669b011a02bfedbd6947e3805"
