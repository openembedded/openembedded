require file.inc
DEPENDS_virtclass-native += "zlib-native"
PR = "${INCPR}.0"

SRC_URI += "file://reloc.patch"

SRC_URI[md5sum] = "0b429063710457be2bd17a18389cb018"
SRC_URI[sha256sum] = "5cb47845d91848e2b8eb58935766f93d8a2ecf665b33be7317f1849d3c46e1b7"

