PR = "r1"
DESCRIPTION = "An Embeddable SQL Database Engine"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "readline ncurses"
LICENSE = "PD"

PACKAGES =+ "sqlite-bin"

FILES_sqlite-bin = "${bindir}"

SRC_URI = "http://www.hwaci.com/sw/sqlite/sqlite-${PV}.tar.gz \
           file://crosscompile.patch;patch=1"

S = "${WORKDIR}/sqlite"

inherit autotools

EXTRA_OECONF = "--without-tcl --enable-static --enable-shared"
EXTRA_OEMAKE = "'LIBREADLINE=-L${STAGING_LIBDIR} -lreadline -lncurses' 'LIBTOOL=${S}/${HOST_PREFIX}libtool'"
export config_BUILD_CC = "${BUILD_CC}"
export config_BUILD_CFLAGS = "${BUILD_CFLAGS}"
export config_TARGET_CC = "${CC}"
export config_TARGET_LINK = "${CCLD}"
export config_TARGET_CFLAGS = "${CFLAGS}"

do_compile () {
	oe_runmake
}

do_stage() {
	oe_libinstall -so libsqlite ${STAGING_LIBDIR}
	install -m 0644 sqlite.h ${STAGING_INCDIR}
}

do_install() {
	oe_runmake install prefix=${D}${prefix} exec_prefix=${D}${exec_prefix}
}

