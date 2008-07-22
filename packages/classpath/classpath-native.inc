DESCRIPTION = "GNU Classpath standard Java libraries - For native Java-dependent programs"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"

S = "${WORKDIR}/classpath-${PV}"

SRC_URI = "${GNU_MIRROR}/classpath/classpath-${PV}.tar.gz"

DEPENDS = "ecj-initial fastjar-native zip-native"

inherit autotools native

# Newer versions expect setting the compiler through this
# environment variable.
export JAVAC=${STAGING_BINDIR_NATIVE}/ecj-initial

EXTRA_OECONF = "\
  --with-glibj \
  --with-ecj=${STAGING_BINDIR_NATIVE}/ecj-initial \
  --with-fastjar=fastjar \
  --enable-local-sockets \
  --disable-alsa \
  --disable-gconf-peer \
  --disable-gtk-peer \
  --disable-plugin \
  --disable-dssi \
  --enable-examples \
  --enable-tools \
  --includedir=${STAGING_INCDIR}/classpath \
  --with-vm=java \
  "

do_stage() {
	oe_runmake install
}

