DESCRIPTION = "BSD replacement for libreadline"
HOMEPAGE = "http://cvsweb.netbsd.org/bsdweb.cgi/src/lib/libedit/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE="BSD"
DEPENDS = "ncurses"

SRC_URI = "ftp://ftp.linux.ee/pub/gentoo/distfiles/distfiles/libedit-${PV}.tar.bz2 \
	file://20031222-debian-to-gentoo.patch;patch=1;pnum=1 \
	file://libedit-add-soname.diff;patch=1;pnum=0"

S = "${WORKDIR}/netbsd-cvs"

CFLAGS += "-I. -include ../glibc-bsd-glue/bsdcompat.h -I../glibc-compat -I../glibc-bsd-glue"

do_configure() {
	mv ${WORKDIR}/glibc-*/*.c .
	oe_runmake .depend
}

do_compile() {
	oe_runmake LIBS="-lncurses ${LDFLAGS}"
}

do_stage() {
	oe_libinstall -a -so libedit ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/editline/
	install readline/readline.h ${STAGING_INCDIR}/editline/
	install histedit.h ${STAGING_INCDIR}/editline/
}

do_install() {
	install -d ${D}${libdir} ${D}${includedir}/editline ${D}${mandir}
	oe_libinstall -a -so libedit ${D}${libdir}
	install readline/readline.h ${D}${includedir}/editline/
	install histedit.h ${D}${includedir}/editline/
	install *.[35] ${D}${mandir}
}

FILES_${PN} = "${libdir}/libedit.so"
