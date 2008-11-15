require ecore.inc
PR = "r6"

EXTRA_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
\
  --enable-ecore-txt \
  --enable-ecore-config \
  --disable-ecore-x-xcb \
  --enable-ecore-x \
  --enable-ecore-job \
  --disable-ecore-directfb \
  --disable-ecore-sdl \
  --enable-ecore-fb \
  --enable-ecore-evas \
  --enable-ecore-evas-software-16-x11 \
  --disable-ecore-evas-x11-gl \
  --enable-ecore-evas-xrender \
  --disable-ecore-evas-dfb \
  --disable-ecore-evas-sdl \
  --disable-openssl \
  --enable-abstract-sockets \
  --enable-ecore-con \
  --enable-ecore-ipc \
  --enable-ecore-file \
  --enable-inotify \
  --disable-poll \
  --enable-curl \
  --disable-ecore-desktop \
"
