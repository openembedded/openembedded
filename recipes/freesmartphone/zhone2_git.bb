DESCRIPTION = "A demo phone application based on FSO 2.0"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "edje-native vala-native evas ecore edje libeflvala libfsobasics libfsoframework libfso-glib"
PV = "2.0.0+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/aurora.git;protocol=git;branch=master \
  http://www.linuxtogo.org/~mickeyl/misc/splash \
  file://zhone2 \
"
S = "${WORKDIR}/git/zhone2"

inherit autotools_stage update-rc.d

INITSCRIPT_NAME = "zhone2"
INITSCRIPT_PARAMS = "defaults 40"

do_install_append() {
	install -d ${D}${datadir}/zhone2/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/splash ${D}${datadir}/zhone2/
	install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}
