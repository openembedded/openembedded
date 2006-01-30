include ecore.inc
PR = "r1"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/ecore;date=${PV} \
           file://remove-tslib-configure.patch;patch=1"
S = "${WORKDIR}/ecore"

EXTRA_OECONF = "--enable-ecore-fb \
		--enable-ecore-job \
		--enable-ecore-file \
		--enable-poll \
		--enable-ecore-dbus \
		--enable-ecore-evas \
		--enable-ecore-evas-fb \
		--enable-ecore-evas-buffer \
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

inherit native
# disable curl for now (see EXTRA_OECONF in ecore-fb), we may reenable it when we need it
# DEPENDS = "curl-native eet-native evas-native"
DEPENDS = "eet-native evas-native"
PROVIDES = "ecore-native"