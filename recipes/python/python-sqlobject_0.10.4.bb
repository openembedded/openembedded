DESCRIPTION = "SQLObject is an object-relational mapper. It allows you to translate RDBMS \
table rows into Python objects, and manipulate those objects to transparently \
manipulate the database."
SECTION = "devel/python"
HOMEPAGE = "http://www.sqlobject.org/"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "SQLObject"
PR = "ml0"

SRC_URI = "http://cheeseshop.python.org/packages/source/S/SQLObject/SQLObject-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS = "python-formencode"

SRC_URI[md5sum] = "20039279c5b799c49e6496b9fe71f03f"
SRC_URI[sha256sum] = "8204bf5aeaca5b72e6bf3bd11db440346f3ed6d13b856166e3b84c4b3ec7152f"
