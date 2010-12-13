DESCRIPTION = "A JavaScript engine"
LICENSE = "GPL"
SECTION = "libs/network"
DEPENDS = "readline ncurses" 

PR = "r4"

SRC_URI = "http://ftp.mozilla.org/pub/mozilla.org/js/older-packages/js-1.5.tar.gz \
	   file://libtermcap.patch \
	   file://ld.patch \
           file://jsautocfg.h"
S = "${WORKDIR}/js/src"

EXTRA_OEMAKE = "'CC=${CC}' 'LD=${LD}' 'XCFLAGS=${CFLAGS}' 'XLDFLAGS=-L${STAGING_LIBDIR} -soname=libjs'"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/
}

do_compile() {
	oe_runmake -f Makefile.ref JS_READLINE=1 JS_EDITLINE=1 PREBUILT_CPUCFG=1
}

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${includedir}
	install -d ${D}${includedir}/js
	oe_libinstall -so -C Linux_All_DBG.OBJ libjs ${D}${libdir}
	install -m 0644 ${S}/*.h ${D}${includedir}/js
}

FILES_${PN} = "${libdir}/lib*.so"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*.a"

SRC_URI[md5sum] = "863bb6462f4ce535399a7c6276ae6776"
SRC_URI[sha256sum] = "ef72a154320c9949f8de0732e8dbfa186b83feb0a5e890d90807757de9998585"
