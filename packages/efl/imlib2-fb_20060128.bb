include imlib2.inc

SRC_URI = "${E_CVS};module=e17/libs/imlib2;date=${PV}"
S = "${WORKDIR}/imlib2"

EXTRA_OECONF = "--without-x \
		--disable-mmx"

