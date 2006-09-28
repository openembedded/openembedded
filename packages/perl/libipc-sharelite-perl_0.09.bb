DESCRIPTION = "IPC::ShareLite - Light-weight interface to shared memory"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MAURICE/IPC-ShareLite-0.09.tar.gz"

S = "${WORKDIR}/IPC-ShareLite-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/IPC/ShareLite/* \
                ${libdir}/perl5/*/*/auto/IPC/ShareLite/.packlist \
                ${libdir}/perl5/*/*/IPC"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/IPC/ShareLite/.debug"
