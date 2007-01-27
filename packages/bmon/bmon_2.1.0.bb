DESCRIPTION = "Portable Bandwidth Monitor and rate estimator"
HOMEPAGE = "http://people.suug.ch/~tgr/bmon/"
SECTION = "console/utilities"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
LICENSE = "MIT"
DEPENDS = "libnl"
PR = "r0"

SRC_URI = "http://people.suug.ch/~tgr/bmon/files/bmon-2.1.0.tar.gz \
           file://no-strip.patch;patch=1"

inherit autotools

do_compile() {
    oe_runmake
}
