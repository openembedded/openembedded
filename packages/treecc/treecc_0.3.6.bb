DESCRIPTION = "Tree Compiler-Compiler from dotGNU"
SECTION = "devel"
LICENSE = "GPL-2"
HOMEPAGE = "http://www.southern-storm.com.au/treecc.html"
MAINTAINER = "Kirill Kononenko <krokas@aport.ru>"
PRIORITY = "optional"

SRC_URI = "http://www.southern-storm.com.au/download/treecc-${PV}.tar.gz \
           file://dont-make-in-examples.patch;patch=1"

inherit autotools

