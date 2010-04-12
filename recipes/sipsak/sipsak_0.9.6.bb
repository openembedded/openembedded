DESCRIPTION = "sipsak is a small command line tool for developers and administrators\
of Session Initiation Protocol (SIP) applications."
HOMEPAGE="sipsak.org"
LICENSE = "GPLv2"
PR = "r1"
SRC_URI = "http://download.berlios.de/sipsak/sipsak-${PV}-1.tar.gz\
           file://sipsak.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "c4eb8e282902e75f4f040f09ea9d99d5"
SRC_URI[sha256sum] = "5064c56d482a080b6a4aea71821b78c21b59d44f6d1aa14c27429441917911a9"
