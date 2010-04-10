require libidl.inc

DEPENDS = "glib-2.0 flex-native libidl-native"

PR = "r0"

BINCONFIG_GLOB = "*-config-2"
inherit autotools pkgconfig binconfig

SRC_URI[md5sum] = "9e10a77ff225587e59c0a28c66b4faa7"
SRC_URI[sha256sum] = "91a5b69435f10002b222be022c832d9860a93e0bc181e3f94abc150486ab031a"
