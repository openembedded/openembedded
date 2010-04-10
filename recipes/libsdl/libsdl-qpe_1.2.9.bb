require libsdl.inc

PR = "${INC_PR}.0"

SECTION = "opie/libs"
DEPENDS = "virtual/libqpe1 libopie2"

SRC_URI += "\
  file://agawa-piro-mickey-1.2.9.patch;patch=1 \
  file://pygame-1.2.9.patch;patch=1 \
  file://mouse-1.2.9.patch;patch=1 \
  file://kill-stdc++-1.2.9.patch;patch=1 \
  file://ipaq-1.2.9.patch;patch=1 \
  file://SDL-Akita-1.2.9.patch;patch=1 \
  file://fixlibs-1.2.9.patch;patch=1 \
  file://explicit-extern-C.patch;patch=1 \
  file://no-PAGE_SIZE.patch;patch=1 \
  file://fix_Makefile.am.patch;patch=1 \
  file://fix_configure.in.patch;patch=1 \
"

EXTRA_OECONF = "--disable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --enable-oss --disable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --disable-video-x11 --disable-video-dga \
                --enable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
                --disable-video-xbios --disable-video-gem --disable-video-dummy \
                --disable-video-opengl --enable-input-events --enable-pthreads \
                --disable-video-picogui --enable-video-qtopia --enable-dlopen"

do_compile_prepend() {
	if [ "${PALMTOP_USE_MULTITHREADED_QT}" == "yes" ]
	then
		sed -i s,-lqte\([^-]\),-lqte-mt, src/Makefile
	fi
}

SRC_URI[md5sum] = "80919ef556425ff82a8555ff40a579a0"
SRC_URI[sha256sum] = "d5a168968051536641ab5a3ba5fc234383511c77a8bc5ceb8bed619bdd42e5f9"
