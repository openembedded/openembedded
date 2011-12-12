require iproute2.inc

PR = "${INC_PR}.0"

SRC_URI = "http://pkgs.fedoraproject.org/repo/pkgs/iproute/iproute2-2.6.38.1.tar.bz2/c18932fb8570af4456dbde50b1e90806/${P}.tar.bz2 \
	   file://configure-cross.patch \
	  "

SRC_URI[md5sum] = "c18932fb8570af4456dbde50b1e90806"
SRC_URI[sha256sum] = "c04d55ad353386184bc2a53482dcd5849249ce5b958b90115ff61d6b628ce61b"

S = "${WORKDIR}/iproute2-${PV}"

do_configure () {
    ./configure ${STAGING_DIR_TARGET}
}

do_install_append() {
	install -m 0755 tc/tc ${D}${base_sbindir}
}
