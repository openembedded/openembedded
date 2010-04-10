DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="http://www.asterisk.org"
SECTION = "voip"
LICENSE="GPL"
#DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://downloads.digium.com/pub/telephony/sounds/releases/asterisk-extra-sounds-en-g729-${PV}.tar.gz"

do_install() {
	install -d ${D}${localstatedir}/lib/asterisk/sounds
	# HACK: moving the files in chunks (too many files)
	mv ${WORKDIR}/[a-d]*.g729 ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/[e-l]*.g729 ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/*.g729 ${D}${localstatedir}/lib/asterisk/sounds/
	#install -m 644 ${WORKDIR}/*.g729 ${D}${localstatedir}/lib/asterisk/sounds/

	#install -d ${D}${localstatedir}/lib/asterisk/sounds/ha
	#install -m 644 ${WORKDIR}/ha/* ${D}${localstatedir}/lib/asterisk/sounds/ha/
	mv ${WORKDIR}/ha ${D}${localstatedir}/lib/asterisk/sounds

	#install -d ${D}${localstatedir}/lib/asterisk/sounds/wx
	#install -m 644 ${WORKDIR}/wx/* ${D}${localstatedir}/lib/asterisk/sounds/wx/
	mv ${WORKDIR}/wx ${D}${localstatedir}/lib/asterisk/sounds
}

pkg_postinst_prepend() {
	chown -R asterisk:asterisk ${localstatedir}/lib/asterisk/sounds/
}



SRC_URI[md5sum] = "0de5e5f75197b4e128815867443de775"
SRC_URI[sha256sum] = "c2e17052da282533cc10a38fcd6c4d3e5b2de43d7909f7391f9fcf34c335c921"
