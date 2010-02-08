require git.inc
inherit native
DEPENDS = "openssl-native curl-native zlib-native expat-native"
PR = "r4"
SRC_URI += "file://autotools.patch;patch=1"
