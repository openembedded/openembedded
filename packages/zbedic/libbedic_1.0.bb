DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/zbedic/misc"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/libbedic_${PV}-0.tgz"

S = "${WORKDIR}"

inherit palmtop
# need to override this, because bedic contains exception handling
export OE_QMAKE_CXXFLAGS="-fexceptions -fno-rtti ${CXXFLAGS}"

do_configure() {
	qmake -project && qmake -makefile -t lib -spec ${QMAKESPEC} CONFIG=console CONFIG+=staticlib -after \
        INCLUDEPATH+=../include TARGET=bedic DESTDIR=${STAGING_LIBDIR} \
	HEADERS+=src/file.h SOURCES+=src/file.cpp SOURCES-=tools/xerox.cpp \
	SOURCES-=src/test_dynamic_dictionary.cpp \
	SOURCES-=src/test_dynamic_database.cpp \
	CXXFLAGS+=-fexceptions
}

do_stage() {
    install -d ${STAGING_INCDIR}/libbedic/
    install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/libbedic/
}
