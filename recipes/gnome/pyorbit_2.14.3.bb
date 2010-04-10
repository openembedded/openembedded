DESCRIPTION = "Python Orbit bindings"
LICENSE = "LGPL"

PR = "r0"

inherit gnome distutils-base pkgconfig

do_configure() {
	export HOST_SYS=${HOST_SYS}
	export BUILD_SYS=${BUILD_SYS}
	autotools_do_configure
}

do_stage() {
	install -d ${STAGING_INCDIR}/pyorbit-2
	install -m 0644 src/pyorbit.h ${STAGING_INCDIR}/pyorbit-2
}

SRC_URI[archive.md5sum] = "3c4d42ae1a7303fd85071a842617043f"
SRC_URI[archive.sha256sum] = "a3517e0ddaf23508f99e7489a23e3462f86c528ea24bce432e832a78ee4149db"
