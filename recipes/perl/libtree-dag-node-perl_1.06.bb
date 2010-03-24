DESCRIPTION = "(super)class for representing nodes in a tree"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-strict"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/C/CO/COGENT/Tree-DAG_Node-${PV}.tar.gz;name=tree-dag-node-perl-${PV}"
SRC_URI[tree-dag-node-perl-1.06.md5sum] = "3b006f128bd1d8961fc57c466ffa05f2"
SRC_URI[tree-dag-node-perl-1.06.sha256sum] = "502570774dd3bf11345fb028ca4cdd79f04db12ee68a826f0c44e24da0e3db2a"

S = "${WORKDIR}/Tree-DAG_Node-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
