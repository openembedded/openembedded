DESCRIPTION = "Xirssi is an X frontend to the modular IRC client irssi."
HOMEPAGE = "http://irssi.org/"
SECTION = "x11/network"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS += "irssi gtk+"
RDEPENDS_${PN} += "irssi-common"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

inherit autotools

SRC_URI = "cvs://anonymous:@cvs.irssi.org/home/cvs;module=xirssi"
S = "${WORKDIR}/xirssi"

EXTRA_OECONF = "--with-irssi=${STAGING_LIBDIR}/../irssi"
