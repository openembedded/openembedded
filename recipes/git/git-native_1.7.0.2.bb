require git.inc
inherit native
DEPENDS = "openssl-native curl-native zlib-native expat-native"
PR = "r4"
SRC_URI[src.md5sum] = "76518fa774b36de81d160b85fa4f19c1"
SRC_URI[src.sha256sum] = "5601df7fc282fdd66de196b282694eb77dcfc50438f01587de144b3ead1a6b2f"

EXTRA_OECONF_append = " --without-python"
