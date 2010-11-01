require xorg-app-common.inc
DEPENDS += " libxaw libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://0001-config-replace-AC_CHECK_FILE-with-test-f.patch"
SRC_URI[archive.md5sum] = "f9addda7d1e157fc7d17ff87b1e360f8"
SRC_URI[archive.sha256sum] = "c57a65c364923d02b0130a4b02117f7d7a0f5c6e01d5dd5c8c263afabc9a19b4"
