DESCRIPTION = "LCDproc is a client/Server suite to drive all kinds of LCD (-like) devices. The client \
shipped with this package can be used to acquire various kinds of system stats."
HOMEPAGE = "http://lcdproc.org"
LICENSE ="GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "utils"

DEPENDS = "${@((bb.data.getVar('LCDPROC_DRIVERS',d) or 'curses,text').find('curses') != -1) and 'ncurses' or ''}"

SRC_URI = "${SOURCEFORGE_MIRROR}/lcdproc/lcdproc-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "${@'--enable-drivers=' + (bb.data.getVar('LCDPROC_DRIVERS',d) or 'curses,text')}"

do_install () {
	# binaries
	install -D -m 0755 server/LCDd ${D}${sbindir}/LCDd
	install -D -m 0755 clients/lcdproc/lcdproc ${D}${bindir}/lcdproc

	# init scripts
	install -D -m 0755 scripts/init-LCDd.debian ${D}${sysconfdir}/init.d/lcdd
	# prevent lcdproc from starting if no SCREENS are set.
	# will be fixed in next upstream release
	cat scripts/init-lcdproc.debian | sed -e 's/C X//' | sed -e 's/case/[ -n $SCREENS ] || exit 0\n\ncase/' > ${D}${sysconfdir}/init.d/lcdproc
	chmod 0755 ${D}${sysconfdir}/init.d/lcdproc

	# configuration files
	install -D -m 0644 LCDd.conf ${D}${sysconfdir}/LCDd.conf
	# don't start lcdproc by default
	# will be fixed in next upstream release
	cat scripts/lcdproc.conf | sed -e 's/C X//' > ${D}${sysconfdir}/lcdproc.conf
	chmod 0644 ${D}${sysconfdir}/lcdproc.conf
}

pkg_postinst () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D lcdd defaults 70 21
	update-rc.d $D lcdproc defaults 71 20
}

pkg_prerm () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D lcdproc remove
	update-rc.d $D lcdd remove
}
