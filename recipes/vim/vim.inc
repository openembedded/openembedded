DESCRIPTION = "Vim is an almost fully-compatible version of the Unix editor Vi."
SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "vim"

SRC_URI = "ftp://ftp.vim.org/pub/vim/unix/vim-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

S = "${WORKDIR}/vim${VIMVER}/src"

inherit autotools

do_configure () {
	rm -f auto/*
	touch auto/config.mk
	aclocal
        autoconf
	oe_runconf
	touch auto/configure
	touch auto/config.mk auto/config.h
}

PACKAGES =+ "vim-common vim-syntax vim-help vim-tutor"
FILES_vim-syntax = "${datadir}/vim/vim${VIMVER}/syntax"
FILES_vim-help = "${datadir}/vim/vim${VIMVER}/doc"
FILES_vim-tutor = "${datadir}/vim/vim${VIMVER}/tutor ${bindir}/vimtutor"

#FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
#	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
#	       /bin /sbin /lib/*/ /lib/*.so* ${datadir}/vim"
