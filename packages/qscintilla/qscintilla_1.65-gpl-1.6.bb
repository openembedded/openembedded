DESCRIPTION = "Qt/Embedded bindings for the Scintilla source code editor component"
SECTION = "opie/libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/qscintilla-${PV}_zaurus.tar.gz \
           file://no-external-lexers.patch;patch=1;pnum=0"

S = "${WORKDIR}/qscintilla-${PV}/qt"

inherit opie

QMAKE_PROFILES = "qscintilla.pro"

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${S}/patches \
                         DEFINES+=ZPATCH DEFINES+=ZAURUS \
			 HEADERS-=qextscintillaprinter.h \
			 SOURCES-=qextscintillaprinter.cpp \
			 SOURCES+=patches/qsettings.cpp \
			 SOURCES+=patches/qsettings_unix.cpp \
			 HEADERS+=patches/qsettings.h"

PARALLEL_MAKE = ""

do_stage() {
	install -m 0644 qextscintilla*.h ${STAGING_INCDIR}/
	oe_libinstall -so libqscintilla ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${libdir}
	oe_libinstall -so libqscintilla ${D}${libdir}
}

FILES_${PN} = "${libdir}"
