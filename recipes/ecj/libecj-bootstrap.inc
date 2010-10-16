# This package compiles and stages only the Jar.

DESCRIPTION = "JDT Core Batch Compiler - Jar only"
HOMEPAGE = "http://www.eclipse.org/"
LICENSE = "EPL"

DEPENDS = "fastjar-native jikes-initial virtual/java-initial"

inherit native java

S = "${WORKDIR}"

JAR = "ecj-bootstrap-${PV}.jar"

NATIVE_INSTALL_WORKS = "1"

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
  cp -R source/org build/

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
}

do_install() {
  oe_jarinstall ${JAR} ecj-bootstrap.jar
}

