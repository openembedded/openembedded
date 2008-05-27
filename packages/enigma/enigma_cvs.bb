DEPENDS = "jpeg libungif libid3tag libmad libpng libsigc++-1.2 gettext-native tuxbox-libs tuxbox-plugins dreambox-dvbincludes mtd-utils freetype"
DESCRIPTION = "Enigma is a framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"

SRCDATE = "20070615"
PV = "cvs-${SRCDATE}"
PN = "enigma"
PR = "r4"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/enigma;method=ext \
           file://enigma.sh \
           file://config \
           file://userbouquet* \
           http://sources.dreamboxupdate.com/download/opendreambox/enigma/boot-${MACHINE} \
           file://enigma_enter_standby.sh \
           file://enigma_leave_standby.sh \
           file://rotor_fix.diff;patch=1;pnum=1 \
           file://disable_boot.diff;patch=1;pnum=1 \
	   file://epgfix_backport.diff;patch=1;pnum=1 \
	   file://timeshiftfix_backport.diff;patch=1;pnum=1 \
	   file://subtitlefix_backport.diff;patch=1;pnum=1 \
	   file://rdstextfix_backport.diff;patch=1;pnum=1 \
	   file://duplicate_tsid_onid_cable_terrestrial_fix_backport.diff;patch=1;pnum=1"

# dm600pvr and dm500plus don't have a FP, so they can't really switch of. Show a shutdown pic instead.
SRC_URI_append_dm600pvr = " http://sources.dreamboxupdate.com/download/opendreambox/enigma/showshutdownpic-${MACHINE} \
	   file://add_blindscan_to_menu.diff;patch=1;pnum=1 \
	   http://sources.dreamboxupdate.com/download/patches/enigma_add_cable_blindscan.diff;patch=1;pnum=1"
SRC_URI_append_dm500plus = " http://sources.dreamboxupdate.com/download/opendreambox/enigma/showshutdownpic-${MACHINE} \
	   file://add_blindscan_to_menu.diff;patch=1;pnum=1"

S = "${WORKDIR}/enigma"

FILES_${PN} += " ${datadir}/tuxbox ${datadir}/fonts"

PACKAGES_DYNAMIC = "enigma-locale-*"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-target=native --with-boxtype=${MACHINE} --with-webif=standard --with-epg=private --with-enigma-debug=yes --with-reiserfs=no"

do_configure_prepend() {
	mkdir -p m4
}

do_compile_prepend() {
	chmod ugo+x ${S}/po/xml2po
}

do_stage_append() {
	install -d ${STAGING_INCDIR}/enigma
	install -m 0644 ${WORKDIR}/enigma/include/*.h ${STAGING_INCDIR}/enigma
	for dir in base dvb dvb/lowlevel codecs driver gdi gui socket system picviewer movieplayer; do
		install -d ${STAGING_INCDIR}/enigma/lib/$dir;
		install -m 0644 ${WORKDIR}/enigma/include/lib/$dir/*.h ${STAGING_INCDIR}/enigma/lib/$dir;
	done;
	rm -R ${STAGING_INCDIR}/enigma/src 2> /dev/null || /bin/true
	install -m 0644 ${WORKDIR}/enigma/src/*.h ${STAGING_INCDIR}/enigma
	ln -sf ${STAGING_INCDIR}/enigma ${STAGING_INCDIR}/enigma/src
}

do_install_append() {
	install -d ${D}/usr/share/enigma/default
	install -d ${D}/usr/share/enigma/default/cable
	install -d ${D}/usr/share/enigma/default/terrestrial
	mv ${D}/etc/enigma/* ${D}/usr/share/enigma/default 2> /dev/null || /bin/true
	rm -R ${D}/etc/enigma 2> /dev/null || /bin/true
	install -m 0644 ${WORKDIR}/config ${D}/usr/share/enigma/default/
	if [ "${MACHINE}" = "dm600pvr" -o "${MACHINE}" = "dm500plus" ]; then
		install -m 0755 ${WORKDIR}/showshutdownpic-${MACHINE} ${D}/usr/bin/showshutdownpic
		# vulcan-based boxes don't look that well with too much alpha
		echo "i:/ezap/osd/alpha=00000000" >> ${D}/usr/share/enigma/default/config
		echo "i:/ezap/osd/simpleMainMenu=00000001" >> ${D}/usr/share/enigma/default/config
	fi
	install -m 0644 ${WORKDIR}/userbouquet* ${D}/usr/share/enigma/default/
	install -m 0755 ${WORKDIR}/enigma.sh ${D}/usr/bin/
	install -m 0755 ${WORKDIR}/boot-${MACHINE} ${D}/usr/bin/boot
	install -d ${D}/etc
	install -m 0755 ${WORKDIR}/enigma_enter_standby.sh ${D}/etc
	install -m 0755 ${WORKDIR}/enigma_leave_standby.sh ${D}/etc
}
