SECTION = "unknown"

SRCDATE = "20060101"
PV = "6.4.1+cvs${SRCDATE}"
PE = "2"

SRC_URI = "${FREEDESKTOP_CVS}/mesa;module=Mesa;method=pserver;date=${SRCDATE} \
	file://mklib-rpath-link.patch;patch=1"
S = "${WORKDIR}/Mesa"

LICENSE = "LGPL"

RDEPENDS = "expat"
DEPENDS = "makedepend-native xf86vidmodeproto glproto virtual/libx11 libxext libxxf86vm libxi libxmu libice"

# gcc-3.4 blows up in gtktext with -frename-registers on arm-linux
CXXFLAGS := "${@'${CXXFLAGS}'.replace('-frename-registers', '')}"

do_configure() {
	cd configs

	ln -sf linux current
	sed -e "s%CC *= *.*%CC = ${CC}%" -i current
	sed -e "s%CXX *= *.*%CXX = ${CXX}%" -i current
	sed -e "s%LD *= *.*%LD = ${LD}%" -i current
	sed -e "s%OPT_FLAGS *= *.*%OPT_FLAGS = ${TARGET_CFLAGS}%" -i current
	sed -e "s%X11_INCLUDES *= *.*%X11_INCLUDES = -I${STAGING_INCDIR}/X11%" -i current
	sed -e "s%EXTRA_LIB_PATH *= *.*%EXTRA_LIB_PATH = ${LDFLAGS}%" -i current
	sed -i s:\$\(CC\):gcc:g  ../src/mesa/x86/Makefile
	echo "SRC_DIRS = mesa glu glut/glx" >> current
}

do_compile() {
	oe_runmake default
}

do_install() {
	install -d ${D}${libdir}
	cp -pP lib/* ${D}${libdir}/
	install -d ${D}${includedir}
	cp -R include/GL ${D}${includedir}/
}

do_stage() {
        cp -pP lib/* ${STAGING_LIBDIR}/
        cp -R include/GL ${STAGING_INCDIR}/
}
