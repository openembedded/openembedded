SECTION = "console/utils"
include vim_${PV}.bb
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/vim-${PV}"
LICENSE = "vim"
EXTRA_OECONF = "--enable-gui=none --disable-gtktest \
		--disable-xim --with-features=tiny \
		--disable-gpm --without-x --disable-netbeans \
		--with-tlib=ncurses"

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	       /bin /sbin /lib/*/ /lib/*.so* ${datadir}/vim"
