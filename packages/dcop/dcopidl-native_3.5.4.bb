DESCRIPTION = "DCOP IDL parser"
SECTION     = "kde/dev"
PRIORITY    = "optional"
MAINTAINER  = "freyther@kde.org"
LICENSE     = "GPL"
DEPENDS     = "uicmoc3-native"


SRC_URI     = "svn://anonsvn.kde.org/home/kde/branches/KDE/3.5/kdelibs/dcop/;module=dcopidl \
	      file://dcopidl-compile.patch;patch=1 "
S           = "${WORKDIR}/dcopidl" 


inherit native qmake qt3e

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl "
EXTRA_QMAKEVARS_POST_append = "CONFIG-=thread "

# create a .pro file now
do_configure_prepend() {
     echo "SOURCES += main.cpp yacc.cc scanner.cc " > dcopidl.pro
     echo "HEADERS += yacc.cc.h " >> dcopidl.pro
}

do_stage() {
     install -d ${STAGING_BINDIR}
     install -m 0755 dcopidl ${STAGING_BINDIR}
}
