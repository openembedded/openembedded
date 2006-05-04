DESCRIPTION = "Qt/Embedded bindings for the Scintilla source code editor component"
SECTION = "opie/libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/qscintilla-${PV}_zaurus.tar.gz"

S = "${WORKDIR}/qscintilla-${PV}/qt"

inherit opie

QMAKE_PROFILES = "qscintilla.pro"

EXTRA_QMAKEVARS_POST += " CONFIG-=thread INCLUDEPATH+=${S}/patches DEFINES+=ZPATCH \
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
