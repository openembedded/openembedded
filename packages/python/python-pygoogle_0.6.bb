DESCRIPTION = "This module is a wrapper for the Google Web APIs. \
It allows you to do Google searches, retrieve pages from the \
Google cache, and ask Google for spelling suggestions."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-core python-soappy"
SRCNAME = "pygoogle"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

