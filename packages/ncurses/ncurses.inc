DESCRIPTION = "Ncurses library"
HOMEPAGE = "http://www.gnu.org/software/ncurses/ncurses.html"
SECTION = "libs"
LICENSE = "MIT"
DEPENDS = "ncurses-native"
RSUGGESTS_${PN} = "ncurses-terminfo"

inherit autotools

PARALLEL_MAKE = ""

EXTRA_OECONF = "--with-shared \
	        --without-profile \
	        --without-debug \
	        --disable-rpath \
	        --enable-echo \
	        --enable-const \
	        --without-ada \
	        --enable-termcap \
	        --without-cxx-binding \
	        --with-terminfo-dirs=${sysconfdir}/terminfo:${datadir}/terminfo \
	        --enable-overwrite"

export BUILD_CCFLAGS = "-I${S}/ncurses -I${S}/include ${BUILD_CFLAGS}"
export BUILD_LDFLAGS = ""
export EXTRA_OEMAKE = '"BUILD_LDFLAGS=" "BUILD_CCFLAGS=${BUILD_CCFLAGS}"'

do_stage() {
	autotools_stage_all
	ln -sf curses.h ${STAGING_INCDIR}/ncurses.h
	ln -sf libncurses.so ${STAGING_LIBDIR}/libtermcap.so
	ln -sf libncurses.a ${STAGING_LIBDIR}/libtermcap.a
}

# This is necessary so that the "tic" command executed during the install can
# link with the correct libary in staging.
export LD_LIBRARY_PATH = "${STAGING_LIBDIR_NATIVE}"

do_install() {
	autotools_do_install

	# our ncurses has termcap support
	ln -sf libncurses.so ${D}${libdir}/libtermcap.so
	ln -sf libncurses.a ${D}${libdir}/libtermcap.a

	# include some basic terminfo files
	# stolen ;) from gentoo and modified a bit
	for x in ansi console dumb linux rxvt screen sun vt{52,100,102,200,220} xterm-color xterm-xfree86
        do
                local termfile="$(find "${D}${datadir}/terminfo/" -name "${x}" 2>/dev/null)"
                local basedir="$(basename $(dirname "${termfile}"))"

                if [ -n "${termfile}" ]
                then
                        install -d ${D}${sysconfdir}/terminfo/${basedir}
                        mv ${termfile} ${D}${sysconfdir}/terminfo/${basedir}/
                        ln -s /etc/terminfo/${basedir}/${x} \
                                ${D}${datadir}/terminfo/${basedir}/${x}
                fi
        done
	# i think we can use xterm-color as default xterm
	if [ -e ${D}${sysconfdir}/terminfo/x/xterm-color ]
	then
		ln -sf xterm-color ${D}${sysconfdir}/terminfo/x/xterm
	fi

	mv ${D}${bindir}/clear ${D}${bindir}/clear.${PN}
	mv ${D}${bindir}/reset ${D}${bindir}/reset.${PN}
}
		
		
pkg_postinst_ncurses-tools () {
	update-alternatives --install ${bindir}/clear clear clear.${PN} 100
	update-alternatives --install ${bindir}/reset reset reset.${PN} 100
}
				
			
pkg_prerm_ncurses-tools () {
	update-alternatives --remove clear clear.${PN}
	update-alternatives --remove reset reset.${PN}
}


PACKAGES =+ "${PN}-ncurses ${PN}-panel ${PN}-menu ${PN}-form ${PN}-terminfo ${PN}-tools"
FILES_${PN}-ncurses = "${libdir}/libncurses.so.*"
# You can'r really run any ncurses app without terminfo files, which is why the packaging was that way before mickeyl broke it. 
# This RRECOMMENDS should pull in terminfo to fix that 
RRECOMMENDS_${PN}-ncurses = "${PN}-terminfo"
FILES_${PN}-panel = "${libdir}/libpanel.so.*"
FILES_${PN}-menu = "${libdir}/libmenu.so.*"
FILES_${PN}-form = "${libdir}/libform.so.*"
FILES_${PN}-terminfo = "\
  ${libdir}/terminfo \
  ${datadir}/terminfo \
"
FILES_${PN}-tools = "\
  ${bindir}/tic \
  ${bindir}/tack \
  ${bindir}/toe \
  ${bindir}/infotocap \
  ${bindir}/captoinfo \
  ${bindir}/infocmp \
  ${bindir}/clear.${PN} \
  ${bindir}/reset.${PN} \
"
FILES_${PN} = "\
  ${bindir}/tput \
  ${bindir}/tset \
  ${datadir}/tabset \
  ${sysconfdir}/terminfo \
"
