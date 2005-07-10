LICENSE = "GPL"
SECTION = "unknown"
DEPENDS = "elftoaout-native"

SRC_URI = "http://www.sparc-boot.org/pub/silo/silo-${PV}.tar.bz2 \
	file://cross.patch;patch=1"

do_compile() {
	oe_runmake CC="${CC} -m32" LD="${LD}" HOSTCC="${BUILD_CC}" HOSTCFLAGS="${BUILD_CFLAGS}" OECFLAGS="${CFLAGS}" OELDFLAGS="-L${STAGING_LIBDIR} -rpath-link ${STAGING_LIBDIR}" NM="${TARGET_SYS}-nm"
}

do_stage() {
	install tilo/maketilo ${STAGING_BINDIR}
	install tilo/tilo.sh ${STAGING_BINDIR}
}
