DESCRIPTION = "WSGI (PEP 333) Reference Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF ZPL"
SRCNAME = "wsgiref"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.zip;name=wsgiref"
SRC_URI[wsgiref.md5sum] = "29b146e6ebd0f9fb119fe321f7bcf6cb"
SRC_URI[wsgiref.sha256sum] = "c7e610c800957046c04c8014aab8cce8f0b9f0495c8cd349e57c1f7cabf40e79"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
