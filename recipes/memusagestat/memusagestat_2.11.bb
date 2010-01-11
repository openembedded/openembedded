LICENSE = "GPL"
DESCRIPTION = "Generate graphic from memory profiling data"

DEPENDS = "gd"
SRC_URI = "http://www.secretlabs.de/memusagestat.c;name=tarball"

SRC_URI[tarball.md5sum] = "981a7f34d891dfd2e4696354d284a328"
SRC_URI[tarball.sha256sum] = "b4c0a9353cffa57c5af5fc304b3cc322ca3a0ff78149471f6cf5d5c249054b49"

S = "${WORKDIR}"

do_compile() {
    ${CC} -o memusagestat memusagestat.c ${CFLAGS} ${CPPFLAGS} ${LDFLAGS} -lgd
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 memusagestat ${D}/${bindir}
}
