SUMMARY = "Initial Java 1.4-compatible (and not higher) compiler"

DEPENDS = "jikes-native classpath-initial"

# Packaged-staging needs a Source: field to put in the packages, so SRC_URI can't be empty
SRC_URI = "file://dummy"

S = "${WORKDIR}"

inherit native

do_configure() {
 :
}

do_compile() {
  echo "#!/bin/sh" > jikes-initial
  echo "${STAGING_BINDIR_NATIVE}/jikes -bootclasspath ${STAGING_DATADIR_NATIVE}/classpath-initial/glibj.zip \$@" >> jikes-initial
}

do_stage() {
  install -d ${STAGING_BINDIR}
  install -m 0755 jikes-initial ${STAGING_BINDIR}
}
