DESCRIPTION = "This python module implements constants and \
functions for working with IEEE754 double-precision special values. \
It provides constants for Not-a-Number (NaN), Positive Infinity \
(Inf), and Negative Infinity (-Inf), as well as functions \
to test for these values."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "fpconst"

SRC_URI = "http://ftp.iasi.roedu.net/mirrors/gentoo.org/distfiles/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
