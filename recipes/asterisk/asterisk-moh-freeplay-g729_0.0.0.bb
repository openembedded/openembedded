DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="http://www.asterisk.org"
SECTION = "voip"
LICENSE="GPL"
#DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://downloads.digium.com/pub/telephony/sounds/releases/asterisk-moh-freeplay-g729.tar.gz"

do_install() {
	install -d ${D}${localstatedir}/lib/asterisk/moh
	install -m 644 ${WORKDIR}/*.g729 ${D}${localstatedir}/lib/asterisk/moh/
	install -m 644 ${WORKDIR}/LICENSE-* ${D}${localstatedir}/lib/asterisk/moh/
}

pkg_postinst_prepend() {
	chown -R asterisk:asterisk ${localstatedir}/lib/asterisk/moh/
}



SRC_URI[md5sum] = "381497d57c39d786cc79200576c5b2cc"
SRC_URI[sha256sum] = "fdb7b483b55457b488fcb788f0254c26ca87cab49dcfb8391d347454fb3a8b7f"
