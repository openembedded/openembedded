DESCRIPTION = "Password manager"
SECTION = "opie/applications"
PRIORITY    = "optional"
LICENSE     = "GPL"
RCONFLICTS  = "opie-zsafe"
APPNAME     = "zsafe"
APPTYPE     = "binary"
APPDESKTOP  = "${WORKDIR}"
SRC_URI     = "http://z-soft.z-portal.info/zsafe/zsafe_2.1.3.tgz"
S           = "${WORKDIR}"

inherit opie

QMAKE_PROFILES = "zsafe.pro"

export OE_QMAKE_LINK="${CXX}"

#FILES bin/zsafe apps/Applications/zsafe.desktop pics/zsafe/zsafe.png

FILES_zsafe = "zsafe"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/zsafe.png ${D}${palmtopdir}/pics/
}
