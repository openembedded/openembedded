#
# Copyright (C) 2007 OpenedHand Ltd
#

DESCRIPTION = "Host packages for the standalone SDK or external toolchain"
PR = "r1"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

inherit canadian-sdk

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    binutils-canadian-sdk \
    gcc-canadian-sdk \
    gdb-canadian-sdk \
    "
