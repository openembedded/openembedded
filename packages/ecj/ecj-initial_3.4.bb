# ECJ as a bootstrap compiler is a drop-in replacement for Sun's javac. It offers no more
# and no less features.

# This variant runs on the initial (not Java5-compatible runtime).

DESCRIPTION = "JDT Core Batch Compiler - Bootstrap variant"
HOMEPAGE = "http://www.eclipse.org/"
LICENSE = "EPL"

DEPENDS = "fastjar-native jikes-initial virtual/java-initial"

SRC_URI = "\
    http://mirrors.ibiblio.org/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.4-200806172000/ecjsrc-3.4.zip \
    file://ecj.in \
    "

S = "${WORKDIR}"

inherit native

JAR = "ecj-bootstrap-${PV}.jar"

do_unpackpost() {
  if [ ! -d source ]; then
    mkdir source
  fi

  if [ ! -d build ]; then
    mkdir build
  fi

  # Remove crap.
  rm about.html build.xml
  rm -rf META-INF

  # Move source into separate subdir.
  mv org source/

  # Remove stuff unneeded for the bootstrap compiler.
  rm -rf source/org/eclipse/jdt/internal/compiler/apt
  rm -rf source/org/eclipse/jdt/internal/compiler/tool
  rm -rf source/org/eclipse/jdt/internal/antadapter
  rm source/org/eclipse/jdt/core/JDTCompilerAdapter.java

  # Make a copy of the remaining source to get the embedded
  # resources.
  cp -r source/org build/

  # Remove source code and other stuff.
  find build -name '*.java' -exec rm -f {} \;
  find build -name '*.html' -exec rm -f {} \;
}

addtask unpackpost after do_unpack before do_patch

do_compile() {
  find source -name '*.java' > sourcefiles
  split -l 25 sourcefiles ecj-sources.

  # Compiling in place is done because the sources contain
  # property files which need to be available at runtime.
  for list in `find . -name 'ecj-sources.*'`; do
      echo "building files in $list ...";
      echo jikes-initial -d build -source 1.4 -sourcepath source `cat $list`;
      jikes-initial \
				-d build -source 1.4 -sourcepath source `cat $list`;
  done

  fastjar -c -C build . -f ${JAR}

  # Create the start script
  echo "#!/bin/sh" > ecj-initial
  echo "ECJ_JAR=${STAGING_DATADIR}/java/${JAR}" >> ecj-initial
  echo "RUNTIME=java-initial" >> ecj-initial
  cat ecj.in >> ecj-initial
}

do_stage() {
  install -d ${STAGING_DATADIR}/java
  install -m 755 ${S}/${JAR} ${STAGING_DATADIR}/java

  install -d ${STAGING_BINDIR}
  install -m 755 ${S}/ecj-initial ${STAGING_BINDIR}
}
