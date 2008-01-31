DESCRIPTION = "Simplest possible indexer (from older release of xapian)"
HOMEPAGE = "http://users.softlab.ece.ntua.gr/~ttsiod/buildWikipediaOffline.html"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "xapian-core"
PR = "r0"

SRC_URI = "http://users.softlab.ece.ntua.gr/~ttsiod/quickstartindex.cc"
S = "${WORKDIR}"

do_compile() {
        ${CXX} ${CXXLAGS} ${LDFLAGS} -lxapian -o quickstartindex quickstartindex.cc
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/quickstartindex ${D}${bindir}/
}
