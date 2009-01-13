DESCRIPTION = "Pyro is an acronym for PYthon Remote Objects. \
It is an advanced and powerful Distributed Object Technology \
system written entirely in Python, that is designed to be very \
easy to use, and is small simple and free. Written by Irmen de Jong."
HOMEPAGE = "http://pyro.sourceforge.net"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pyro/Pyro-${PV}.tar.gz \
  file://pyro-unattended-install.patch;patch=1;pnum=0 \
"
S = "${WORKDIR}/Pyro-${PV}"

inherit distutils

RDEPENDS = "\
  python-crypt \
  python-io \
  python-lang \
  python-math \
  python-netserver \
  python-pickle \
  python-re \
  python-shell \
  python-stringold \
  python-threading \
"

