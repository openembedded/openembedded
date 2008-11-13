DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
MAINTAINER = "eFfeM <fransmeulenbroeks at yahoo dot com>"
DEPENDS = "libupnp virtual/libiconv virtual/libintl"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-${PV}.tar.bz2 \
	file://realloc.patch;patch=1 \
	file://ushare.sh \
	file://ushare.conf \
	file://ts.patch;patch=1 \
	"

S = "${WORKDIR}/ushare-${PV}"
PR = "r2"

INITSCRIPT_NAME = "ushare"
INITSCRIPT_PARAMS = "defaults 40 20"

inherit autotools update-rc.d

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0577 ${WORKDIR}/ushare.sh ${D}/etc/init.d/ushare
	install -m 0666 ${WORKDIR}/ushare.conf ${D}/etc/ushare.conf
}