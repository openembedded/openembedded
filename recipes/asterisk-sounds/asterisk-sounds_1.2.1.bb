DESCRIPTION="Supplementary asterisk-sounds"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-sounds-${PV}.tar.gz"

do_install() {
        oe_runmake DESTDIR=${D} install
}


SRC_URI[md5sum] = "bed4259905a7d7bc070c6319142b2075"
SRC_URI[sha256sum] = "bfa7def7d0f1190a111bde232920d2b3481d3932e2d1056573b3a9c4801c602a"
