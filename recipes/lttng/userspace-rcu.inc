DESCRIPTION = "Userspace RCU - liburcu is a userspace RCU (read-copy-update) library."
SECTION = "libs"
PRIORITY = "optional"
PROVIDES = "liburcu"
LICENSE = "LGPLv2.1"

PR = "r1"

SRC_URI = "http://lttng.org/files/urcu/userspace-rcu-${PV}.tar.bz2"

S = "${WORKDIR}/userspace-rcu-${PV}"

inherit autotools
