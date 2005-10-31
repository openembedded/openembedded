VIMVER = "64"

include vim.inc

EXTRA_OECONF = "--enable-gui=none --disable-gtktest \
		--disable-xim --with-features=normal \
		--disable-gpm --without-x --disable-netbeans \
		--with-tlib=ncurses"

