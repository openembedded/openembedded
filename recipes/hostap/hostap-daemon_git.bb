DESCRIPTION = "User space daemon for extended IEEE 802.11 management"

require hostap-daemon-0.7.inc

PR = "r0"
SRCREV = "b8fb017272ed4794339978c9fbc0e74571a44728"
PV = "0.7.3+0.8.0-rc"
PR_append = "gitr${SRCPV}"
FILESPATHPKG =. "hostap-daemon-git:"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git/hostapd"

SRC_URI = "git://w1.fi/srv/git/hostap.git;protocol=git \
	file://defconfig \
	file://init"

S = "${WORKDIR}/git/hostapd"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CFLAGS += -I${STAGING_INCDIR}" >> .config
	echo "LIBS += -L${STAGING_LIBDIR}" >> .config
}

