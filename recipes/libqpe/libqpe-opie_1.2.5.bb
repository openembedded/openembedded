require ${PN}.inc

PR = "${INC_PR}.0"

DEPENDS += " sysfsutils"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_library.tar.bz2;name=split_library \
           file://fix-titleheight.patch \
           file://unbreak-logging-2.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
          "
SRC_URI[split_library.md5sum] = "195ede745b2d1b2111f97654151b7af4"
SRC_URI[split_library.sha256sum] = "aace8f512c0f8f0e23509599c60ec12cf41145bc583d814228db0fcb356a0ea0"
