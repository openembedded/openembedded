DESCRIPTION = "Expedite is a comprehensive benchmarking suite for Evas"
DEPENDS = "eet evas"
RDEPENDS = "libevas-engine-buffer libevas-engine-fb libevas-engine-software-generic libevas-engine-software-x11 libevas-loader-png"
LICENSE = "MIT BSD"
PV = "0.6.0+svnr${SRCREV}"
PR = "r0"

inherit e

EXTRA_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
\
  --disable-opengl-glew \
  --disable-opengl-x11 \
  --enable-software-x11 \
  --enable-xrender-x11 \
  --enable-software-16-x11 \
  --enable-fb \
  --disable-software-ddraw \
  --disable-software-16-ddraw \
  --disable-direct3d \
  --disable-software-sdl \
"

FILES_${PN} += "${datadir}"
