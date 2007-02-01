DESCRIPTION = "A VoIP SIP phone for the Yealink USB handset"
HOMEPAGE = "http://www.devbase.at/voip/"
MAINTAINER = "Thomas Reitmayr <treitmayr@yahoo.com>"
LICENSE = "GPL-2"
PRIORITY = "optional"
DEPENDS = "liblinphone"
RDEPENDS = "liblinphone"
PR = "r1"

SRC_URI = "http://download.devbase.at/voip/yeaphone-${PV}.tar.gz"

S = "${WORKDIR}/yeaphone-${PV}"

inherit autotools

#EXTRA_OECONF = ""

#do_install_append() {
#}
