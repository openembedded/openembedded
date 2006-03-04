DESCRIPTION = "eciadsl is a usermode driver for GlobeSpan-based ADSL modems"
SECTION = "net"
SRC_URI = "http://eciadsl.flashtux.org/download/eciadsl-usermode-${PV}.tar.gz \
           file://eciadsl-bash.patch;patch=1"
LICENSE = "GPL"
RDEPENDS = "bash kernel-module-n_hdlc ppp grep"
S = "${WORKDIR}/eciadsl-usermode-${PV}"

inherit autotools
