require ecore.inc
PR = "r2"

SRC_URI += "file://remove-bad-code.patch;patch=1"

EXTRA_OECONF = "--enable-ecore-fb \
		--enable-ecore-job \
		--enable-ecore-file \
		--enable-poll \
		--enable-ecore-dbus \
		--enable-ecore-evas \
        --enable-ecore-evas-buffer \
		--enable-ecore-evas-fb \
		--disable-ecore-evas-x \
		--disable-ecore-evas-xrender \
		--disable-ecore-evas-gl \
		--enable-ecore-con \
		--enable-ecore-config \
		--enable-ecore-ipc \
		--enable-ecore-txt \
		--disable-ecore-x \
		--disable-curl \
		--without-curl-config \
		--enable-ecore-config \
        --enable-ecore-desktop \
		--disable-openssl"

parts = "Ecore Ecore_Job Ecore_File Ecore_DBus \
	 Ecore_Txt Ecore_Fb Ecore_Con \
	 Ecore_Ipc Ecore_Evas Ecore_Config \
     Ecore_Desktop"
