DESCRIPTION = "template engine and code generation tool"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Cliff Brake <cbrake@bec-systems.com>"
LICENSE = "MIT-like"
RDEPENDS = ""
SRCNAME = "Cheetah"

SRC_URI = "${SOURCEFORGE_MIRROR}/cheetahtemplate/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

PR = "r0"

inherit distutils

