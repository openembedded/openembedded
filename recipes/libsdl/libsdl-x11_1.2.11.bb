require libsdl.inc

# extra-keys.patch is missing
DEFAULT_PREFERENCE = "-1" 

PR = "${INC_PR}.0"

SRC_URI = "\
  http://www.libsdl.org/release/SDL-${PV}.tar.gz \
  file://acinclude.m4 \
  file://configure_tweak.patch;patch=1 \
  file://pagesize.patch;patch=1 \
  file://kernel-asm-page.patch;patch=1 \
  file://sdl-cdfix.patch;patch=1 \
  file://fixmfour.patch;patch=1 \
  file://libsdl-1.2.11-pagesize.patch;patch=1 \
"

EXTRA_OECONF = "--disable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --enable-video-x11 --disable-video-dga \
                --enable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
                --disable-video-xbios --disable-video-gem --disable-video-dummy \
                --enable-video-opengl --enable-input-events --enable-pthreads \
                --disable-video-picogui --disable-video-qtopia --enable-dlopen"

