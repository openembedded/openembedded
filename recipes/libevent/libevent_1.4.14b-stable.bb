DESCRIPTION = "The libevent API provides a mechanism to execute a callback function \
when a specific event occurs on a file descriptor or after a timeout has been reached. \
Furthermore, libevent also support callbacks due to signals or regular timeouts."
HOMEPAGE = "http://www.monkey.org/~provos/libevent/"
SECTION = "libs"
AUTHOR = "Niels Provos <provos@citi.umich.edu>"
LICENSE = "BSD"
PR = "r1"

SRC_URI = "http://monkey.org/~provos/libevent-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "a00e037e4d3f9e4fe9893e8a2d27918c"
SRC_URI[sha256sum] = "afa61b476a222ba43fc7cca2d24849ab0bbd940124400cb699915d3c60e46301"
