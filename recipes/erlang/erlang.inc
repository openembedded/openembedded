DESCRIPTION = "A dynamic programming language and runtime environment, \
with built-in support for concurrency, distribution and fault tolerance"
SECTION = "devel/erlang"
DEPENDS = "ncurses"
PRIORITY = "optional"
LICENSE = "ERLANG PUBLIC LICENSE"

UPSTREAM_VERSION = "${@bb.data.getVar('PV', d, 1).replace('.', '-')}"

SRC_URI = "http://erlang.org/download/otp_src_${UPSTREAM_VERSION}.tar.gz"
S = "${WORKDIR}/otp_src_${UPSTREAM_VERSION}"

inherit autotools
