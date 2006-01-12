DEPENDS = "jpeg libungif libid3tag libmad libpng libsigc++-1.2 gettext-native tuxbox-libs tuxbox-plugins dreambox-dvbincludes mtd-utils freetype"
DESCRIPTION = "Enigma is a framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"

DEFAULT_PREFERENCE=-1
PV = "cvs-${CVSDATE}"
PN = "enigma"
PR = "r0"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/enigma;method=ext \
           file://enigma.sh \
           file://config \
           file://userbouquet* \
           http://sources.dreamboxupdate.com/download/opendreambox/enigma/boot-${MACHINE} \
           file://enigma_enter_standby.sh \
           file://enigma_leave_standby.sh"

S = "${WORKDIR}/enigma"

FILES_${PN} += " ${datadir}/tuxbox ${datadir}/fonts"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-target=native --with-boxtype=${MACHINE} "

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
	install -m 0644 ${WORKDIR}/userbouquet* ${D}/usr/share/enigma/default/
	install -m 0755 ${WORKDIR}/enigma.sh ${D}/usr/bin/
	install -m 0755 ${WORKDIR}/boot-${MACHINE} ${D}/usr/bin/boot
	install -d ${D}/etc
	install -m 0755 ${WORKDIR}/enigma_enter_standby.sh ${D}/etc
	install -m 0755 ${WORKDIR}/enigma_leave_standby.sh ${D}/etc
}
