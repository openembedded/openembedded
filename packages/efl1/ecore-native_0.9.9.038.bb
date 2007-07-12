require ecore.inc
inherit native
DEPENDS = "eet-native evas-native"
PR = "r1"

EXTRA_OECONF = "\
                --enable-ecore-txt \
                --disable-ecore-x-xcb \
                --disable-ecore-x \
                --enable-ecore-job \
                --enable-ecore-directfb \
                --enable-ecore-fb \
                --enable-ecore-evas \
                --disable-ecore-evas-gl \
                --disable-ecore-evas-xrender \
                --disable-ecore-evas-dfb \
                --disable-openssl \
                --enable-abstract-sockets \
                --enable-ecore-con \
                --enable-ecore-ipc \
                --enable-ecore-dbus \
                --enable-ecore-file \
                --enable-inotify \
                --disable-poll \
                --disable-curl \
                --disable-ecore-desktop \
                --x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} "

