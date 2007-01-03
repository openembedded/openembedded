DESCRIPTION="Supplementary asterisk-sounds"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-sounds-${PV}.tar.gz"

do_install() {
        oe_runmake DESTDIR=${D} install
}

