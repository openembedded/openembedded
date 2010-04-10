DESCRIPTION = "An sh-compatible command language interpreter."
HOMEPAGE = "http://cnswww.cns.cwru.edu/~chet/bash/bashtop.html"
DEPENDS = "ncurses"
SECTION = "base/shell"
LICENSE = "GPL"

inherit autotools gettext

PARALLEL_MAKE = ""

SRC_URI = "${GNU_MIRROR}/bash/bash-${PV}.tar.gz;name=archive"
S = "${WORKDIR}/bash-${PV}"

bindir = "/bin"
sbindir = "/sbin"

EXTRA_OECONF = "--with-ncurses"

do_configure () {
	gnu-configize
	oe_runconf
}

do_compile_prepend() {
	cd builtins
	touch mkbuiltins.o
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} -I${S}/include -I${S} -o mkbuiltins mkbuiltins.c
	cd ${S}
}

pkg_postinst () {
	touch $D${sysconfdir}/shells
	grep -q "bin/bash" $D${sysconfdir}/shells || echo /bin/bash >> $D${sysconfdir}/shells
	grep -q "bin/sh" $D${sysconfdir}/shells || echo /bin/sh >> $D${sysconfdir}/shells
}
