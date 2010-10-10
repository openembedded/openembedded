require xorg-app-common.inc
DEPENDS += " xproto util-macros"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "35c6cccbf25a872bdd62bfcb1a73d951"
SRC_URI[archive.sha256sum] = "80887da011ad086fff88bfd16c6d9d5ac7da45ef1bc9d0c192a6f370423370f1"

FILES_${PN} += "${datadir}/X11"
