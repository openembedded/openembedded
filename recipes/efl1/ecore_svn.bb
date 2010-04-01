require ecore.inc
SRCREV = "${EFL_SRCREV}"
PR = "r11"

SRC_URI += "\
  file://iconv.patch;patch=1;maxrev=43996 \
  file://exit_uclibc_dns.patch;patch=1;maxrev=47076 \
  file://exit_uclibc.patch;patch=1 \
"

ECORE_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
  --enable-ecore-txt \
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
  --enable-ecore-evas-x11-gl \
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
