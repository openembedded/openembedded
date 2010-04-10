DESCRIPTION = "VisiScript is a simple graphical frontend for \
scripting languages like minscript, Python,Ruby, Perl or others. \
VisiScript runs on the Qtopia desktop environment of the Zaurus."
SECTION = "opie/applications"
DEPENDS = "qscintilla"
LICENSE = "GPL"
PR = "r1"

APPNAME = "visiscript"
APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/visiscript_src_${PV}.tar.gz \
           file://qptrlist.h file://qcleanuphandler.h"
S = "${WORKDIR}/visiscript-${PV}"

inherit opie

QMAKE_PROFILES = "zvisiscript.pro"

EXTRA_QMAKEVARS_POST += "LIBS-=../qscintilla-1.60-gpl-1.3/qt/lib/libqscintilla_arm.a LIBS+=-lqscintilla"
export OE_QMAKE_LINK="${CXX}"

do_compile_prepend() {
	install -m 0644 ${WORKDIR}/*.h ${S}
}

do_install() {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 Visiscript.png ${D}${palmtopdir}/pics
}

#FIXME: package help and translation

SRC_URI[md5sum] = "c43beaef5817fe525099341620e3584b"
SRC_URI[sha256sum] = "3ec61d179aa29811f1383bd99c529342aecea1b3b4cffaa8670aecd7486d0c94"
