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


SRC_URI[md5sum] = "36f7b3120e00c9c74cb6619334de419f"
SRC_URI[sha256sum] = "6eed89b661ae9f2ac0d383414ca964abea8a115f8fba0f7ab37b49b565ffb2a8"
#CHECKSUMS.INI MISMATCH: I've got this instead
#SRC_URI[md5sum] = "b58f8561d32bafaa6153d5e20fefa7df"
#SRC_URI[sha256sum] = "0712b2cd55ad78084385d215f8037aad3c53b06a6fd8c9bda83ec23afd440a27"
