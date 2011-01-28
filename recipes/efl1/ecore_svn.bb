require ecore.inc
SRCREV = "${EFL_SRCREV}"
PR = "r12"

SRC_URI = "\
  ${E_SVN}/trunk;module=${SRCNAME};proto=http;scmdata=keep \
  file://exit_uclibc.patch \
  file://fix-ecore-fb-initialization.patch \
"
S = "${WORKDIR}/${SRCNAME}"

ECORE_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
  --enable-ecore-config \
  --enable-ecore-x \
  --enable-ecore-job \
  --enable-ecore-fb \
  --enable-ecore-evas \
  --enable-ecore-evas-software-16-x11 \
  --enable-ecore-evas-xrender \
  --enable-abstract-sockets \
  --enable-ecore-con \
  --enable-ecore-ipc \
  --enable-ecore-file \
  --enable-inotify \
  --disable-ecore-desktop \
  --disable-ecore-x-xcb \
  --disable-ecore-directfb \
  --disable-ecore-sdl \
  --enable-ecore-evas-opengl-x11 \
  --disable-ecore-evas-dfb \
  --disable-ecore-evas-sdl \
  --disable-openssl \
  --disable-poll \
  --enable-xim \
"

EXTRA_OECONF = "${ECORE_OECONF} \
                 --enable-curl \
"

EXTRA_OECONF_virtclass-native = "\
                 ${ECORE_OECONF} \
                 --disable-curl \
"
# List of options which were different in ecore-native,
# I know it's SCM, but with missing -native.bb is much easier to check here
#                --disable-ecore-x \
#                --enable-ecore-evas-fb \
#                --disable-ecore-evas-x11-gl \
#                --disable-ecore-imf \
#                --disable-ecore-imf_evas \
