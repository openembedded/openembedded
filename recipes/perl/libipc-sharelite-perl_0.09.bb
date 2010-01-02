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
