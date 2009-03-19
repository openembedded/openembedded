DESCRIPTION = "opie-scummvm"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opie-scummvm"
APPTYPE = "binary"
APPDESKTOP = "${S}"

RDEPENDS = "scummvm-qpe"
SRC_URI = "http://sickpeople.wmc-allstars.com/law/files/scummvm/opie-scummvm-${PV}-r0_arm.tar.bz2"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}
	install -m 0755 ${WORKDIR}/${APPNAME}-1.0.1/scummvm.png  ${D}${palmtopdir}/pics/
}

