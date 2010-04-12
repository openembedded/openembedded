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

SRC_URI[md5sum] = "daec224676fb2db5a1936b399f559473"
SRC_URI[sha256sum] = "41f17cfab8e88824a8dc1476602a0944b9030a8f8da2538a7a6549e3534e3bdf"
