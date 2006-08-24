DESCRIPTION = "libnl is a library for applications dealing with netlink sockets"
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://people.suug.ch/~tgr/libnl/"
MAINTAINER = "Milan Plzik <mmp@handhelds.org>"
PRIORITY = "optional"
DEPENDS = "glibc"

inherit autotools pkgconfig gpe

SRC_URI= "http://people.suug.ch/~tgr/libnl/files/${P}.tar.gz \
           file://local-includes.patch;patch=1"

do_install() {
        oe_runmake prefix=${prefix} DESTDIR=${D} install
}

do_stage () {
	autotools_stage_all prefix=${prefix}
}

do_install () {
	oe_runmake prefix=${prefix} DESTDIR=${D} install
}

