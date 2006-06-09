DESCRIPTION="Supplementary asterisk-sounds"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS=""
PR = "r0"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-sounds-${PV}.tar.gz" 

do_install() {
        oe_runmake DESTDIR=${D} install
}

