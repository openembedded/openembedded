# ttyconv OE build file
# Copyright (C) 2005 Chris Larson <kergoth@handhelds.org>
# Released under the MIT license (see the COPYING file in this tree)

DESCRIPTION = "Small app to convert terminal sessions from one encoding to another."
HOMEPAGE = "http://www.bedroomlan.org/~alexios/coding_ttyconv.html"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "console/utils"
PR = "r1"

SRC_URI = "http://www.bedroomlan.org/~alexios/files/SOFTWARE/ttyconv/ttyconv_${PV}.tar.gz"
S = "${WORKDIR}/ttyconv"

inherit autotools
