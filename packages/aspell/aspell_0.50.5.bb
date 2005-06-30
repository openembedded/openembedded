SRC_URI = "ftp://ftp.gnu.org/gnu/aspell/aspell-${PV}.tar.gz \
	file://mk-dirs_h.py \
	file://makefile.patch;patch=1"
DESCRIPTION = "GNU Aspell spell-checker"
SECTION = "console/utils"
LICENSE="LGPL"

PACKAGES =+ "libaspell libpspell libpspell-dev aspell-utils"

FILES_libaspell = "${libdir}/libaspell.so.* ${datadir}/aspell"
FILES_aspell-utils = "${bindir}/word-list-compress ${bindir}/aspell-import ${bindir}/run-with-aspell"
FILES_${PN} = "${bindir}/aspell"
FILES_libpspell = "${libdir}/libpspell.so.*"
FILES_libpspell-dev = "${libdir}/libpspell* ${bindir}/pspell-config ${includedir}/pspell"

inherit autotools

do_compile_prepend() {
	install ${WORKDIR}/mk-dirs_h.py ${S}/common/mk-dirs_h
}

do_stage() {
	oe_libinstall -C lib -so libaspell ${STAGING_LIBDIR}
	install -m 0644 interfaces/cc/aspell.h ${STAGING_INCDIR}
	oe_libinstall -C lib -so libpspell ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/pspell
	install -m 0644 interfaces/cc/pspell.h ${STAGING_INCDIR}/pspell
}
