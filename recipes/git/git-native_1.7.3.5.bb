require git.inc
inherit native
SRC_URI[src.md5sum] = "8a8cd93b8a4dff0a03c0fdc77253af3e"
SRC_URI[src.sha256sum] = "41682e4c13b43591b61a96b6f7a549b24863f62dfc4a917b6147c8e708e288a6"
DEPENDS = "openssl-native curl-native zlib-native expat-native"
PR = "r0"

EXTRA_OECONF_append = " --without-python"
EXTRA_OEMAKE = "NO_TCLTK=1"
