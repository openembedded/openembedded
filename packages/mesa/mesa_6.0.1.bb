SECTION = "unknown"
SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2 \
	file://Make-config.patch;patch=1 \
	file://mklib.patch;patch=1"
S = "${WORKDIR}/Mesa-${PV}"
LICENSE = "LGPL"
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
