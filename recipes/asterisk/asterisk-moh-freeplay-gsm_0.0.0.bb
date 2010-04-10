DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="http://www.asterisk.org"
SECTION = "voip"
LICENSE="GPL"
#DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://downloads.digium.com/pub/telephony/sounds/releases/asterisk-moh-freeplay-gsm.tar.gz"

do_install() {
	install -d ${D}${localstatedir}/lib/asterisk/moh
	install -m 644 ${WORKDIR}/*.gsm ${D}${localstatedir}/lib/asterisk/moh/
	install -m 644 ${WORKDIR}/LICENSE-* ${D}${localstatedir}/lib/asterisk/moh/
}

pkg_postinst_prepend() {
	chown -R asterisk:asterisk ${localstatedir}/lib/asterisk/moh/
}



SRC_URI[md5sum] = "da0cbefb40b5670648e1d2cc0010ec9f"
SRC_URI[sha256sum] = "e52b849febb308a6c6b6f4b6445d334e57178373ccf94b8660776c1a8fa45ad1"
