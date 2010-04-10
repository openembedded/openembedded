DESCRIPTION = "The Revision Control System (RCS) manages multiple revisions of files."
HOMEPAGE = "http://www.cs.purdue.edu/homes/trinkle/RCS/"
SECTION = "console/network"
LICENSE = "RCS"
PR = "r0"

SRC_URI = "\
  http://www.cs.purdue.edu/homes/trinkle/RCS/rcs-${PV}.tar.Z \
  file://fix-installpath.patch;patch=1 \
  file://oe-src-conf.h \
"

inherit autotools

EXTRA_OECONF += "--with-diffutils"

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/oe-src-conf.h ${S}/src/conf.h
}

RDEPENDS = "diffutils"

SRC_URI[md5sum] = "423282f0edb353296d9f3498ab683abf"
SRC_URI[sha256sum] = "7b7d2f7f5c2bbb096d23ee6dc5590b7d0b84e16ed54694d5794b7a4a989a63ad"
