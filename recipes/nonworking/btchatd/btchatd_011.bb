DESCRIPTION = "btChat is a bluetooth based chatting/IM (instant messaging) system"
LICENSE = ""
HOMEPAGE="http://www.mulliner.org/bluetooth/btchat/"

DEPENDS = "bluez-libs"

SRC_URI="http://www.mulliner.org/bluetooth/btchat/btchatd_${PV}.tar.gz"
S = "${WORKDIR}/${PN}_${PV}/src"

do_compile() {
oe_runmake
}

do_install() {
oe_runmake install
}



SRC_URI[md5sum] = "d986a850565cca1761d87d6187aa70cf"
SRC_URI[sha256sum] = "05d6758d901e7c1f28fa1d53f86b5d2a8ef4359fb9d266df5564de7d9494fcea"
