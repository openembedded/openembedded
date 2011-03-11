DESCRIPTION = "The libevent API provides a mechanism to execute a callback function \
when a specific event occurs on a file descriptor or after a timeout has been reached. \
Furthermore, libevent also support callbacks due to signals or regular timeouts."
HOMEPAGE = "http://www.monkey.org/~provos/libevent/"
SECTION = "libs"
AUTHOR = "Niels Provos <provos@citi.umich.edu>"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://monkey.org/~provos/libevent-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "a37401d26cbbf28185211d582741a3d4"
SRC_URI[sha256sum] = "a4b55810a9e21e9991b86ba5e82dbc9280598cc070544c4ecef4ab91b93dfc55"

