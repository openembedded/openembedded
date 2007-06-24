DESCRIPTION = "Twisted.Web2 is the next generation Web Server Framework \
built with Twisted. Web2 is under active development and it's APIs should \
not be considered stable at this point. It is not a version of Twisted.Web \
and with that in mind compatibility is not of the highest concern, though \
the compatibility layer does support many but not all twisted.web resources."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "twisted twisted-native"
RDEPENDS = "twisted python-netserver"

SRCDATE = "20070620"
PR = "r1"
PV = "0.2.0svn${SRCDATE}"

SRC_URI = "http://tmrc.mit.edi/mirror/twisted/Web2/TwistedWeb2-0.2.0.tar.bz2 \
	   svn://svn.twistedmatrix.com/svn/Twisted/trunk/twisted;module=web2"
S = "${WORKDIR}/TwistedWeb2-0.2.0"

do_munge() {
	rm -R ${S}/twisted/web2
	mv ${WORKDIR}/web2 ${S}/twisted
}

addtask munge before do_patch after do_unpack

inherit distutils
