DESCRIPTION = "EFL launcher for ace-of-penguins"
HOMEPAGE = "http://shr-project.org"
LICENSE = "GPL"
DEPENDS = "python-native python-elementary"
RDEPENDS_${PN} = "aceofpenguins"
SECTION = "x11/application"

PACKAGE_ARCH = "all"

PR = "r0"

inherit setuptools

SRC_URI = "http://downloads.vdm-design.de/aceofpenguins-launcher-${PV}.tar.gz"

S = "${WORKDIR}/aceofpenguins-launcher"

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"


SRC_URI[md5sum] = "9494abb238064871f17600ee419794c4"
SRC_URI[sha256sum] = "9a32120873e930baa2f17513618911cc58f94f4c6510e706687ae9192df6b58b"

