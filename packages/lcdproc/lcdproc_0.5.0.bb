DESCRIPTION = "LCDproc is a client/Server suite to drive all kinds of LCD (-like) devices. The client \
shipped with this package can be used to acquire various kinds of system stats."
HOMEPAGE = "http://lcdproc.org"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "utils"

DEPENDS = "${@((bb.data.getVar('LCDPROC_DRIVERS',d) or 'all').find('curses') != -1) and 'ncurses' or ''}"
RRECOMMENDS_lcdproc = "lcdd"

SRC_URI = "${SOURCEFORGE_MIRROR}/lcdproc/lcdproc-${PV}.tar.gz"

inherit autotools update-rc.d

PACKAGES =+ "lcdd"

CONFFILES_lcdd = "${sysconfdir}/LCDd.conf"
CONFFILES_lcdproc = "${sysconfdir}/lcdproc.conf"

FILES_lcdd = "${CONFFILES_lcdd} \
	${sbindir}/LCDd \
	${sysconfdir}/init.d/lcdd \
	${libdir}/lcdproc/"
FILES_lcdproc = "${CONFFILES_lcdproc} \
	${bindir}/lcdproc \
	${sysconfdir}/init.d/lcdproc"

INITSCRIPT_PACKAGES = "lcdd lcdproc"
INITSCRIPT_NAME_lcdd = "lcdd"
INITSCRIPT_NAME_lcdproc = "lcdproc"
INITSCRIPT_PARAMS_lcdd = "defaults 70 21"
INITSCRIPT_PARAMS_lcdproc = "defaults 71 20"

EXTRA_OECONF = "${@'--enable-drivers=' + (bb.data.getVar('LCDPROC_DRIVERS',d) or 'all')}"

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

