DESCRIPTION = "Bean Scripting Framework package"
LICENSES = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/jakarta/bsf/source/bsf-src-${PV}.tar.gz"

inherit java-library

DEPENDS = "fastjar-native jacl commons-logging rhino xalan-j bcel"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s commons-logging jacl rhino bcel xalan2
  
	# Remove netrexx and jython support
  rm -Rf src/org/apache/bsf/engines/netrexx
  rm -Rf src/org/apache/bsf/engines/jython

  javac -sourcepath src -cp $cp -d build `find src -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}


SRC_URI[md5sum] = "7e58b2a009c0f70ab36bbef420b25c07"
SRC_URI[sha256sum] = "5ab58cf5738c144f4d85a4a442c2f33be2c4c502dca6e29e0c570c2a51ae6ae9"
