DESCRIPTION = "libnl is a library for applications dealing with netlink sockets"
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://people.suug.ch/~tgr/libnl"

# If you get errors like : undefined reference to `nl_handle_alloc
# do a bitbake -c clean libnl2

PR = "r3"

inherit autotools pkgconfig

CFLAGS += '-DVLAN_FLAG_REORDER_HDR=1'

SRC_URI = "\
  http://people.suug.ch/~tgr/libnl/files/libnl-${PV}.tar.gz \
  file://local-includes.patch;patch=1 \
  file://fix-includes.patch;patch=1 \
  file://respect-ldflags.patch;patch=1 \
  file://netlink-local-fix.patch;patch=1 \
"

