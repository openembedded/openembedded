DESCRIPTION = "FreeSmartPhone.org Python Prototypes"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
RDEPENDS = "python-serial python-lang"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=py-proto"
S = "${WORKDIR}/py-proto"

inherit distutils

