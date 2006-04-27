SECTION = "unknown"

SRCDATE = "20060101"
PV = "6.4.1+cvs${SRCDATE}"

SRC_URI = "${FREEDESKTOP_CVS}/mesa;module=Mesa;method=pserver;date=${SRCDATE}"
S = "${WORKDIR}/Mesa"

LICENSE = "LGPL"

RDEPENDS = "expat libx11 libxext libxxf86vm libxi libxmu libice"
DEPENDS = "xf86vidmodeproto glproto"

# gcc-3.4 blows up in gtktext with -frename-registers on arm-linux
CXXFLAGS := "${@'${CXXFLAGS}'.replace('-frename-registers', '')}"

do_compile() {
	oe_runmake linux CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}"
}

do_install() {
	install -d ${D}${libdir}
	cp -pd lib/* ${D}${libdir}/
	install -d ${D}${includedir}
	cp -r include/GL ${D}${includedir}/
}

do_stage() {
        cp -pd lib/* ${STAGING_LIBDIR}/
        cp -r include/GL ${STAGING_INCDIR}/
}
