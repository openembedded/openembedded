# Copyright (C) 2007-2008, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "A package to manipulate BSD TCP/IP stream sockets"
SECTION = "console/network"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "http://web.purplefrog.com/~thoth/netpipes/ftp/${PN}-${PV}-export.tar.gz"

S = "${WORKDIR}"


FILES_${PN}-doc                 +="/man/man1"

do_compile() {
        oe_runmake install INSTROOT='${D}'
}

