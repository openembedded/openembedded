DESCRIPTION = "This module is a wrapper for the Google Web APIs. \
It allows you to do Google searches, retrieve pages from the \
Google cache, and ask Google for spelling suggestions."
SECTION = "devel/python"
HOMEPAGE = "http://pygoogle.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "PSF"
RDEPENDS = "python-soappy"
SRCNAME = "pygoogle"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

