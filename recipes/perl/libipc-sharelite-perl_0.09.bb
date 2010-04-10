DESCRIPTION = "IPC::ShareLite - Light-weight interface to shared memory"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r14"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MAURICE/IPC-ShareLite-${PV}.tar.gz"

S = "${WORKDIR}/IPC-ShareLite-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/IPC/ShareLite/* \
                ${PERLLIBDIRS}/IPC"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "3942a55cfc5e6d3b612a46cc1a9515b9"
SRC_URI[sha256sum] = "e6dafb82ddf7730ebe7ae2de0ce158d3052d782780b41a14c4fed304e463632e"
