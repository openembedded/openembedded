DESCRIPTION = "Netlink library"
HOMEPAGE = "http://people.suug.ch/~tgr/libnl/"
SECTION = "libraries/network"
LICENSE = "GPLv2.1"
PR = "r0"

SRC_URI = "http://people.suug.ch/~tgr/libnl/files/libnl-0.5.0.tar.gz \
           file://libnl-0.5.0-include.diff;patch=1 \
           file://fix-helpers.patch;patch=1"

inherit autotools
