# Copyright (C) 2009 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Yet Another Screen Reader(yasr) is a \
	       general-purpose console screen reader"
HOMEPAGE = "http://yasr.sf.net"
LICENSE = "GPLv2"
SECTION = "console/utils"
SUGGESTS = "speech-dispatcher"

SRC_URI = "${SOURCEFORGE_MIRROR}/yasr/yasr-${PV}.tar.gz \
	   file://yasr-0.6.9-gcc43.patch;patch=1 \
	   file://yasr-0.6.9-remove-m4.patch;patch=1 \
	  "

inherit autotools
