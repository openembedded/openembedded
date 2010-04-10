DESCRIPTION = "Palantir - a multichannel interactive streaming solution"
LICENSE = "GPLv2"
DEPENDS = "jpeg libgsm"

SRC_URI = "http://www.fastpath.it/products/palantir/pub/palantir-${PV}.tgz"

S = "${WORKDIR}/palantir-${PV}/server"

TARGET_CC_ARCH += "${CFLAGS} ${LDFLAGS}"

export BASE_DIR="${prefix}"

do_install() {
	sed -i -e s:chown:echo:g -e s:chmod:echo:g Makefile
	mkdir -p ${D}/var/log/palantir
	LOG_FILE="${D}/var/log/palantir" OWNER="${USER}" BASE_DIR="${D}${prefix}" oe_runmake install
	rm ${D}/${datadir}/palantir/telmu_pipe
}

FILES_${PN} += "${datadir}/palantir/"

pkg_postinst_${PN} () {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	grep "^palantir:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/run/palantir --no-create-home palantir --ingroup palantir -g palantir
	mkfifo ${datadir}/palantir/telmu_pipe
	chown palantir ${datadir}/palantir/*
	chmod 600 ${datadir}/palantir/telmu_pipe
}


pkg_postrm_${PN} () {
	deluser palantir || true
}


SRC_URI[md5sum] = "3a5b1fb340857f6d8e357bf39b77583e"
SRC_URI[sha256sum] = "dbe9c8317e66e7239a53e9bcb68595cd31ec949474bb3d9fc15f51f3773c167b"
