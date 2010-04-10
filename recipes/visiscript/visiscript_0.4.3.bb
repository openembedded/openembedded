DESCRIPTION = "VisiScript is a simple graphical frontend for \
scripting languages like minscript, Python,Ruby, Perl or others. \
VisiScript runs on the Qtopia desktop environment of the Zaurus."
SECTION = "opie/applications"
DEPENDS = "qscintilla"
LICENSE = "GPL"
APPNAME = "visiscript"
APPTYPE = "binary"
APPDESKTOP = "${S}"

BROKEN = "1"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/visiscript_src_${PV}.tar.gz \
           file://qptrlist.h file://qcleanuphandler.h"

S = "${WORKDIR}/visiscript-${PV}"

inherit opie

QMAKE_PROFILES = "zvisiscript.pro"
PARALLEL_MAKE = ""

EXTRA_QMAKEVARS_POST += "LIBS-=../qscintilla-1.65-gpl-1.6/qt/libqscintilla.a LIBS+=-lqscintilla LIBS+=-ldl"
export OE_QMAKE_LINK="${CXX}"

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/*.h ${S}
}

do_install() {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 Visiscript.png ${D}${palmtopdir}/pics
}

#FIXME: package help and translation

SRC_URI[md5sum] = "f625eb9cffa82e35c3c477c58aa98795"
SRC_URI[sha256sum] = "39f2dfd8aaf41b51aadaa06c862b75d82c8f0ffd268d03d37e5895c038366271"
