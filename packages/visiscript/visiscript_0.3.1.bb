DESCRIPTION = "VisiScript is a simple graphical frontend for \
scripting languages like minscript, Python,Ruby, Perl or others. \
VisiScript runs on the Qtopia desktop environment of the Zaurus."
SECTION = "opie/applications"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "qscintilla"
LICENSE = "GPL"
APPNAME = "visiscript"
APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/visiscript_src_${PV}.tar.gz \
	   file://compilefix.patch;patch=1"
S = "${WORKDIR}/visiscript"

inherit opie

QMAKE_PROFILES = "zvisiscript.pro"

EXTRA_QMAKEVARS_POST = "CONFIG-=thread LIBS-=../qscintilla-1.60-gpl-1.3/qt/libqscintilla.a LIBS+=-lqscintilla"

do_install() {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 Visiscript.png ${D}${palmtopdir}/pics
}

#FIXME: package help and translation
