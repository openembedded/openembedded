DESCRIPTION = "DCOP IDL parser"
SECTION = "kde/devel"
PRIORITY    = "optional"
LICENSE     = "GPL"
DEPENDS     = "uicmoc3-native"

SRC_URI     = "ftp://download.kde.org/pub/kde/stable/3.5.4/src/kdelibs-3.5.4.tar.bz2 "
#\
#	      file://dcopidl-compile.patch;patch=1 "
S           = "${WORKDIR}/kdelibs-3.5.4/dcop/dcopidl2cpp"

inherit native qmake qt3e

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl "
EXTRA_QMAKEVARS_POST_append = "CONFIG-=thread "

# create a .pro file now
do_configure_prepend() {
     echo "SOURCES += main.cpp skel.cpp stub.cpp stubimpl.cpp" > dcopidl2cpp.pro
     echo "HEADERS += main.h " >> dcopidl2cpp.pro
}

do_stage() {
     install -d ${STAGING_BINDIR}
     install -m 0755 dcopidl2cpp ${STAGING_BINDIR}
}
