VIMVER = "70"

require vim.inc

DEPENDS += "gtk+"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/vim-7.0', '${FILE_DIRNAME}/vim', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

EXTRA_OECONF = "--enable-gui=gtk2 --enable-gtk2-test --disable-gtktest \
		--disable-xim --with-features=normal \
		--disable-gpm --with-x --disable-netbeans \
		--with-tlib=ncurses"

#might needs RREPLACES as well
RCONFLICTS_${PN} = "vim"
