HOMEPAGE = "http://www.alumnit.ca/wiki/?WvDial"
DESCRIPTION = "WvDial is a program that makes it easy to connect your Linux workstation to the Internet."

PR = "r2"

LICENSE = "LGPL"
SRC_URI = "http://www.alumnit.ca/download/wvdial-1.60.tar.gz"

DEPENDS = "wvstreams"
RDEPENDS = "ppp"

EXTRA_OEMAKE = ""
export CC="${CXX}"

do_install() {
    oe_runmake prefix=${D}/usr PPPDIR=${D}/etc/ppp/peers install
}

SRC_URI[md5sum] = "27fbbde89f8fd9f6e735a8efa5217fc9"
SRC_URI[sha256sum] = "0c65ea807950fab32e659d1869a7167ff978502bd5d0159dbe9de90eb6c2e16b"
