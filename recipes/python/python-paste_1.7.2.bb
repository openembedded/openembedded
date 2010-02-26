DESCRIPTION = "Tools for using a Web Server Gateway Interface stack"
HOMEPAGE = "http://pythonpaste.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "Paste"
PR = "r0"

SRC_URI = "http://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz;name=paste"
SRC_URI[paste.md5sum] = "a6a58d08dc4bff91d5d1c519d2277f8a"
SRC_URI[paste.sha256sum] = "67dde086f0aa84c3ec2452cd65d05d19a050ec2ba56483b1614bdbfd82b3b2b8"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
