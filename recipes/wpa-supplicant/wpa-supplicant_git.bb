require wpa-supplicant-0.7.inc

SRCREV = "b8fb017272ed4794339978c9fbc0e74571a44728"
PR = "r0"
PV = "0.7.3+0.8.0-rc"
PR_append = "+gitr${SRCPV}"
FILESPATHPKG =. "wpa-supplicant-git:"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://w1.fi/srv/git/hostap.git;protocol=git \
           file://defconfig \
           file://defaults-sane \
           file://wpa-supplicant.sh \
           file://wpa_supplicant.conf \
           file://wpa_supplicant.conf-sane \
           file://99_wpa_supplicant"

S = "${WORKDIR}/git/wpa_supplicant"

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig .config
	echo "CFLAGS += -I${STAGING_INCDIR}" >> .config
	echo "LIBS += -L${STAGING_LIBDIR}" >> .config
	echo "LIBS_p += -L${STAGING_LIBDIR}" >> .config
	if [ "${@base_contains('COMBINED_FEATURES', 'madwifi', 1, 0, d)}" = "1" ]; then
		echo "CONFIG_DRIVER_MADWIFI=y" >> .config
		echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
	fi
}


