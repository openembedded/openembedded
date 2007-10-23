# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "grdesktop is a GNOME frontend, for the remote desktop client (rdesktop)."
HOMEPAGE = "http://www.nongnu.org/grdesktop/index.html"
SECTION = "x11/utils"
LICENSE = "GPLv2"

DEPENDS = "gtk+ libgnomeui"
RDEPENDS ="rdesktop"

PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/grdesktop/grdesktop-${PV}.tar.gz \
           file://fr.po.patch;patch=1 \
           file://install-help.patch;patch=1"
      

S = "${WORKDIR}/grdesktop-${PV}"

inherit autotools pkgconfig

