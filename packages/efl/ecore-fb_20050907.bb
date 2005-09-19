include ecore.inc
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/ecore;date=${PV}"
S = "${WORKDIR}/ecore"

### add tslib support
SRC_URI += "file://add-tslib-support.patch;patch=1"
DEPENDS += "tslib"
CFLAGS += "-DHAVE_TSLIB"
LDFLAGS += "-lts"

EXTRA_OECONF = "--enable-ecore-fb \
		--enable-ecore-job \
		--enable-ecore-file \
		--enable-poll \
		--enable-ecore-dbus \
		--enable-ecore-evas \
		--enable-ecore-evas-fb \
		--disable-ecore-evas-x \
		--disable-ecore-evas-gl \
		--enable-ecore-con \
		--enable-ecore-config \
		--enable-ecore-ipc \
		--enable-ecore-txt \
		--disable-ecore-x \
		--disable-curl \
		--without-curl-config \
		--enable-ecore-config \
		--disable-openssl"

parts = "Ecore Ecore_Job Ecore_File Ecore_DBus Ecore_Txt Ecore_Fb Ecore_Con Ecore_Ipc Ecore_Evas Ecore_Config"

