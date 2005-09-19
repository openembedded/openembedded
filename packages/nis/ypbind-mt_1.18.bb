# This package builds the NIS ypbind daemon
# The source package is utils/net/NIS/ypbind-mt
#
PR = "r0"
DESCRIPTION="\
Multithreaded NIS bind service (ypbind-mt).  \
ypbind-mt is a complete new implementation of a NIS \
binding daemon for Linux. It has the following \
features.  Supports ypbind protocol V1 and V2.  \
Uses threads for better response.  Supports multiple \
domain bindings.  Supports /var/yp/binding/* file \
for Linux libc 4/5 and glibc 2.x.  Supports a list \
of known secure NIS server (/etc/yp.conf) Binds to \
the server which answered as first."
HOMEPAGE="http://www.linux-nis.org/nis/ypbind-mt/index.html"

include nis.inc

SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/net/NIS/OLD/${PN}/${P}.tar.bz2"

# ypbind-mt now provides all the functionality of ypbind
# and is used in place of it.
PROVIDES += "ypbind"
