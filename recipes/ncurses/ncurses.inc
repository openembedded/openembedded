DESCRIPTION = "Ncurses library"
HOMEPAGE = "http://www.gnu.org/software/ncurses/ncurses.html"
LICENSE = "MIT"
SECTION = "libs"
DEPENDS = "ncurses-native"

inherit autotools

PARALLEL_MAKE=""

FILESPATH = "${FILE_DIRNAME}/local:${FILE_DIRNAME}/ncurses-${PV}-${PR}:${FILE_DIRNAME}/ncurses-${PV}:${FILE_DIRNAME}/ncurses:${FILE_DIRNAME}"

EXTRA_OECONF = "\
  --enable-static \
  --with-shared \
  --with-libtool \
  --without-profile \
  --without-debug \
  --disable-rpath \
  --enable-echo \
  --enable-const \
  --without-ada \
  --enable-termcap \
  --without-cxx-binding \
  --with-terminfo-dirs=${sysconfdir}/terminfo:${datadir}/terminfo \
  --enable-overwrite \
"

export BUILD_CCFLAGS = "-I${S}/ncurses -I${S}/include ${BUILD_CFLAGS}"
export BUILD_LDFLAGS = ""
export EXTRA_OEMAKE = '"BUILD_LDFLAGS=" "BUILD_CCFLAGS=${BUILD_CCFLAGS}"'

# This is necessary so that the "tic" command executed during the install can
# link with the correct libary in staging.
export LD_LIBRARY_PATH = "${STAGING_LIBDIR_NATIVE}"

do_install() {
	autotools_do_install

	# our ncurses has termcap support
	ln -sf libncurses.so ${D}${libdir}/libtermcap.so
	ln -sf libncurses.a ${D}${libdir}/libtermcap.a
    ln -sf curses.h ${D}${includedir}/ncurses.h


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
	ln -sf rxvt ${D}${sysconfdir}/terminfo/r/rxvt-unicode

	if [ "${PN}" = "ncurses" ]; then
		mv ${D}${bindir}/clear ${D}${bindir}/clear.${PN}
		mv ${D}${bindir}/reset ${D}${bindir}/reset.${PN}
	fi
}
		
		
pkg_postinst_ncurses-tools () {
	if [ "${PN}" = "ncurses" ]; then
		update-alternatives --install ${bindir}/clear clear clear.${PN} 100
		update-alternatives --install ${bindir}/reset reset reset.${PN} 100
	fi
}
				
			
pkg_prerm_ncurses-tools () {
	if [ "${PN}" = "ncurses" ]; then
		update-alternatives --remove clear clear.${PN}
		update-alternatives --remove reset reset.${PN}
	fi
}

PACKAGES =+ "${PN}-tools ${PN}-terminfo"

# clear and reset are already in busybox
FILES_${PN} = "\
  ${bindir}/tput \
  ${bindir}/tset \
  ${libdir}/lib*.so.* \
  ${datadir}/tabset \
  ${sysconfdir}/terminfo \
"
FILES_${PN}-tools = "\
  ${bindir}/tic \
  ${bindir}/toe \
  ${bindir}/infotocap \
  ${bindir}/captoinfo \
  ${bindir}/infocmp \
  ${bindir}/clear.${PN} \
  ${bindir}/reset.${PN} \
  ${bindir}/tack \
"
FILES_${PN}-terminfo = "\
  ${datadir}/terminfo \
"
  
RSUGGESTS_${PN} = "ncurses-terminfo"
RPROVIDES_${PN} = "libncurses5"
RCONFLICTS_${PN} = "libncurses5"
RREPLACES_${PN} = "libncurses5"

