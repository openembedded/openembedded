DESCRIPTION = "A routing daemon for the OLSR protocol prepared for QoS enhancements."
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://qolsr.lri.fr"
MAINTAINER = "Michael Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://qolsr.lri.fr/code/qolyester-${PV}.tar.bz2"

inherit autotools

