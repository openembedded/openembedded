include imlib2.inc

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/imlib2;date=${PV}"
S = "${WORKDIR}/imlib2"

EXTRA_OECONF = "--without-x \
		--disable-mmx"

