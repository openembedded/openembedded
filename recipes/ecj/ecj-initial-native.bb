# ECJ as a bootstrap compiler is a drop-in replacement for Sun's javac. It offers no more
# and no less features.

# This variant runs on the initial (not Java5-compatible runtime).

DESCRIPTION = "JDT Core Batch Compiler - Bootstrap variant"
HOMEPAGE = "http://www.eclipse.org/"
LICENSE = "EPL"

DEPENDS = "libecj-bootstrap"

PR = "r2"

SRC_URI = "file://ecj-initial.in"

NATIVE_INSTALL_WORKS = "1"

S = "${WORKDIR}"

inherit native

JAR = "ecj-bootstrap.jar"

do_compile() {
  # Create the start script
  echo "#!/bin/sh" > ecj-initial
  echo "ECJ_JAR=${STAGING_DATADIR}/java/${JAR}" >> ecj-initial
  echo "RUNTIME=java-initial" >> ecj-initial
  cat ecj-initial.in >> ecj-initial
}

do_install() {
  install -d ${D}${bindir}
  install -m 755 ${S}/ecj-initial ${D}${bindir}
}
