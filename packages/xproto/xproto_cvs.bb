PV = "0.0cvs${CVSDATE}"
LICENSE= "MIT"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DESCRIPTION = "X protocol and ancillary headers."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xproto"
S = "${WORKDIR}/Xproto"

inherit autotools pkgconfig
