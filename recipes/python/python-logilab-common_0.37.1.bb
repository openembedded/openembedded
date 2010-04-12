DESCRIPTION = "This package contains some modules used by different \
projects released by Logilab, including abstract syntax \
tree manipulation tools, database helper functions, HTML generation, \
command line argument parsing, logging, and process daemonization."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "logilab-common"
PR = "ml0"

SRC_URI = "ftp://ftp.logilab.fr/pub/common/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "39561a45c74f8ff11e2ddd872f4ee5bc"
SRC_URI[sha256sum] = "c5974c1e98bed62bb3153a8144069c43229c6b208ef599bc77c84fb493c2291b"
