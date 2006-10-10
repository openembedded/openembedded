SECTION = "utils"
DESCRIPTION = "mdadm is a tool for creating, managing and monitoring \
device arrays using the "md" driver in Linux, also \
known as Software RAID arrays."
LICENSE = "GPL"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/raid/mdadm/${PN}-${PV}.tar.bz2"

CFLAGS += "-fno-strict-aliasing"


inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install() {
	export STRIP=""
	autotools_do_install
}
