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
