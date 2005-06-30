# This package builds the NIS server
# The source package is utils/net/NIS/ypserv
#
PR = "r0"
DESCRIPTION="NIS version 2 server for Linux."
HOMEPAGE="http://www.linux-nis.org/nis/ypserv/index.html"

include nis.inc

# ypserv needs a database package, gdbm is currently the
# only candidate
DEPENDS += " gdbm"
