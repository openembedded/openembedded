HOMEPAGE = "http://www.alumnit.ca/wiki/?WvDial"
DESCRIPTION = "WvDial is a program that makes it easy to connect your Linux workstation to the Internet."

PR = "r1"

LICENSE = "LGPL"
SRC_URI = "http://www.alumnit.ca/download/wvdial-1.56.tar.gz \
           file://fixmakefile.patch;patch=1"

DEPENDS = "wvstreams"
RDEPENDS = "ppp"

EXTRA_OEMAKE = ""
export WVLINK="${LD}"
LDFLAGS_append = " -luniconf"

do_install() {
    oe_runmake prefix=${D}/usr PPPDIR=${D}/etc/ppp/peers install
}
