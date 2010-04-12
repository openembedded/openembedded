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

SRC_URI[md5sum] = "45097f269c7847266e121e4a0f362be9"
SRC_URI[sha256sum] = "e4d35719c10c372bfca8247d127c941958557aabca61c25a04f213e22cc40728"
