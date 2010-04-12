DESCRIPTION = "A lightweight signal/slot library for decoupling C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/slotsig/slotsig-${PV}.tar.bz2"

do_compile() {
	${CXX} -c -fPIC ${CXXFLAGS} -o slotsig_bases.o slotsig/slotsig_bases.cpp
	${CXX} -shared -o libslotsig.so.${PV} slotsig_bases.o
}

do_stage() {
	oe_libinstall -so libslotsig ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/slotsig/
	for X in slotsig/*.h
	do
		install -m 0644 ${S}/$X ${STAGING_INCDIR}/$X
	done
}

do_install() {
	oe_libinstall -so libslotsig ${D}${libdir}
}

SRC_URI[md5sum] = "dfe9f5d3f17075ec23eb923899ac5f24"
SRC_URI[sha256sum] = "124499d3c5d2d44ab07b60c235547079044f3728fd3c907987900e270bd947f8"
