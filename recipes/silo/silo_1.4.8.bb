LICENSE = "GPL"
SECTION = "unknown"
DEPENDS = "elftoaout-native"

SRC_URI = "http://www.sparc-boot.org/pub/silo/silo-${PV}.tar.bz2 \
	file://cross.patch;patch=1"

do_compile() {
	oe_runmake CC="${CC} -m32" LD="${LD}" HOSTCC="${BUILD_CC}" HOSTCFLAGS="${BUILD_CFLAGS}" OECFLAGS="${CFLAGS}" OELDFLAGS="-L${STAGING_LIBDIR} -rpath-link ${STAGING_LIBDIR}" NM="${TARGET_SYS}-nm"
}

# Should this package be installing into native? - not good... RP 
do_stage() {
	install tilo/maketilo ${STAGING_BINDIR_NATIVE}
	install tilo/tilo.sh ${STAGING_BINDIR_NATIVE}
}

SRC_URI[md5sum] = "badc27616dc92ad42f5e30751a6b322c"
SRC_URI[sha256sum] = "2c5e3a832662aa962f700e64ce3c1fc8c77e801000c47b8d66feeb03e66d95de"
