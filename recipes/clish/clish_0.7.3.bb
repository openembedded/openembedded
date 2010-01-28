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
