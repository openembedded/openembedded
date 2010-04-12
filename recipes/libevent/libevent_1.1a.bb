DESCRIPTION = "The libevent API provides a mechanism to execute a callback function \
when a specific event occurs on a file descriptor or after a timeout has been reached. \
Furthermore, libevent also support callbacks due to signals or regular timeouts."
HOMEPAGE = "http://www.monkey.org/~provos/libevent/"
SECTION = "libs"
AUTHOR = "Niels Provos <provos@citi.umich.edu>"
LICENSE = "BSD"

SRC_URI = "http://monkey.org/~provos/libevent-${PV}.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "6cc776458ecaf9247550863702a44d7c"
SRC_URI[sha256sum] = "1725cd3dd9ec87a68316c36a50ab653c7e9581c91f9b1b7e9af42a9c7c499d8e"
