inherit native

require mkfontdir_1.0.4.bb

DEPENDS = "util-macros-native mkfontscale-native"

S = "${WORKDIR}/mkfontdir-${PV}"
XORG_PN = "mkfontdir"

SRC_URI[archive.md5sum] = "35394bf3f746a57fba624dba52fdbba3"
SRC_URI[archive.sha256sum] = "6f9a3cc70d27704ee8e4ff01d5d69c974b059fd7e470172b68cfa477c7caf8e3"
