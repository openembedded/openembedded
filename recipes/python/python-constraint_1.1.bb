DESCRIPTION = "The constraint package is a constraint \
satisfaction problem solver written in 100% pure Python, using \
constraint propagation algorithms. So far, facilities are \
provided to work with finite domains only."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "ml1"

SRC_URI = "http://labix.org/download/python-constraint/python-constraint-${PV}.tar.bz2"

inherit distutils


SRC_URI[md5sum] = "975e5449d6670dd19498bb9ec4856d39"
SRC_URI[sha256sum] = "0d904161351a8e55b272ed9691b12dca4278bed62fde53ba2a36f479996db910"
