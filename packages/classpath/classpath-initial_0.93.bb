# No later version of Classpath may be used because this is the latest that can be compiled
# by jikes!

require classpath-native.inc

DESCRIPTION="Java1.4-compatible GNU Classpath variant that is used as bootclasspath for jikes-native."

PR = "r2"

DEPENDS = "zip-native fastjar-native jikes-native"

EXTRA_OECONF = "\
  --with-jikes=jikes \
  --with-fastjar=fastjar \
  --with-glibj \
  --disable-local-sockets \
  --disable-alsa \
  --disable-gconf-peer \
  --disable-gtk-peer \
  --disable-plugin \
  --disable-dssi \
  --disable-examples \
  --disable-tools \
  --with-glibj-dir=${STAGING_DATADIR}/classpath-initial \
  --with-native-libdir=${STAGING_LIBDIR}/classpath-initial \
  --includedir=${STAGING_INCDIR}/classpath-initial \
  "
