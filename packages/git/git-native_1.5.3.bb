require git.inc

SRC_URI += "file://git-gui-install-mode-arg-spaces.patch;patch=1"

inherit native
DEPENDS = "openssl-native curl-native zlib-native expat-native"
PR = "r2"
