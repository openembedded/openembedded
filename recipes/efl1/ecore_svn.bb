require ecore.inc
#SRCREV = "${EFL_SRCREV}"
#Temporary for fix of bug introduced in 53810
#typedef enum _Ecore_File_Event Ecore_File_Event;
#was defined before enum itself and ie webkit-efl fails to rebuild with it
SRCREV = "53869"
PR = "r12"

SRC_URI += "\
  file://iconv.patch;maxrev=43996 \
  file://exit_uclibc_dns.patch;maxrev=47076 \
  file://exit_uclibc.patch;maxrev=50815 \
  file://exit_uclibc_newer.patch;minrev=50816 \
"

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
