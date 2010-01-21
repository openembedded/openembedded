# Do not use the include in 1.2.14 as it has a lot of unneeded munging that applies to old versions.
#require libsdl.inc

DESCRIPTION = "Simple DirectMedia Layer (X11 and Framebuffer support)"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "alsa-lib virtual/libgl virtual/libx11 libxext tslib"
DEPENDS_avr32 = "alsa-lib virtual/libx11 libxext tslib"
PROVIDES = "virtual/libsdl"
PR = "r3"

SRC_URI = " \
  http://www.libsdl.org/release/SDL-${PV}.tar.gz \
  file://sdl.m4 \
"

S = "${WORKDIR}/SDL-${PV}"

inherit autotools binconfig pkgconfig

EXTRA_OECONF = " \
  --disable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
  --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
  --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
  --disable-mintaudio --disable-nasm --enable-video-x11 --disable-video-dga \
  --enable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
  --disable-video-xbios --disable-video-gem --disable-video-dummy \
  --enable-video-opengl --enable-input-events --enable-pthreads \
  --disable-video-picogui --disable-video-qtopia --enable-dlopen \
  --enable-input-tslib --disable-video-ps3 \
"

do_configure() { 
  oe_runconf
}

do_configure_append () {
  cd ${S}

  # prevent libtool from linking libs against libstdc++, libgcc, ...
  cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
  mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool

  # copy new sdl.m4 macrofile to the dir for installing
  cp ${WORKDIR}/sdl.m4 ${S}/
}

do_stage() {
  autotools_stage_all		
  rm ${STAGING_LIBDIR}/libSDL.la
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/*config"
