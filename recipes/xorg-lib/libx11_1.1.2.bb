require libx11.inc
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "710bf38a9477a5a1b235bc94f1d0593c"
SRC_URI[archive.sha256sum] = "b77e4fd2bbd4092e7e78d0964760ad8ab160caccd4bc6d7d0c87a23febaea85e"

EXTRA_OECONF += " --without-xcb"
