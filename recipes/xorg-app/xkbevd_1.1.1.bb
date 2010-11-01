require xorg-app-common.inc
DEPENDS += " libxkbfile "
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://0001-config-replace-AC_CHECK_FILE-with-test-f.patch"
SRC_URI[archive.md5sum] = "699198865d6902c39e3c6a9693a6422d"
SRC_URI[archive.sha256sum] = "b47060a0131edd05d840ee21e8d3c7545151883b9a87c45e62e444d711e4805a"
