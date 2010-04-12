# This package builds the NIS server
# The source package is utils/net/NIS/ypserv
#
PR = "r0"
DESCRIPTION="NIS version 2 server for Linux."
HOMEPAGE="http://www.linux-nis.org/nis/ypserv/index.html"

require nis.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/net/NIS/OLD/${PN}/${P}.tar.bz2"

# ypserv needs a database package, gdbm is currently the
# only candidate
DEPENDS += " gdbm"

SRC_URI[md5sum] = "d0366ade2f46a2292de47bc1fe60e8fd"
SRC_URI[sha256sum] = "afed29dd6f0401be0fa2a8761993dd6dd93d1ad93aa1812a87ce8aa00736e89b"
