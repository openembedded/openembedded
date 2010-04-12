SRC_URI = ${SOURCEFORGE_MIRROR}/firebird/firebird-${PV}.tar.bz2

inherit autotools

do_configure () {
	./autogen.sh
	oe_runconf
}

SRC_URI[md5sum] = "c088ccf4d149ecc1fa03ee27e9043701"
SRC_URI[sha256sum] = "197987f05a1c71e368b5bf413f3ac8ccb599b0a3621a6ac4c8236f78b39e9b5e"
