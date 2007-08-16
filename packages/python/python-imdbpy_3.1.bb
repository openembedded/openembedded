DESCRIPTION = "IMDbPY is a Python package useful to retrieve and manage the data of the IMDb movie database."
SECTION = "devel/python"
HOMEPAGE = "http://imdbpy.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "IMDbPY"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/imdbpy/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/imdb/parser/common/.debug"
