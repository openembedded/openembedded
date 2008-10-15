DESCRIPTION = "A sendmail replacement for use in MTAs like mutt"
HOMEPAGE = "http://msmtp.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "zlib gnutls"
FILE_PR = "r0"
SRC_URI = "${SOURCEFORGE_MIRROR}/msmtp/msmtp-${PV}.tar.bz2"

inherit autotools

