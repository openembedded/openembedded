DESCRIPTION = "This is a small package that facilitates the unit testing process \
by aggregating PyUnit tests and making them easier to call from the command \
line and from within other unit tests."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "pytest"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/meta-tools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
