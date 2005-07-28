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
