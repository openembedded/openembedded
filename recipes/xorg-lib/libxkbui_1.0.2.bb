require xorg-lib-common.inc

DESCRIPTION = "X11 keyboard UI presentation library"
LICENSE= "GPL"
DEPENDS += "virtual/libx11 libxt libxkbfile"
PROVIDES = "xkbui"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "1143e456f7429e18e88f2eadb2f2b6b1"
SRC_URI[archive.sha256sum] = "20c23101d63234ee5f6d696dfa069b29c6c58e39eff433bcd7705b50b3ffa214"
