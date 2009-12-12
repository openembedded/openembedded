require libsdl.inc

DEPENDS = "alsa-lib directfb"
DEFAULT_PREFERENCE = "-1"

PR = "${INC_PR}.0"

SRC_URI += "\
  file://explicit-extern-C.patch;patch=1 \
  file://acinclude.m4 \
  file://directfb_obsolete_calls.patch;patch=1 \
"

CFLAGS_append  += " -I${STAGING_INCDIR}/directfb -I${STAGING_INCDIR}/directfb-internal"

EXTRA_OECONF = "--disable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --disable-video-x11 --disable-video-dga \
                --enable-video-fbcon --enable-video-directfb --disable-video-ps2gs \
                --disable-video-xbios --disable-video-gem --disable-video-dummy \
                --disable-video-opengl --enable-input-events --enable-pthreads \
                --disable-video-picogui --disable-video-qtopia --enable-dlopen"
