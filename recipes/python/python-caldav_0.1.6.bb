DESCRIPTION = "This project is a CalDAV (RFC4791) client library for Python."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://bitbucket.org/cyrilrbt/caldav"
SRCNAME = "caldav"
PR = "r0"
DEPENDS = "python python-lxml python-vobject"
RDEPENDS_${PN} = "python-lxml python-vobject"

SRC_URI  = "http://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "e5eace7a3b6b7f511a1929a539e6a15d"
SRC_URI[sha256sum] = "4a3b1855000feb8023ab05f8c9e0cfa1648a9abab9ca65ad3e933c22bab61310"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
