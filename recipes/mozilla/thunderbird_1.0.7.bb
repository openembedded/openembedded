SECTION = "x11/utils"
DEPENDS += "gnupg"
RRECOMMENDS += "gnupg"
PR = "r1"

EMVER="0.92.0"
IPCVER="1.1.3"
SRC_URI = "http://ftp.mozilla.org/pub/mozilla.org/thunderbird/releases/${PV}/source/thunderbird-${PV}-source.tar.bz2;name=archive \
	http://downloads.mozdev.org/enigmail/src/enigmail-${EMVER}.tar.gz;name=enigmail \
http://downloads.mozdev.org/enigmail/src/ipc-${IPCVER}.tar.gz;name=ipc \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://extensions-hack.patch;patch=1 \
	file://firefox-1.0-gcc4-compile.patch;patch=1;pnum=0 \
	file://mozilla-thunderbird.png file://mozilla-thunderbird.desktop"
S = "${WORKDIR}/mozilla"

FILES_${PN} += "${libdir}/thunderbird-${PV}/* ${datadir}/idl"
FILES_${PN}-dbg += "${libdir}/thunderbird-${PV}/.debug*"

inherit mozilla

export MOZ_THUNDERBIRD="1"

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

SRC_URI[archive.md5sum] = "e6388feb0ffcd189af779f165c124b4d"
SRC_URI[archive.sha256sum] = "6b964fb220a46438adf6ec37082da66332a3ce74ca4913b863b17d9ab720681f"
SRC_URI[enigmail.md5sum] = "50c369ce6d6fcb2d275cd30319a601ff"
SRC_URI[enigmail.sha256sum] = "de820405e4f3ca5531108ca99fc2bb1f260670f2fc4b45c7fb70ef9aa164bf6c"
SRC_URI[ipc.md5sum] = "64ba4c6e3b52568468c4f6680ec7e679"
SRC_URI[ipc.sha256sum] = "0265ae1a639e0975a8820928598a357f769350801ea3633016e974d32f7db725"
