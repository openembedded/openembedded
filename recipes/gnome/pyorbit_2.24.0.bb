DESCRIPTION = "Python Orbit bindings"
LICENSE = "LGPL"

PR = "r0"

inherit gnome distutils-base pkgconfig

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"
EXTRA_OEMAKE = "-e"

do_configure() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	export HOST_SYS=${HOST_SYS}
	export BUILD_SYS=${BUILD_SYS}
	export CC=${TARGET_PREFIX}gcc
	autotools_do_configure
}

do_stage() {
	install -d ${STAGING_INCDIR}/pyorbit-2
	install -m 0644 src/pyorbit.h ${STAGING_INCDIR}/pyorbit-2
	autotools_stage_all
}
