require ${PN}.inc

RDEPENDS_${PN} = "libopenobex-1.0-1 irda-utils"
PR = "r2"

SRC_URI += "file://vcard-send.patch;striplevel=0"

inherit gpe

SRC_URI[md5sum] = "4bd3894de194ee023a4c7af6c2a2e9cd"
SRC_URI[sha256sum] = "86a0fe68a93308b6d5c0e19da85789a6e48d88ba08dee98516f21b3b0ed85854"
