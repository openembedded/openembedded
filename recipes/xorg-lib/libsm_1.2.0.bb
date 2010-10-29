require xorg-lib-common.inc
DESCRIPTION = "X11 Session management library"
DEPENDS += "libice xproto xtrans util-linux-ng"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e78c447bf1790552b644eca81b542742"
SRC_URI[archive.sha256sum] = "0cd8df1b7067bfda10b05d38279777770677c6fecb5a14e804a28597da7a57cb"

BBCLASSEXTEND = "native"

XORG_PN = "libSM"
