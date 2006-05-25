DESCRIPTION = "display brightness utility"
AUTHOR = "Patrick Steiner <patrick.steiner@a1.net>"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"
DEPENDS = ""
PRIORITY = "optional"
LICENSE = "GPLv2"
PACKAGE_ARCH = "all"
PR = "r3"

SRC_URI = "file://display-brightness.sh"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/display-brightness.sh ${D}${bindir}/
}
