# ECJ as a bootstrap compiler is a drop-in replacement for Sun's javac. It offers no more
# and no less features.

# This variant runs on the initial (not Java5-compatible runtime).

DESCRIPTION = "JDT Core Batch Compiler - Bootstrap variant"
HOMEPAGE = "http://www.eclipse.org/"
LICENSE = "EPL"

DEPENDS = "libecj-bootstrap"

PR = "r1"

SRC_URI = "file://ecj.in"

S = "${WORKDIR}"

inherit native

JAR = "ecj-bootstrap.jar"

do_compile() {
  # Create the start script
  echo "#!/bin/sh" > ecj-initial
  echo "ECJ_JAR=${STAGING_DATADIR}/java/${JAR}" >> ecj-initial
  echo "RUNTIME=java-initial" >> ecj-initial
  cat ecj.in >> ecj-initial
}

do_stage() {
  install -d ${STAGING_BINDIR}
  install -m 755 ${S}/ecj-initial ${STAGING_BINDIR}
}
