SECTION = "x11/utils"
DEPENDS += "gnupg"
RRECOMMENDS += "gnupg"
PR = "r0"

EMVER="0.92.0"
IPCVER="1.1.3"
SRC_URI = "http://ftp.mozilla.org/pub/mozilla.org/thunderbird/releases/${PV}/source/thunderbird-${PV}-source.tar.bz2 \
	http://downloads.mozdev.org/enigmail/src/enigmail-${EMVER}.tar.gz \
http://downloads.mozdev.org/enigmail/src/ipc-${IPCVER}.tar.gz \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://extensions-hack.patch;patch=1 \
	file://firefox-1.0-gcc4-compile.patch;patch=1;pnum=0 \
	file://mozilla-thunderbird.png file://mozilla-thunderbird.desktop"
S = "${WORKDIR}/mozilla"

FILES_${PN} += "${libdir}/thunderbird-${PV} ${datadir}/idl"

inherit mozilla

export MOZ_THUNDERBIRD=1

do_configure() {
	for x in ipc enigmail; do
		if [ ! -e ${WORKDIR}/mozilla/extensions/$x ]; then
			mv ${WORKDIR}/$x ${WORKDIR}/mozilla/extensions/
			cd ${WORKDIR}/mozilla/extensions/$x
			makemake
		fi
	done
	cd ${S}
	mozilla_do_configure
}

do_compile() {
	mozilla_do_compile
	oe_runmake -C ${WORKDIR}/mozilla/extensions/ipc
	oe_runmake -C ${WORKDIR}/mozilla/extensions/enigmail
}

do_install() {
	mozilla_do_install
	oe_runmake -C ${WORKDIR}/mozilla/extensions/ipc DESTDIR="${D}" install
	oe_runmake -C ${WORKDIR}/mozilla/extensions/enigmail DESTDIR="${D}" install
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/mozilla-thunderbird.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/mozilla-thunderbird.png ${D}${datadir}/pixmaps/
}

pkg_postinst_thunderbird() {
	chmod -R a+w ${libdir}/thunderbird*
}

# Simulate the silly csh makemake script
makemake() {
    typeset m topdir
    for m in $(find . -name Makefile.in); do
        topdir=$(echo "$m" | sed -r 's:[^/]+:..:g')
        sed -e "s:@srcdir@:.:g" -e "s:@top_srcdir@:${topdir}:g" \
            < ${m} > ${m%.in} || die "sed ${m} failed"
    done
}
