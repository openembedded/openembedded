DESCRIPTION = "Python access to the File Alteration Monitor"
HOMEPAGE = "http://python-fam.sourceforge.net/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "fam"
RDEPENDS = "fam python-core python-io"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit distutils

