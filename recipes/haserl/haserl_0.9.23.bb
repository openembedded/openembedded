# Copyright (C) 2007-2008, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "A cgi wrapper for embedding shell scripts into html documents"
SECTION = "console/network"
DEPENDS = ""
PR = "r0"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools gettext

SRC_URI[md5sum] = "31d1f505afe3ba1b351e18612aa57a70"
SRC_URI[sha256sum] = "bbe44edc3d519028761a22b282b912ab8f43db2003c6791c295c4a52f5db48bf"
