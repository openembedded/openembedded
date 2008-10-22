DESCRIPTION = "A pure Java D-Bus Implementation"
DESCRIPTION_dbus-java-viewer = "${DESCRIPTION} (DBusViewer Binary)"
DESCRIPTION_dbus-java-bin = "${DESCRIPTION} (Binaries)"

LICENSE = "GPLv2 AFL"
SECTION = "libs"
HOMEPAGE = "http://dbus.freedesktop.org/doc/dbus-java"
AUTHOR = "Matthew Johnson <dbus@matthew.ath.cx>"

PR = "r4"

inherit java-library

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-java/dbus-java-${PV}.tar.gz"

S = "${WORKDIR}/dbus-java-${PV}"

DEPENDS = "libmatthew docbook-utils-native docbook-sgml-dtd-4.1-native fastjar-native"
RSUGGESTS_libdbus-java = "libunixsocket-java dbus"
RDEPENDS_dbus-java-viewer = "java2-runtime libunixsocket-java ${JPN}"
RDEPENDS_dbus-java-bin = "java2-runtime libunixsocket-java ${JPN}"

# jamvm-native unfortunately contains non-generificed java/lang/reflect classes
# which are accessed in this package. Work around this by setting the bootclasspath
# explicitly.
JCFLAGS = "-bootclasspath ${STAGING_DATADIR}/classpath/glibj.zip"

do_compile () {
  # run target .binclasses first to fix a brokenness in the Makefile
	oe_runmake \
    JCFLAGS="-source 1.5 ${JCFLAGS}" \
    JAVAC="javac" \
    JARPREFIX="${STAGING_DATADIR_JAVA}" \
    JAVAUNIXJARDIR="${STAGING_DATADIR_JAVA}" \
    CLASSPATH="${S}/classes" \
    JAR="fastjar" \
    .binclasses

	oe_runmake \
    JCFLAGS="-source 1.5 ${JCFLAGS}" \
    JAVAC="javac" \
    JARPREFIX="${STAGING_DATADIR_JAVA}" \
    JAVAUNIXJARDIR="${STAGING_DATADIR_JAVA}" \
    CLASSPATH="${S}/classes" \
    JAR="fastjar" \
    all

  # Generated shell scripts will have staging paths inside them.
  rm bin/*

  # Generate them again with target paths.
  oe_runmake \
    JAVAC="oefatal \"No Java compilation expected here.\"" \
    JAR="oefatal \"No jar invocation expected here.\"" \
    JARPREFIX=${datadir_java} \
    JAVAUNIXPATH=${datadir_java} \
    all

  # Trigger generation of all documentation files to prevent this
  # being happen at the target 'install-man' in do_install.
  oe_runmake \
    JAVAC="oefatal \"No Java compilation expected here.\"" \
    JAR="oefatal \"No jar invocation expected here.\"" \
    JARPREFIX=${datadir_java} \
    JAVAUNIXPATH=${datadir_java} \
    CreateInterface.1 ListDBus.1 DBusDaemon.1 DBusViewer.1 changelog AUTHORS COPYING README INSTALL DBusCall.1
}

do_stage () {
  oe_jarinstall -s ${JPN}-${PV}.jar ${JPN}.jar
}

do_install () {
  oe_jarinstall ${JPN}-${PV}.jar ${JPN}.jar
  oe_jarinstall dbus-java-viewer-${PV}.jar dbus-java-viewer.jar
  oe_jarinstall dbus-java-bin-${PV}.jar dbus-java-bin.jar

  install -d ${D}${bindir}
  install bin/DBusViewer ${D}${bindir}
  install bin/DBusCall ${D}${bindir}
  install bin/CreateInterface ${D}${bindir}
  install bin/ListDBus ${D}${bindir}
  install bin/DBusDaemon ${D}${bindir}

  oe_runmake \
    JAVAC="oefatal \"No Java compilation expected here.\"" \
    JAR="oefatal \"No jar invocation expected here.\"" \
    MANPREFIX=${D}${mandir} \
    DOCPREFIX=${D}${docdir}/${JPN} \
    install-man
}

# ${JPN} must be last otherwise it would pick up dbus-viewer*.jar
# and dbus-bin*.jar
PACKAGES = "dbus-java-viewer dbus-java-viewer-doc dbus-java-bin dbus-java-bin-doc ${JPN}"

PACKAGE_ARCH = "all"

FILES_dbus-java-viewer = "${datadir}/java/dbus-java-viewer*.jar ${bindir}/DBusViewer"
FILES_dbus-java-viewer-doc = "${mandir}/DBusViewer*"
FILES_dbus-java-bin = "${datadir}/java/dbus-java-bin*.jar ${bindir}"
FILES_dbus-java-bin-doc = "${mandir} ${docdir}/${JPN}"
