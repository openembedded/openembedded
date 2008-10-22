DESCRIPTION = "sipsak is a small command line tool for developers and administrators\
of Session Initiation Protocol (SIP) applications."
HOMEPAGE="sipsak.org"
LICENSE = "GPLv2"
PR = "r1"
SRC_URI = "http://download.berlios.de/sipsak/sipsak-${PV}-1.tar.gz\
           file://sipsak.patch;patch=1"

inherit autotools

