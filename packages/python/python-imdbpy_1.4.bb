DESCRIPTION = "IMDbPY is a Python package useful to retrieve and manage the data of the IMDb movie database."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "imdbpy"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/IMDbPY-${PV}"

inherit distutils

