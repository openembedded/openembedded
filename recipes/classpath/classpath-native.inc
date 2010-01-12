DESCRIPTION = "GNU Classpath standard Java libraries - For native Java-dependent programs"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"

inherit autotools native

DEPENDS = "ecj-initial fastjar-native zip-native gettext-native"

SRC_URI = "${GNU_MIRROR}/classpath/classpath-${PV}.tar.gz"

do_configure_prepend () {

	cp ${STAGING_DATADIR_NATIVE}/gettext/config.rpath ${S}
}

export JAVA="${STAGING_BINDIR_NATIVE}/java-initial"
export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"
export JAVACFLAGS="-nowarn"

# Note: the --with-ecj options seems redundant but is
# for compatibility with older classpath versions.
EXTRA_OECONF = "\
  --with-ecj=${STAGING_BINDIR_NATIVE}/ecj-initial \
  --with-glibj \
  --with-fastjar=fastjar \
  --enable-local-sockets \
  --disable-Werror \
  --disable-alsa \
  --disable-gconf-peer \
  --disable-gtk-peer \
  --disable-plugin \
  --disable-dssi \
  --disable-gjdoc \
  --enable-examples \
  --enable-tools \
  --includedir=${STAGING_INCDIR}/classpath \
  --with-vm=java \
  "

do_stage() {
	oe_runmake install
}
