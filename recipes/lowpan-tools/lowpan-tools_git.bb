require lowpan-tools.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "a38879e4d5bc9795ebbf18d08ec4c533331efb66"
SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee/linux-zigbee;protocol=git"
PR = "${INC_PR}.0"

S = "${WORKDIR}/git"
