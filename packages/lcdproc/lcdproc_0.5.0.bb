DESCRIPTION = "LCDproc is a client/Server suite to drive all kinds of LCD (-like) devices. The client \
shipped with this package can be used to acquire various kinds of system stats."
HOMEPAGE = "http://lcdproc.org"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "utils"
PR="r2"

DEPENDS = "libusb ncurses"
RRECOMMENDS_lcdproc = "lcdd"

SRC_URI = "${SOURCEFORGE_MIRROR}/lcdproc/${P}.tar.gz"

inherit autotools update-rc.d

PACKAGES =+ "lcdd lcdd-driver-cfontz lcdd-driver-bayrad lcdd-driver-hd44780nousb \
		lcdd-driver-hd44780 lcdd-driver-mtxorb lcdd-driver-serialvfd \
		lcdd-driver-curses lcdd-driver-text \
		lcdd-driver-sed lcdd-driver-cwlnx lcdd-driver-glk lcdd-driver-icp-a106 \
		lcdd-driver-imon lcdd-driver-joy lcdd-driver-lb216 lcdd-driver-lcdm001 \
		lcdd-driver-lcterm lcdd-driver-ms6931 lcdd-driver-mtc-s16209x \
		lcdd-driver-noritakevfd lcdd-driver-pyramid lcdd-driver-sli \
		lcdd-driver-stv5730 lcdd-driver-t6963 lcdd-driver-tyan"

CONFFILES_lcdd = "${sysconfdir}/LCDd.conf"
CONFFILES_lcdproc = "${sysconfdir}/lcdproc.conf"

FILES_lcdd = "${CONFFILES_lcdd} \
	${sbindir}/LCDd \
	${sysconfdir}/init.d/lcdd"

FILES_lcdproc = "${CONFFILES_lcdproc} \
	${bindir}/lcdproc \
	${sysconfdir}/init.d/lcdproc"

# Driver packages

FILES_lcdd-driver-cfontz 	= "${libdir}/lcdproc/CFontz*.so"
FILES_lcdd-driver-bayrad 	= "${libdir}/lcdproc/bayrad.so"
FILES_lcdd-driver-hd44780nousb 	= "${libdir}/lcdproc/hd44780nousb.so"
FILES_lcdd-driver-hd44780 	= "${libdir}/lcdproc/hd44780.so"
FILES_lcdd-driver-mtxorb 	= "${libdir}/lcdproc/MtxOrb.so"
FILES_lcdd-driver-serialvfd 	= "${libdir}/lcdproc/serialVFD.so"
FILES_lcdd-driver-curses 	= "${libdir}/lcdproc/curses.so"
FILES_lcdd-driver-text 		= "${libdir}/lcdproc/text.so"
FILES_lcdd-driver-sed 		= "${libdir}/lcdproc/sed*.so"
FILES_lcdd-driver-cwlnx 	= "${libdir}/lcdproc/CwLnx.so"
FILES_lcdd-driver-glk 		= "${libdir}/lcdproc/glk.so"
FILES_lcdd-driver-icp-a106	= "${libdir}/lcdproc/icp_a106.so"
FILES_lcdd-driver-imon		= "${libdir}/lcdproc/imon.so"
FILES_lcdd-driver-joy		= "${libdir}/lcdproc/joy.so"
FILES_lcdd-driver-lb216		= "${libdir}/lcdproc/lb216.so"
FILES_lcdd-driver-lcdm001	= "${libdir}/lcdproc/lcdm001.so"
FILES_lcdd-driver-lcterm	= "${libdir}/lcdproc/lcterm.so"
FILES_lcdd-driver-ms6931	= "${libdir}/lcdproc/ms6931.so"
FILES_lcdd-driver-mtc-s16209x	= "${libdir}/lcdproc/mtc_s16209x.so"
FILES_lcdd-driver-noritakevfd	= "${libdir}/lcdproc/NoritakeVFD.so"
FILES_lcdd-driver-pyramid	= "${libdir}/lcdproc/pyramid.so"
FILES_lcdd-driver-sli		= "${libdir}/lcdproc/sli.so"
FILES_lcdd-driver-stv5730	= "${libdir}/lcdproc/stv5730.so"
FILES_lcdd-driver-t6963		= "${libdir}/lcdproc/t6963.so"
FILES_lcdd-driver-tyan		= "${libdir}/lcdproc/tyan.so"


# Install-all-drivers-hack:

DEPENDS_lcdd-driver-all = "lcdd-driver-cfontz lcdd-driver-bayrad lcdd-driver-hd44780nousb \
				lcdd-driver-hd44780 lcdd-driver-mtxorb lcdd-driver-serialvfd \
				lcdd-driver-curses lcdd-driver-text \
				lcdd-driver-sed lcdd-driver-cwlnx lcdd-driver-glk lcdd-driver-icp-a106 \
				lcdd-driver-imon lcdd-driver-joy lcdd-driver-lb216 lcdd-driver-lcdm001 \
				lcdd-driver-lcterm lcdd-driver-ms6931 lcdd-driver-mtc-s16209x \
				lcdd-driver-noritakevfd lcdd-driver-pyramid lcdd-driver-sli \
				lcdd-driver-stv5730 lcdd-driver-t6963 lcdd-driver-tyan"

# USB / no USB trickery

CONFLICTS_lcdd-driver-hd47780nousb = "lcdd-driver-hd44780"
CONFLICTS_lcdd-driver-hd47780 = "lcdd-driver-hd44780nousb"

INITSCRIPT_PACKAGES = "lcdd lcdproc"
INITSCRIPT_NAME_lcdd = "lcdd"
INITSCRIPT_NAME_lcdproc = "lcdproc"
INITSCRIPT_PARAMS_lcdd = "defaults 70 21"
INITSCRIPT_PARAMS_lcdproc = "defaults 71 20"

EXTRA_OECONF = "--enable-drivers=all --enable-libusb"

do_install () {
	# binaries
	install -D -m 0755 server/LCDd ${D}${sbindir}/LCDd
	install -D -m 0755 clients/lcdproc/lcdproc ${D}${bindir}/lcdproc

	# init scripts
	install -d ${D}${sysconfdir}/init.d
	# so far, not fixed :-( and now even uglier :-((
	cat scripts/init-LCDd.debian | sed -e s'/--oknodo//' -e 's/ -s -f / -s 1 -f 1 /' -e 's/force-reload/force-restart/' -e 's/sleep 1/sleep 4/' > ${D}${sysconfdir}/init.d/lcdd
	chmod 0755 ${D}${sysconfdir}/init.d/lcdd
	# prevent lcdproc from starting if no SCREENS are set.
	# will be fixed in next upstream release
	cat scripts/init-lcdproc.debian | sed -e 's/C X//' | sed -e 's/case/[ -n "$SCREENS" ] || exit 0\n\ncase/' | sed -e s'/--oknodo//' > ${D}${sysconfdir}/init.d/lcdproc
	chmod 0755 ${D}${sysconfdir}/init.d/lcdproc

	# configuration files
	install -D -m 0644 LCDd.conf ${D}${sysconfdir}/LCDd.conf
	# don't start lcdproc by default
	# will be fixed in next upstream release
	cat scripts/lcdproc.conf | sed -e 's/C X//' > ${D}${sysconfdir}/lcdproc.conf
	chmod 0644 ${D}${sysconfdir}/lcdproc.conf

	# driver library files
	install -d ${D}${libdir}/lcdproc
	for i in server/drivers/*.so; do
		install -m 0644 $i ${D}${libdir}/lcdproc/
	done
}

