DESCRIPTION = "opie-scummvm"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opie-scummvm"
APPTYPE = "binary"
APPDESKTOP = "${S}"

RDEPENDS = "scummvm-qpe"
SRC_URI = "http://sickpeople.wmc-allstars.com/law/files/scummvm/opie-scummvm-${PV}-r0_arm.tar.bz2"

SRC_URI[md5sum] = "a71902804ea20314b7336a3d566f1977"
SRC_URI[sha256sum] = "9c20af44cc1b9d78f79adf7745716b73adaea0ff28208504f110e7c7520d354a"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}
	install -m 0755 ${WORKDIR}/${APPNAME}-1.0.1/scummvm.png  ${D}${palmtopdir}/pics/
}

