DESCRIPTION = "EFL launcher for ace-of-penguins"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
DEPENDS = "python-native python-elementary"
RDEPENDS = "aceofpenguins"
SECTION = "x11/application"

PACKAGE_ARCH = "all"

PR = "r0"

inherit setuptools

SRC_URI = "http://downloads.vdm-design.de/aceofpenguins-launcher-${PV}.tar.gz"

S = "${WORKDIR}/aceofpenguins-launcher"

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"


SRC_URI[md5sum] = "40f19a26cbfa35de8346efe582b5d984"
SRC_URI[sha256sum] = "ea09581b3a31e3409968876461da3e384dcb0000abbb0060ae14e4fccb4994e1"
