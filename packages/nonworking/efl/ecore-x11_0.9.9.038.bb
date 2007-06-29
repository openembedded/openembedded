require ecore.inc
DEPENDS += "evas-x11"
PR = "r3"

SRC_URI += "file://configure-abstract-sockets.patch;patch=1"

EXTRA_OECONF = "--disable-ecore-fb \
        --disable-ecore-dfb \
		--enable-ecore-job \
		--enable-ecore-file \
		--enable-ecore-dbus \
		--disable-ecore-evas-fb \
		--disable-ecore-evas-dfb \
		--enable-ecore-evas-x \
        --enable-ecore-evas-buffer \
		--disable-ecore-evas-gl \
		--enable-ecore-con \
		--enable-ecore-ipc \
		--enable-ecore-txt \
		--enable-ecore-x \
		--enable-ecore-config \
		--disable-openssl \
        --enable-ecore-desktop \
		--x-includes=${STAGING_INCDIR}/X11 \
		--x-libraries=${STAGING_LIBDIR}	"

parts = "Ecore Ecore_Job Ecore_File Ecore_DBus \
	 Ecore_Txt Ecore_Fb Ecore_Con \
	 Ecore_Ipc Ecore_Evas Ecore_Config \
	 Ecore_X Ecore_Desktop"
