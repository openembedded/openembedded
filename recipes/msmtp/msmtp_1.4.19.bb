DESCRIPTION = "A sendmail replacement for use in MTAs like mutt"
HOMEPAGE = "http://msmtp.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "zlib gnutls"

SRC_URI = "${SOURCEFORGE_MIRROR}/msmtp/msmtp-${PV}.tar.bz2;name=u1"

inherit autotools

SRC_URI[u1.md5sum] = "f0afdc943bf7c8a3a3bf3fe1a73072c4"
SRC_URI[u1.sha256sum] = "d6bf3f6f796041fc7d6653c022cc696238fdf8b2d538c4b2cd6c0aae5f056c66"
