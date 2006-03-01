# vnc OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A Unix VNC client"
HOMEPAGE = "http://www.realvnc.com/"
DEPENDS = "zlib libxmu libxaw"
LICENSE="GPL"

SRC_URI="http://www.realvnc.com/dist/vnc-${PV}-unixsrc.tar.gz"

S="${WORKDIR}/vnc-${PV}-unixsrc"

inherit autotools
EXTRA_OECONF = " --with-installed-zlib"

do_install() {
	install -d ${D}/usr/bin/
	install -m 0755 vncviewer/vncviewer ${D}/usr/bin/vncviewer
}
	
