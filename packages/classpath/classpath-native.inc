DESCRIPTION = "GNU Classpath standard Java libraries - For native Java-dependent programs"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"

S = "${WORKDIR}/classpath-${PV}"

SRC_URI = "${GNU_MIRROR}/classpath/classpath-${PV}.tar.gz"

DEPENDS = "ecj-initial fastjar-native zip-native gettext-native"

inherit autotools native

export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"

# Note: the --with-ecj options seems redundant but is
# for compatibility with older classpath versions.
EXTRA_OECONF = "\
  --with-ecj=${STAGING_BINDIR_NATIVE}/ecj-initial \
  --with-glibj \
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
# hack to get config.rpath in, it comes from gettext
do_configure_prepend () {

        ${@['','cp ${STAGING_DATADIR}/automake-1.10/config.rpath ${S}'][bb.data.getVar('PREFERRED_VERSION_automake-native',d,1) == '1.10']}

}

do_stage() {
	oe_runmake install
}

