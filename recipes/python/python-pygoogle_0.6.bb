DESCRIPTION = "This module is a wrapper for the Google Web APIs. \
It allows you to do Google searches, retrieve pages from the \
Google cache, and ask Google for spelling suggestions."
SECTION = "devel/python"
HOMEPAGE = "http://pygoogle.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "PSF"
RDEPENDS = "python-soappy"
SRCNAME = "pygoogle"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils


SRC_URI[md5sum] = "334e2d9e5a765ffa9769e2c4cdfcd110"
SRC_URI[sha256sum] = "ad3f4530977a15e52b379ef301a4a80cf69a883f24dd6cebc5b47b3009c092a4"
