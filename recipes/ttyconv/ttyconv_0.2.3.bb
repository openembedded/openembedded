# ttyconv OE build file
# Copyright (C) 2005 Chris Larson <kergoth@handhelds.org>
# Released under the MIT license (see the COPYING file in this tree)

DESCRIPTION = "Small app to convert terminal sessions from one encoding to another."
HOMEPAGE = "http://www.bedroomlan.org/~alexios/coding_ttyconv.html"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "console/utils"
PR = "r1"

SRC_URI = "http://www.bedroomlan.org/~alexios/files/SOFTWARE/ttyconv/ttyconv_${PV}.tar.gz"
S = "${WORKDIR}/ttyconv"

inherit autotools

SRC_URI[md5sum] = "7997ba54401a7685290a6666b9d28585"
SRC_URI[sha256sum] = "d91b4addcbb241b04b6cf795447163ed890a436b10205d2cd9cc1885ea3d9433"
