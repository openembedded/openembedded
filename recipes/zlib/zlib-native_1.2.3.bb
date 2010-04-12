require zlib_${PV}.bb
ZLIB_EXTRA = ""
DEPENDS = "libtool-native"

inherit native

SRC_URI[md5sum] = "dee233bf288ee795ac96a98cc2e369b6"
SRC_URI[sha256sum] = "e3b9950851a19904d642c4dec518623382cf4d2ac24f70a76510c944330d28ca"
