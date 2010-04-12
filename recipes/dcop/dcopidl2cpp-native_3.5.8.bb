DESCRIPTION = "DCOP IDL parser"
SECTION = "kde/devel"
PRIORITY    = "optional"
LICENSE     = "GPL"
DEPENDS     = "uicmoc3-native"

SRC_URI     = "ftp://download.kde.org/pub/kde/stable/${PV}/src/kdelibs-${PV}.tar.bz2"
#\
#	      file://dcopidl-compile.patch;patch=1 "
S           = "${WORKDIR}/kdelibs-${PV}/dcop/dcopidl2cpp"

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

SRC_URI[md5sum] = "acaa37e79e840d10dca326277a20863c"
SRC_URI[sha256sum] = "779f563fdf0385b973f2238f04d82b5729aefe1c949e4d29482b6bb170aa3fe6"
