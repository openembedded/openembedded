LICENSE = "LGPL"

SRCREV = "a80d7d5c25e88adea7b8e843cdb57143e6cfb46b"
SRC_URI = "git://git.0pointer.de/libatasmart.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools_stage lib_package
AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_prepend() {
	rm strpool -f
	${BUILD_CC} -o strpool strpool.c
	chmod +x strpool
}

do_stage_append() {
	sed -i -e s://:/:g -e s:${base_libdir}/libudev.la:-ludev:g ${STAGING_LIBDIR}/libatasmart.la
}

