DESCRIPTION = "Pyro is an acronym for PYthon Remote Objects. \
It is an advanced and powerful Distributed Object Technology \
system written entirely in Python, that is designed to be very \
easy to use, and is small simple and free. Written by Irmen de Jong."
HOMEPAGE = "http://pyro.sourceforge.net"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "JStauft <wikimail@telus.net>"
LICENSE = "MIT"
RDEPENDS = "python-core python-crypt python-io python-lang python-math \
python-netserver python-pickle python-re python-shell python-stringold \
python-threading"
PR = "r1"

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/pyro;module=Pyro;method=pserver;tag=pyro3_4  \
           file://pyro-unattended-install.patch;patch=1;pnum=0"
S="${WORKDIR}/Pyro"

inherit distutils
