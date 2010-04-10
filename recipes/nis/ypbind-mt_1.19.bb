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

require nis.inc

# ypbind-mt now provides all the functionality of ypbind
# and is used in place of it.
PROVIDES += "ypbind"

SRC_URI[md5sum] = "4878b742d61590501230aa8baa6a4f53"
SRC_URI[sha256sum] = "a39753a22b1f77b1fdb8163e800ee2d4f98a9e3018693d127459b509069a23f3"
