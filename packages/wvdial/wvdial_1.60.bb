HOMEPAGE = "http://www.alumnit.ca/wiki/?WvDial"
DESCRIPTION = "WvDial is a program that makes it easy to connect your Linux workstation to the Internet."

LICENSE = "LGPL"
SRC_URI = "http://www.alumnit.ca/download/wvdial-1.60.tar.gz"

DEPENDS = "wvstreams"
RDEPENDS = "ppp"

EXTRA_OEMAKE = ""
export WVLINK="${LD}"

do_install() {
    oe_runmake prefix=${D}/usr PPPDIR=${D}/etc install
}
