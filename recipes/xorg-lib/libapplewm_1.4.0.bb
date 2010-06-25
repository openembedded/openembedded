require xorg-lib-common.inc
DEPENDS += "libxext applewmproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "75e27245bc15aed845fe0505f4f21ca6"
SRC_URI[archive.sha256sum] = "c8e92616ad465ce2ae86360ff216a9711bdd1156dbb06af6d86009c6773e1c82"

XORG_PN = "libAppleWM"
