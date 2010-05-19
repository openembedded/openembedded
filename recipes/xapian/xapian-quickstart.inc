DESCRIPTION = "Simplest possible indexer (from an older release of xapian)."
HOMEPAGE = "http://users.softlab.ece.ntua.gr/~ttsiod/buildWikipediaOffline.html"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "xapian-core"

BINARY_NAME = ${@bb.data.getVar("PN",d,1).replace("xapian-","").replace("-native","")}
S = "${WORKDIR}"

SRC_URI = "http://users.softlab.ece.ntua.gr/~ttsiod/${BINARY_NAME}.cc"

do_compile() {
        ${CXX} ${CXXLAGS} ${LDFLAGS} -I${STAGING_INCDIR_NATIVE} -lxapian -o ${BINARY_NAME} ${BINARY_NAME}.cc
}

do_install() {
        install -d ${D}
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/${BINARY_NAME} ${D}${bindir}/
}
