DESCRIPTION = "eciadsl is a usermode driver for GlobeSpan-based ADSL modems"
SECTION = "net"
SRC_URI = "http://eciadsl.flashtux.org/download/eciadsl-usermode-${PV}.tar.gz \
           file://eciadsl-bash.patch"
LICENSE = "GPL"
RDEPENDS_${PN} = "bash kernel-module-n_hdlc ppp grep"
S = "${WORKDIR}/eciadsl-usermode-${PV}"
PR = "r1"

inherit autotools

SRC_URI[md5sum] = "c3c60c83f6df30021e11da50a699dec9"
SRC_URI[sha256sum] = "2382f315fda4241a0043bac1dfc669f006d8e93e87fa382b263b1672972f4077"
