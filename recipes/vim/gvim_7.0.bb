VIMVER = "70"

require vim.inc

DEPENDS += "gtk+ xt"
PR = "${INC_PR}.1"
FILESPATHPKG =. "vim-${PV}:vim:"

EXTRA_OECONF = "--enable-gui=gtk2 --enable-gtk2-test --disable-gtktest \
		--disable-xim --with-features=big \
		--disable-gpm --with-x --disable-netbeans \
		--with-tlib=ncurses"

#might needs RREPLACES as well
RCONFLICTS_${PN} = "vim"
