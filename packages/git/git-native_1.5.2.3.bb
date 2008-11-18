inherit native
require git_${PV}.bb

SRC_URI += "file://git-gui-install-mode-arg-spaces.patch;patch=1"

DEPENDS = "openssl-native curl-native zlib-native expat-native"
RDEPENDS = ""
