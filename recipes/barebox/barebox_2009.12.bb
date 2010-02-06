require barebox.inc

PR = "r0"

DEFAULT_PREFERENCE = "-1"

BAREBOX_REVISION ?= "0"

S = "${WORKDIR}/barebox-${PV}.${BAREBOX_REVISION}"

SRC_URI = "http://barebox.org/download/barebox-${PV}.${BAREBOX_REVISION}.tar.bz2;name=barebox-${PV}.${BAREBOX_REVISION} \
	   file://defconfig"

SRC_URI[barebox-2009.12.0.md5sum] = "d1aefe17cfd72affec766617b42dfb78"
SRC_URI[barebox-2009.12.0.sha256sum] = "0ccd59898289652f4bebd8282737a771729d84886195221c781df08f81a837ef"
