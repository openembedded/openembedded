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

SRC_URI[md5sum] = "8c7bef46f54451c809ffd99e2f1eee2d"
SRC_URI[sha256sum] = "b677e2f0539b90d1c0a844b9ab0f19ac41424c7c2b9335d17695765f2d7b1b80"
