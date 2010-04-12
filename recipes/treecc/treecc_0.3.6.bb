DESCRIPTION = "Tree Compiler-Compiler from dotGNU"
SECTION = "devel"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.southern-storm.com.au/treecc.html"
PRIORITY = "optional"

SRC_URI = "http://www.southern-storm.com.au/download/treecc-${PV}.tar.gz \
           file://dont-make-in-examples.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "56426279e6017af909353176e582fb28"
SRC_URI[sha256sum] = "c9b97a2c4a27a3d59caea3430485837f286ca8883504a8eb6bd86702275ba5fe"
