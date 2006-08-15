SRC_URI = "ftp://ftp.gnu.org/gnu/aspell/aspell-${PV}.tar.gz \
	file://mk-dirs_h.py \
	file://makefile.patch;patch=1"
DESCRIPTION = "GNU Aspell spell-checker"
SECTION = "console/utils"
LICENSE="LGPL"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/aspell-${PV}"

inherit autotools native

S = "${WORKDIR}/aspell-${PV}"

do_compile_prepend() {
	install ${WORKDIR}/mk-dirs_h.py ${S}/common/mk-dirs_h
}

