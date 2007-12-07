require ecore.inc
PR = "r5"

EXTRA_OECONF = "\
		--enable-ecore-txt \
		--disable-ecore-x-xcb \
		--enable-ecore-x \
		--enable-ecore-job \
		--disable-ecore-directfb \
		--disable-ecore-sdl \
		--enable-ecore-fb \
		--enable-ecore-evas \
		--disable-ecore-evas-gl \
		--enable-ecore-evas-xrender \
		--enable-ecore-evas-dfb \
		--disable-openssl \
		--enable-abstract-sockets \
		--enable-ecore-con \
		--enable-ecore-ipc \
		--enable-ecore-file \
		--enable-inotify \
		--disable-poll \
		--enable-curl \
		--enable-ecore-desktop \
		--x-includes=${STAGING_INCDIR}/X11 \
		--x-libraries=${STAGING_LIBDIR}	"
