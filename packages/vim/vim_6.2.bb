DEPENDS = "ncurses"
DESCRIPTION = "Vim is an almost fully-compatible \
version of the Unix editor Vi."
SECTION = "console/utils"

LICENSE = "vim"

SRC_URI = "ftp://ftp.vim.org/pub/vim/unix/vim-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/vim62/src"

inherit autotools

EXTRA_OECONF = "--enable-gui=none --disable-gtktest \
		--disable-xim --with-features=normal \
		--disable-gpm --without-x --disable-netbeans \
		--with-tlib=ncurses"

do_configure () {
	rm -f auto/*
	touch auto/config.mk
	aclocal
        autoconf
	oe_runconf
	touch auto/configure
	touch auto/config.mk auto/config.h
}

#FILES_${PN}-doc=${datadir}/vim/vim62/doc ${mandir} ${infodir}
