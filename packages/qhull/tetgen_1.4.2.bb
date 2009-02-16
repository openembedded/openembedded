DESCRIPTION = "A Quality Tetrahedral Mesh Generator and Three-Dimensional Delaunay Triangulator."
LICENSE = "MIT"

SRC_URI = "http://www.wias-berlin.de/people/si/tetgen${PV}.tar.gz"

S = "${WORKDIR}/tetgen${PV}"

CXX += " ${LDFLAGS}"

do_configure() {
	sed -i -e s:ar\ :'${AR}'\ :g makefile 
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 tetgen ${D}${bindir}/
}

