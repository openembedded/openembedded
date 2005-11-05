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


