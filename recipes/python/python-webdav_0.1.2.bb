DESCRIPTION = "This project aims to provide an object-oriented Python WebDAV client-side library\
	       based on Python`s standard httplib and Greg Stein`s davlib.\
               The client shall fully support RFCs 4918 (basic specification),\
               3744 (access control), and 3253 (versioning)."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "Apache License V2.0"
HOMEPAGE = "http://sourceforge.net/projects/pythonwebdavlib/"
SRCNAME = "Python_WebDAV_Library"
DEPENDS = "python"

SRC_URI = "${SOURCEFORGE_MIRROR}/pythonwebdavlib/Python%20WebDAV%20Library%20-%20${PV}/${SRCNAME}-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
