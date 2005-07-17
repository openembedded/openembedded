DESCRIPTION = "IMDbPY is a Python package useful to retrieve and manage the data of the IMDb movie database."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "IMDbPY"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/imbdbpy/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

