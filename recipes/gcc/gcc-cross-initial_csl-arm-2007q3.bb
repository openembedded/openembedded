require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

S = "${WORKDIR}/gcc-4.2"

EXTRA_OECONF += "--disable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap "

# Hack till we fix *libc properly
do_install_append() {
	ln -sf ${CROSS_DIR}/lib/gcc/${TARGET_SYS}/${BINV}/include-fixed/* ${CROSS_DIR}/lib/gcc/${TARGET_SYS}/${BINV}/include/
}


SRC_URI[md5sum] = "ada6a8dff4a147f41de02174f8703a0b"
SRC_URI[sha256sum] = "adbc29af4d08e64a221e213597556bf2a7121503fd33a66a2ffceeeffb404e88"
