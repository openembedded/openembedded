# No later version of Classpath may be used because this is the latest that can be compiled
# by jikes!

require classpath-native.inc

DESCRIPTION="Java1.4-compatible GNU Classpath variant that is used as bootclasspath for jikes-native."

PR = "r6"

DEPENDS = "zip-native fastjar-native jikes-native gettext-native"

SRC_URI += "\
	file://autotools.patch;patch=1 \
	file://miscompilation-0.93.patch;patch=1 \
	"

EXTRA_OECONF = "\
  --with-jikes=jikes \
  --with-fastjar=fastjar \
  --with-glibj \
  --disable-Werror \
  --disable-local-sockets \
  --disable-alsa \
  --disable-gconf-peer \
  --disable-gtk-peer \
  --disable-plugin \
  --disable-dssi \
  --disable-examples \
  --disable-tools \
  --with-glibj-dir=${STAGING_DATADIR_NATIVE}/classpath-initial \
  --with-native-libdir=${STAGING_LIBDIR_NATIVE}/classpath-initial \
  --includedir=${STAGING_INCDIR_NATIVE}/classpath-initial \
  "

SRC_URI[md5sum] = "ffa9e9cac31c5acbf0ea9eff9efa923d"
SRC_URI[sha256sum] = "df2d093612abd23fe67e9409d89bb2a8e79b1664fe2b2da40e1c8ed693e32945"
