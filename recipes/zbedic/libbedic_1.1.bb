DESCRIPTION = "Library to handle bedic dictionary"
HOMEPAGE = "http://bedic.sourceforge.net/"
AUTHOR = "Rafal Mantiuk <rafm@users.sourceforge.net>"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "sqlite3"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/zbedic/misc"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/libbedic_${PV}-0.tgz"

S = "${WORKDIR}"

inherit palmtop
# need to override this, because bedic contains exception handling
# pass VERSION as a string \\"${PV}.0\\"
export OE_QMAKE_CXXFLAGS="-fexceptions -fno-rtti ${CXXFLAGS} -DVERSION=\\"${PV}.0\\""

do_configure() {
        qmake -project && qmake -makefile -t lib -spec ${QMAKESPEC} CONFIG=console CONFIG+=staticlib CONFIG+=sharedlib -after \
        TARGET=bedic \
        SOURCES-=src/xerox.cpp OBJECTS-=xerox.o \
        SOURCES-=src/mkbedic.cpp OBJECTS-=mkbedic.o \
        SOURCES-=src/test_dynamic_dictionary.cpp \
}

do_install() {
    install -d ${D}${includedir}
    install -m 0644 ${S}/include/*.h ${D}${includedir}
    install -d ${D}${libdir}
    oe_libinstall -a libbedic ${D}${libdir}
}

do_stage() {
    install -d ${STAGING_INCDIR}/libbedic/
    install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/libbedic/
    oe_libinstall -a libbedic ${STAGING_LIBDIR}
}

FILES_${PN}-dev = "${includedir} ${libdir}"
