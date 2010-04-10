# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "modular framework for implementing a CISCO-like CLI on a *NIX system"
LICENSE = "GPL"
SECTION = "console/utils"
PR ="r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/clish/clish-${PV}.tar.gz \
           file://configure.patch;patch=1"

PARALLEL_MAKE=""

S = "${WORKDIR}/clish-${PV}"

inherit autotools


LEAD_SONAME="libclish.so.*"

SRC_URI[md5sum] = "81e20f7a888bcd8e2280e37804d342e4"
SRC_URI[sha256sum] = "c8c2416848950ac452cd4010311554d7f232f81abd543fe9ba2d7146dbb6c96f"
