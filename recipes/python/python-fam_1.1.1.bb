DESCRIPTION = "Python access to the File Alteration Monitor"
HOMEPAGE = "http://python-fam.sourceforge.net/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "fam"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit distutils

RDEPENDS = "fam python-core python-io"


SRC_URI[md5sum] = "f6c760c6d8e5ea69a3fce029f7973558"
SRC_URI[sha256sum] = "139f069a4455560a8c68c4c18569f2cb453eeda33d522862f7a4af13932d9cdc"
