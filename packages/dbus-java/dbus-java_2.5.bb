DESCRIPTION = "A pure Java D-Bus Implementation"
DESCRIPTION_dbus-java-viewer = "${DESCRIPTION} (DBusViewer Binary)"
DESCRIPTION_dbus-java-bin = "${DESCRIPTION} (Binaries)"
AUTHOR = "Matthew Johnson <dbus@matthew.ath.cx>"
HOMEPAGE = "http://dbus.freedesktop.org/doc/dbus-java"
SECTION = "libs"
LICENSE = "LGPLv2 AFL"
DEPENDS = "libmatthew docbook-utils-native docbook-sgml-dtd-4.1-native fastjar-native"
RDEPENDS_dbus-java-viewer = "java2-runtime libunixsocket-java dbus-java-bin libmatthew-debug-java ${JPN}"
RDEPENDS_dbus-java-bin = "java2-runtime libunixsocket-java libmatthew-debug-java ${JPN}"
RSUGGESTS_libdbus-java = "libunixsocket-java"
PR = "r1"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-java/dbus-java-${PV}.tar.gz"

S = "${WORKDIR}/dbus-java-${PV}"

inherit java-library

# jamvm-native unfortunately contains non-generificed java/lang/reflect classes
# which are accessed in this package. Work around this by setting the bootclasspath
# explicitly.
JCFLAGS = "-bootclasspath ${STAGING_DATADIR}/classpath/glibj.zip"

do_compile () {
  oe_runmake \
	JCFLAGS="-source 1.5 ${JCFLAGS}" \
	JAVAC="javac" \
	JARPREFIX="${STAGING_DATADIR_JAVA}" \
	JAVAUNIXJARDIR="${STAGING_DATADIR_JAVA}" \
	CLASSPATH="${S}/classes" \
	JAR="fastjar" \
	bin

  # Generated shell scripts will have staging paths inside them.
	rm bin/*
  
	# Generate them again with target paths.
	oe_runmake \
		JAVAC="oefatal \"No Java compilation expected here.\"" \
		JAR="oefatal \"No jar invocation expected here.\"" \
		JARPREFIX=${datadir_java} \
		JAVAUNIXPATH=${datadir_java} \
		bin

	# Generate man pages.
	oe_runmake \
		JAVAC="oefatal \"No Java compilation expected here.\"" \
		JAR="oefatal \"No jar invocation expected here.\"" \
		JARPREFIX=${datadir_java} \
		JAVAUNIXPATH=${datadir_java} \
		man
}

do_install () {
  oe_jarinstall ${JPN}-${PV}.jar ${JPN}.jar dbus.jar
  oe_jarinstall dbus-java-viewer-${PV}.jar dbus-java-viewer.jar dbus-viewer.jar
  oe_jarinstall dbus-java-bin-${PV}.jar dbus-java-bin.jar dbus-bin.jar
  
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

do_stage () {
  oe_jarinstall -s ${JPN}-${PV}.jar ${JPN}.jar
}

PACKAGE_ARCH = "all"
# ${JPN} must be last otherwise it would pick up dbus-viewer*.jar
# and dbus-bin*.jar
PACKAGES = "dbus-java-viewer dbus-java-viewer-doc dbus-java-bin dbus-java-bin-doc ${JPN}"

FILES_dbus-java-viewer = "${datadir}/java/dbus-java-viewer*.jar ${bindir}/DBusViewer"
FILES_dbus-java-viewer-doc = "${mandir}/DBusViewer*"
FILES_dbus-java-bin = "${datadir}/java/dbus-java-bin*.jar ${bindir}"
FILES_dbus-java-bin-doc = "${mandir} ${docdir}/${JPN}"
