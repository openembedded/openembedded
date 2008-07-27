# ECJ as a bootstrap compiler is a drop-in replacement for Sun's javac. It offers no more
# and no less features.
#
# Since the VM running the compiler has no effect on the produced bytecode this recipe
# uses the jar created by ecj-initial and creates a start script that runs it with a different
# VM.

DESCRIPTION = "JDT Core Batch Compiler - Bootstrap variant"
HOMEPAGE = "http://www.eclipse.org/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "EPL"

DEPENDS = "ecj-initial virtual/java-native"

PROVIDES = "virtual/javac-native"

SRC_URI = "file://ecj.in"

S = "${WORKDIR}"

JAR = "ecj-bootstrap-${PV}.jar"

inherit native

do_compile() {
  # Create the start script
  echo "#!/bin/sh" > ecj-bootstrap
  echo "ECJ_JAR=${STAGING_DATADIR}/java/${JAR}" >> ecj-bootstrap
  echo "RUNTIME=java" >> ecj-bootstrap
  cat ecj.in >> ecj-bootstrap
}

do_stage() {
  install -d ${STAGING_BINDIR}
  install -m 755 ${S}/ecj-bootstrap ${STAGING_BINDIR}
  install -m 755 ${S}/ecj-bootstrap ${STAGING_BINDIR}/javac
}
