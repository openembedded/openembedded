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


SRC_URI[md5sum] = "59c92b223f69cc7e50ae6cd9d1539db1"
SRC_URI[sha256sum] = "38f24694983f20e5bffa2ebc1d35a7c3abea50479a6df6449cc900bf2732891d"
