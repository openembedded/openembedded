DESCRIPTION = "patch takes a patch file containing a difference listing \
produced by the diff program and applies those differences to one or more \
original files, producing patched versions."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "standard"
SECTION = "utils"

SRC_URI = "${GNU_MIRROR}/patch/patch-${PV}.tar.gz"
S = "${WORKDIR}/patch-${PV}"

inherit autotools
