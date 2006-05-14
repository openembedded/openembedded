DESCRIPTION = "The libevent API provides a mechanism to execute a callback function \
when a specific event occurs on a file descriptor or after a timeout has been reached. \
Furthermore, libevent also support callbacks due to signals or regular timeouts."
HOMEPAGE = "http://www.monkey.org/~provos/libevent/"
SECTION = "libs"
AUTHOR = "Niels Provos <provos@citi.umich.edu>"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "BSD"

SRC_URI = "http://monkey.org/~provos/libevent-${PV}.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_all
}

